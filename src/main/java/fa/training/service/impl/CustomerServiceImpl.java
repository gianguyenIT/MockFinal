package fa.training.service.impl;

import fa.training.dto.CustomerDTO;
import fa.training.entity.Customer;
import fa.training.mapper.CustomerMapper;
import fa.training.repository.CustomerRepository;
import fa.training.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    CustomerMapper  mapper;

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = repository.findAll();
        return customers == null || customers.size() == 0 ? new ArrayList<>()
                : customers.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> customer = repository.findById(id);
        return customer != null && customer.isPresent() ? mapper.convertEntityToDTO(customer.get())
                : new CustomerDTO();
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        if (customerDTO == null) return new CustomerDTO();
        Customer customer = repository.save(mapper.convertDTOToEntity(customerDTO));
        return customer == null ? new CustomerDTO() : mapper.convertEntityToDTO(customer);
    }

    @Override
    public int update(CustomerDTO customerDTO) {
        if (customerDTO == null || customerDTO.getId() == null) return -1;
        Optional<Customer> customer = repository.findById(customerDTO.getId());
        if (customer != null && customer.isPresent()) {
            Customer customerUpdate =  repository.save(mapper.convertDTOToEntity(customerDTO));
            return customerUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(CustomerDTO customerDTO) {
        try {
            if (customerDTO == null || customerDTO.getId() == null) return false;
            Optional<Customer> customer = repository.findById((customerDTO.getId()));
            if (customer != null && customer.isPresent()) {
                repository.delete(customer.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

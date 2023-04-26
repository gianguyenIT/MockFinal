package fa.training.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "password", length =64)
    private String password;
    @Column(name = "first_name", length =45)
    private String firstName;
    @Column(name = "last_name", length =45)
    private String lastName;
    @Column(name = "phone_Number", length =10)
    private String phoneNumber;
    @Column(name = "address_id", length =45)
    private String addressId;
    @Column(name = "state")
    private String state;
    @Column(name = "postal_code", length =10)
    private String postalCode;
    @Column(name = "created_time")
    private Date createdTime;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "verify_code", length =64)
    private String verifyCode;
    @Column(name = "expire_verify_code")
    private Timestamp expireVerifyCode;
    @Column(name = "image_id")
    private String imageId;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<CartItems> cartItems;

    @ManyToMany
    private Set<Notification> notiCus;

}

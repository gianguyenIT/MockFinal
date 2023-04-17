package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = "/ping")
    public String ping() {
        System.out.println("hello");
        return "index";
    }

    @GetMapping(value = "/home")
    public String homePage(Model model) {
        model.addAttribute("pageTitle", "Home");
        return "index";
    }

    @GetMapping(value ="/shop")
    public String shop(Model model) {
        model.addAttribute("pageTitle", "Shop");
        return "shop";
    }

    @GetMapping(value ="/product")
    public String product(Model model) {
        model.addAttribute("pageTitle", "Product");
        return "product";
    }


    @GetMapping(value = "/cart")
    public String cart(Model model) {
        model.addAttribute("pageTitle", "Cart");
        return "cart";
    }

    @GetMapping(value ="/checkout")
    public String checkOut(Model model) {
        model.addAttribute("pageTitle", "Check Out");
        return "checkout";
    }

    @GetMapping(value ="/contact")
    public String contact(Model model) {
        model.addAttribute("pageTitle", "Contact");
        return "contact";
    }
}

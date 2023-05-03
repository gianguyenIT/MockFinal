package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping(value = {"/home", "/"})
    public String homePage(Model model) {
        model.addAttribute("home", Boolean.TRUE); // Active Home Nav Bar
        model.addAttribute("shop", Boolean.FALSE);
        model.addAttribute("product", Boolean.FALSE);
        model.addAttribute("contact", Boolean.FALSE);
        model.addAttribute("pageTitle", "Home");
        model.addAttribute("direction", "container/home");
        return "index";
    }

    @GetMapping(value ="/shop")
    public String shop(Model model) {
        model.addAttribute("home", Boolean.FALSE);
        model.addAttribute("shop", Boolean.TRUE); // Active Shop Nav Bar
        model.addAttribute("product", Boolean.FALSE);
        model.addAttribute("contact", Boolean.FALSE);
        model.addAttribute("pageTitle", "Shop");
        model.addAttribute("direction", "container/shop");
        return "index";
    }

    @GetMapping(value ="/product")
    public String product(Model model) {
        model.addAttribute("home", Boolean.FALSE);
        model.addAttribute("shop", Boolean.FALSE);
        model.addAttribute("product", Boolean.TRUE); // Active Product Nav Bar
        model.addAttribute("contact", Boolean.FALSE);
        model.addAttribute("pageTitle", "Product");
        model.addAttribute("direction", "container/product");
        return "index";
    }


    @GetMapping(value = "/cart")
    public String cart(Model model) {
        model.addAttribute("pageTitle", "Cart");
        model.addAttribute("direction", "container/cart");
        return "index";
    }

    @GetMapping(value ="/checkout")
    public String checkOut(Model model) {
        model.addAttribute("pageTitle", "Check Out");
        model.addAttribute("direction", "container/checkout");
        return "index";
    }

    @GetMapping(value ="/contact")
    public String contact(Model model) {
        model.addAttribute("home", Boolean.FALSE);
        model.addAttribute("shop", Boolean.FALSE);
        model.addAttribute("product", Boolean.FALSE);
        model.addAttribute("contact", Boolean.TRUE); // Active Contact Nav Bar
        model.addAttribute("pageTitle", "Contact");
        model.addAttribute("direction", "container/contact");
        return "index";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model) {
        model.addAttribute("pageTitle", "Profile");
        model.addAttribute("direction", "container/profile");
        return "index";
    }

    @GetMapping(value = "/purchase")
    public String purchase(Model model) {
        model.addAttribute("pageTitle", "Purchase");
        model.addAttribute("direction", "container/purchase");
        model.addAttribute("state", "To Receive");
        return "index";
    }
}

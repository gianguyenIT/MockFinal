package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = "/ping")
    public String ping() {
        System.out.println("hello");
        return "index";
    }

    @GetMapping(value = "/home")
    public String homePage() {
        return "index";
    }

    @GetMapping(value = "/test")
    public String test() {
        return "chotuitest";
    }

    @GetMapping(value ="/shop")
    public String shop() {
        return "shop";
    }

}

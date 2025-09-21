package crafter.spring_crafter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CrafterController {

    @GetMapping("hello")
    public String hello(Model model) {

        model.addAttribute("data", "spring!");
        return "hello";
    }
}

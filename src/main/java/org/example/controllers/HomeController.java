package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home"; // имя шаблона
    }
    @PostMapping("/deleteUserSQL")
    public ModelAndView deleteUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteUserSQL"); // или другую страницу с сообщением об успешном удалении
        return modelAndView;
    }

    @PostMapping("/deleteDBSQL")
    public ModelAndView deleteDB() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteDBSQL"); // или другую страницу с сообщением об успешном выполнении
        return modelAndView;
    }
}

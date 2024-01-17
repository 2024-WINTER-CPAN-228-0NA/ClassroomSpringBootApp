package org.humber.ClassroomSpringBootApp.controllers;

import org.humber.ClassroomSpringBootApp.services.Database;
import org.humber.ClassroomSpringBootApp.services.serviceImpl.OracleDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class HomeController {

    private Database database;

    public HomeController(Database database) {
        this.database = database;
    }

    @GetMapping("/a")
    public String index(Model model) {
        model.addAttribute("message", database.getMessage());
        model.addAttribute("numbers", Arrays.asList(1,2,3,4,5));
        return "index";
    }

    @PostMapping("/save1")
    public String save() {
        return "response";
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "hello world";
    }

}

package org.humber.ClassroomSpringBootApp.controllers;

import org.humber.ClassroomSpringBootApp.services.Database;
import org.humber.ClassroomSpringBootApp.services.serviceImpl.OracleDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class HomeController {

    private Database database;

    public HomeController(Database database) {
        this.database = database;
    }

    @GetMapping("/a")
    public String index(Model model) {
        Student student = new Student();
        student.setStudentId(1);
        student.setStudentName("John");
        System.out.println(student);
        model.addAttribute("student", student);
        model.addAttribute("message", database.getMessage());
        model.addAttribute("numbers", Arrays.asList(1,2,3,4,5));
        return "index";
    }

    @PostMapping("/save1")
    public String save() {
        return "response";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String home(@PathVariable String id) {
        return "hello world";
    }

}

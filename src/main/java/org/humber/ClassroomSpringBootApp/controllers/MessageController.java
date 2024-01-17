package org.humber.ClassroomSpringBootApp.controllers;

import org.humber.ClassroomSpringBootApp.services.Database;
import org.humber.ClassroomSpringBootApp.services.serviceImpl.MySQLDatabase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private Database database;

    public MessageController(Database database){
        this.database = database;
    }

    @GetMapping("/message")
    public String getMessage() {
        return database.getMessage();
    }
}

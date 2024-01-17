package org.humber.ClassroomSpringBootApp.services.serviceImpl;


import org.humber.ClassroomSpringBootApp.services.Database;
import org.springframework.stereotype.Component;

@Component
public class OracleDatabase {

    public String getMessage() {
        return "Hello World Oracle";
    }
}

package com.mehmethalman.courierservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

@SpringBootApplication
public class CourierServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CourierServiceApplication.class);


        app.setDefaultProperties(Collections.singletonMap("spring.liquibase.change-log", "classpath:db/changelog/db.changelog-master.xml"));

        app.run(args);
    }
}
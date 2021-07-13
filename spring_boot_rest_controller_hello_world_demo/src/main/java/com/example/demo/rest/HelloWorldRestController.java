package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

/*
    The @RestController is a convenience annotation for creating Restful controllers.
    The @RestController will convert the response to JSON or XML for you.
*/
@RestController
public class HelloWorldRestController {
    /*
        The HTTP methods in your controller can be annotated with one of the following
        Mapping annotations to specify the HTTP method they will handle: @GetMapping,
        @PostMapping, @PutMapping, and @DeleteMapping.
    */
    //Default controller
    @GetMapping("/") //The @GetMapping("/") is the default mapping.
    public String helloWorld() {
        return "Hello World! Time on server is: " + LocalDateTime.now();
    }

    //Additional controller
    @GetMapping("/hello") //The @GetMapping("/hello") is the mapping for another controller.
    public String welcomeSpringBoot() {
        return "Welcome to Spring Boot! Time on server is: " + LocalDateTime.now();
    }
}

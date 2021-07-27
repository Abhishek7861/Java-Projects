package com.example.demo.Controller;

import com.example.demo.Repository.Repository;
import com.example.demo.Response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    Repository userRepository;

    @GetMapping("/hello")
    public ResponseEntity<Object> hello(){
        return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, null);
    }
}


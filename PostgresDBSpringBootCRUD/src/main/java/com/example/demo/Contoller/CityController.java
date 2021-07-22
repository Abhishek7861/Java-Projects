package com.example.demo.Contoller;

import com.example.demo.Model.CityModel;
import com.example.demo.Service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    CityService cityService;

    @GetMapping("getcity")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getCities(){
        logger.info("Received a GET Request: /getcities ");
        return cityService.getCities();
    }

    @PostMapping("addcity")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addCity(@RequestBody CityModel cityModel){
        logger.info("Received a POST Request: /addcity");
        return cityService.saveCity(cityModel);
    }

    @GetMapping("/getcity/{cityName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getCity(@PathVariable String cityName){
        logger.info("Received a GET Request: /getcity/"+cityName);
        return cityService.getCity(cityName);
    }

    @DeleteMapping("/deletecity/{cityName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteCity(@PathVariable String cityName){
        logger.info("Received a DELETE Request: /deletecity/"+cityName);
        return cityService.deleteCity(cityName);
    }
}
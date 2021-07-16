package com.example.demo.contollers;

import com.example.demo.entities.City;
import com.example.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeControllers {

    @Autowired
    CityService cityService;

    @GetMapping("sayHello")
    public String sayHello(){
        return "Hello User";
    }

    @GetMapping("getcities")
    @ResponseStatus(HttpStatus.OK)
    public List<City> getCities(){
        return cityService.getCities();
    }

    @PostMapping("addcity")
    @ResponseStatus(HttpStatus.CREATED)
    public City addCity(@RequestBody City city){
        return cityService.saveCity(city);
    }

    @GetMapping("/getcity/{cityName}")
    @ResponseStatus(HttpStatus.OK)
    public City getCity(@PathVariable String cityName){
        return cityService.getCity(cityName);
    }

    @DeleteMapping("/deletecity/{cityName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable String cityName){
        cityService.deleteCity(cityName);
    }
}
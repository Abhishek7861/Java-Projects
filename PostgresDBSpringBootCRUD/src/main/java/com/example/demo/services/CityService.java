package com.example.demo.services;

import com.example.demo.Repositories.CityRepositories;
import com.example.demo.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepositories cityRepository;

    public CityService(){

    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public City getCity(String cityName) {
        return cityRepository.findByCityname(cityName);
    }

    public void deleteCity(String cityName) {
        System.out.println(cityName);
        int retval = cityRepository.deleteCityname(cityName);
    }
}

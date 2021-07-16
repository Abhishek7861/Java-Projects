package com.example.demo.Repositories;

import com.example.demo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepositories extends JpaRepository<City, Long> {

    City findByCityname(String cityname);
}

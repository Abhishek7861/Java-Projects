package com.example.demo.Repositories;

import com.example.demo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CityRepositories extends JpaRepository<City, Long> {

    City findByCityname(String cityname);

    @Modifying
    @Query("delete from City a where a.cityname = :cityname")
    int deleteCityname(@Param("cityname") String cityname);
}

package com.example.demo.Repository;

import com.example.demo.Model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<CityModel, Long> {

    CityModel findByCityname(String cityname);

    @Modifying
    @Query("delete from CityModel a where a.cityname = :cityname")
    int deleteCityname(@Param("cityname") String cityname);
}

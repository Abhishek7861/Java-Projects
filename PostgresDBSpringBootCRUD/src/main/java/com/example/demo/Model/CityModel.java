package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class CityModel {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "city_name")
    private String cityname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @Override
    public String toString() {
        return "CityModel{" +
                "id=" + id +
                ", cityname='" + cityname + '\'' +
                '}';
    }
}

package com.example.demo.Service;

import com.example.demo.Contoller.CityController;
import com.example.demo.Model.CityModel;
import com.example.demo.Repository.CityRepository;
import com.example.demo.Response.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    Logger logger = LoggerFactory.getLogger(CityService.class);

    public CityService(){

    }

    public ResponseEntity<Object> getCities() {
        logger.info("Querying Database");
        List<CityModel> retval = cityRepository.findAll();
        logger.info("Fetched cities from Database: "+retval);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK,retval);
    }

    public ResponseEntity<Object> saveCity(CityModel cityModel){
        logger.info("Saving record: "+cityModel.getCityname());
        cityModel.setCityname(cityModel.getCityname().toLowerCase());
        CityModel retval = cityRepository.save(cityModel);
        logger.info("Saved record: "+cityModel);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK,retval);
    }

    public ResponseEntity<Object> getCity(String cityName) {
        logger.info("Fetching CityName: "+cityName+" from Database");
        CityModel retval = cityRepository.findByCityname(cityName);
        logger.info("Fetched city from Database: "+retval);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK,retval);
    }

    public ResponseEntity<Object> deleteCity(String cityName) {
        logger.info("Deleting CityName: "+cityName+" from Database");
        int retval = cityRepository.deleteCityname(cityName);
        if(retval>0){
            logger.info("Deleted CityName: "+cityName+" from Database");
            return ResponseHandler.generateResponse("Delete Success", HttpStatus.OK,cityName);

        }
        else{
            logger.info("CityName: "+cityName+" NOT EXISTS inDatabase");
            return ResponseHandler.generateResponse(cityName+" NOT EXISTS! Delete Failed", HttpStatus.BAD_REQUEST,cityName);
        }
    }
}

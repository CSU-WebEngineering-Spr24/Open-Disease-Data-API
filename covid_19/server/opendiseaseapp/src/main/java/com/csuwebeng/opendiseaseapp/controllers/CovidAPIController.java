package com.csuwebeng.opendiseaseapp.controllers;

import com.csuwebeng.opendiseaseapp.models.CovidContinentData;
import com.csuwebeng.opendiseaseapp.models.CovidCountryData;
import com.csuwebeng.opendiseaseapp.models.CovidGlobalData;
import com.csuwebeng.opendiseaseapp.models.CovidStateData;
import com.csuwebeng.opendiseaseapp.services.CovidAPIDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cache.annotation.Cacheable;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CovidAPIController {

    @Autowired
    private  CovidAPIDataService covidAPIDataService;

    @Cacheable(value = "globalDataCache")
    @GetMapping("/global")
    public CovidGlobalData getGlobalData() {
        return covidAPIDataService.getGlobalData();
    }

    @GetMapping("/states")
    @Cacheable(value = "statesDataCache")
    public CovidStateData[] getStateData() {
        return covidAPIDataService.getStateData();
    }

    @GetMapping("/continents")
    @Cacheable(value = "continentsDataCache")
    public CovidContinentData[] getContinentData() {
        return covidAPIDataService.getContinentData();
    }

    @GetMapping("/countries")
    @Cacheable(value = "countriesDataCache")
    public CovidCountryData[] getCountryData() {
        return covidAPIDataService.getCountryData();
    }

    public CovidAPIDataService getCovidAPIDataService() {
        return covidAPIDataService;
    }

    public void setCovidAPIDataService(CovidAPIDataService covidAPIDataService) {
        this.covidAPIDataService = covidAPIDataService;
    }
}


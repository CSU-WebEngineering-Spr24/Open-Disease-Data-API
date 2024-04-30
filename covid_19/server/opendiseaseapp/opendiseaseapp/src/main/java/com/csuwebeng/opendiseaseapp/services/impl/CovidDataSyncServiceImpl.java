package com.csuwebeng.opendiseaseapp.services.impl;

import com.csuwebeng.opendiseaseapp.dao.impl.ContinentDataRepository;
import com.csuwebeng.opendiseaseapp.dao.impl.CountryDataRepository;
import com.csuwebeng.opendiseaseapp.dao.impl.GlobalDataRepository;
import com.csuwebeng.opendiseaseapp.dao.impl.StateDataRepository;
import com.csuwebeng.opendiseaseapp.entities.ContinentData;
import com.csuwebeng.opendiseaseapp.entities.CountryData;
import com.csuwebeng.opendiseaseapp.entities.GlobalData;
import com.csuwebeng.opendiseaseapp.entities.StateData;
import com.csuwebeng.opendiseaseapp.models.CovidContinentData;
import com.csuwebeng.opendiseaseapp.models.CovidCountryData;
import com.csuwebeng.opendiseaseapp.models.CovidGlobalData;
import com.csuwebeng.opendiseaseapp.models.CovidStateData;
import com.csuwebeng.opendiseaseapp.services.CovidDataService;
import com.csuwebeng.opendiseaseapp.services.CovidDataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CovidDataSyncServiceImpl implements CovidDataSyncService {

    @Autowired
    private CovidDataService covidDataService;

    @Autowired
    private GlobalDataRepository globalDataRepository;

    @Autowired
    private StateDataRepository stateDataRepository;

    @Autowired
    private ContinentDataRepository continentDataRepository;

    @Autowired
    private CountryDataRepository countryDataRepository;
//    3600000 hour
    @Scheduled(fixedRate = 120000) // Run every hour
    public void syncCovidData() {
        // Fetch data from APIs
        CovidGlobalData globalData = covidDataService.getGlobalData();
        CovidStateData[] stateData = covidDataService.getStateData();
        CovidContinentData[] continentData = covidDataService.getContinentData();
        CovidCountryData[] countryData = covidDataService.getCountryData();

        // Save data to the database
        cleanData();
        globalDataRepository.save(mapToGlobalDataEntity(globalData));
        stateDataRepository.saveAll(mapToStateDataEntities(stateData));
        continentDataRepository.saveAll(mapToContinentDataEntities(continentData));
        countryDataRepository.saveAll(mapToCountryDataEntities(countryData));
    }
    private void cleanData() {
        // Clean data from all tables
        globalDataRepository.deleteAll();
        stateDataRepository.deleteAll();
        continentDataRepository.deleteAll();
        countryDataRepository.deleteAll();
    }

    // Helper methods to map data to entity objects
    private GlobalData mapToGlobalDataEntity(CovidGlobalData globalData) {
        GlobalData entity = new GlobalData();
        entity.setLastUpdated(new Date(globalData.getUpdated()));
        entity.setTotalCases(globalData.getCases());
        entity.setTodayCases(globalData.getTodayCases());
        entity.setTotalDeaths(globalData.getDeaths());
        entity.setTodayDeaths(globalData.getTodayDeaths());
        entity.setTotalRecovered(globalData.getRecovered());
        entity.setTodayRecovered(globalData.getTodayRecovered());
        entity.setActiveCases(globalData.getActive());
        entity.setCriticalCases(globalData.getCritical());
        entity.setCasesPerMillion(globalData.getCasesPerOneMillion());
        entity.setDeathsPerMillion(globalData.getDeathsPerOneMillion());
        entity.setTotalTests(globalData.getTests());
        entity.setTestsPerMillion(globalData.getTestsPerOneMillion());
        entity.setPopulation(globalData.getPopulation());
        return entity;
    }
    private List<StateData> mapToStateDataEntities(CovidStateData[] stateData) {
        List<StateData> entities = new ArrayList<>();
        for (CovidStateData data : stateData) {
            StateData entity = new StateData();
            entity.setState(data.getState());
            entity.setCases(data.getCases());
            entity.setTodayCases(data.getTodayCases());
            entity.setDeaths(data.getDeaths());
            entity.setTodayDeaths(data.getTodayDeaths());
            entity.setRecovered(data.getRecovered());
            entity.setActive(data.getActive());
            entity.setCasesPerMillion(data.getCasesPerOneMillion());
            entity.setDeathsPerMillion(data.getDeathsPerOneMillion());
            entity.setTests(data.getTests());
            entity.setTestsPerMillion(data.getTestsPerOneMillion());
            entity.setPopulation(data.getPopulation());
            entities.add(entity);
        }
        return entities;
    }
    private List<ContinentData> mapToContinentDataEntities(CovidContinentData[] continentData) {
        List<ContinentData> entities = new ArrayList<>();
        for (CovidContinentData data : continentData) {
            ContinentData entity = new ContinentData();
            entity.setContinent(data.getContinent());
            entity.setTotalCases(data.getCases());
            entity.setTodayCases(data.getTodayCases());
            entity.setTotalDeaths(data.getDeaths());
            entity.setTodayDeaths(data.getTodayDeaths());
            entity.setTotalRecovered(data.getRecovered());
            entity.setTodayRecovered(data.getTodayRecovered());
            entity.setActiveCases(data.getActive());
            entity.setCriticalCases(data.getCritical());
            entity.setCasesPerMillion(data.getCasesPerOneMillion());
            entity.setDeathsPerMillion(data.getDeathsPerOneMillion());
            entity.setTotalTests(data.getTests());
            entity.setTestsPerMillion(data.getTestsPerOneMillion());
            entity.setPopulation(data.getPopulation());
            entity.setCountries(String.join(", ", data.getCountries()));
            entities.add(entity);
        }
        return entities;
    }
    private List<CountryData> mapToCountryDataEntities(CovidCountryData[] countryData) {
        List<CountryData> countryDataEntities = new ArrayList<>();

        for (CovidCountryData data : countryData) {
            CountryData entity = new CountryData();
            entity.setCountry(data.getCountry());
            entity.setCountryCode(data.getCountryInfo().getIso2());
            entity.setTotalCases(data.getCases());
            entity.setTodayCases(data.getTodayCases());
            entity.setTotalDeaths(data.getDeaths());
            entity.setTodayDeaths(data.getTodayDeaths());
            entity.setTotalRecovered(data.getRecovered());
            entity.setTodayRecovered(data.getTodayRecovered());
            entity.setActiveCases(data.getActive());
            entity.setCriticalCases(data.getCritical());
            entity.setCasesPerMillion(data.getCasesPerOneMillion());
            entity.setDeathsPerMillion(data.getDeathsPerOneMillion());
            entity.setTotalTests(data.getTests());
            entity.setTestsPerMillion(data.getTestsPerOneMillion());
            entity.setPopulation(data.getPopulation());
            countryDataEntities.add(entity);
        }

        return countryDataEntities;
    }




}

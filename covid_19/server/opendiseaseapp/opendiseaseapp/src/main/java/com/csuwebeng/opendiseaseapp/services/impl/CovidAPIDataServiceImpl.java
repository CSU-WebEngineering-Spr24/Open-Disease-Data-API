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
import com.csuwebeng.opendiseaseapp.services.CovidAPIDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidAPIDataServiceImpl implements CovidAPIDataService {

    private final GlobalDataRepository globalDataRepository;
    private final StateDataRepository stateDataRepository;
    private final ContinentDataRepository continentDataRepository;
    private final CountryDataRepository countryDataRepository;

    @Autowired
    public CovidAPIDataServiceImpl(GlobalDataRepository globalDataRepository,
                                   StateDataRepository stateDataRepository,
                                   ContinentDataRepository continentDataRepository,
                                   CountryDataRepository countryDataRepository) {
        this.globalDataRepository = globalDataRepository;
        this.stateDataRepository = stateDataRepository;
        this.continentDataRepository = continentDataRepository;
        this.countryDataRepository = countryDataRepository;
    }

    @Override
    public CovidGlobalData getGlobalData() {
        List<GlobalData> globalData = globalDataRepository.findAll();
        if(globalData.size() == 1){
            return mapToGlobalDataModel(globalData.get(0));
        }
        return  new CovidGlobalData();
    }

    @Override
    public CovidStateData[] getStateData() {
        List<StateData> stateDataList = stateDataRepository.findAll();
        return mapToStateDataModels(stateDataList);
    }

    @Override
    public CovidContinentData[] getContinentData() {
        List<ContinentData> continentDataList = continentDataRepository.findAll();
        return mapToContinentDataModels(continentDataList);
    }

    @Override
    public CovidCountryData[] getCountryData() {
        List<CountryData> countryDataList = countryDataRepository.findAll();
        return mapToCountryDataModels(countryDataList);
    }

    private CovidGlobalData mapToGlobalDataModel(GlobalData globalData) {
        if (globalData == null) {
            return null;
        }
        CovidGlobalData data = new CovidGlobalData();
        data.setUpdated(globalData.getLastUpdated().getTime());
        data.setCases(globalData.getTotalCases());
        data.setTodayCases(globalData.getTodayCases());
        data.setDeaths(globalData.getTotalDeaths());
        data.setTodayDeaths(globalData.getTodayDeaths());
        data.setRecovered(globalData.getTotalRecovered());
        data.setTodayRecovered(globalData.getTodayRecovered());
        data.setActive(globalData.getActiveCases());
        data.setCritical(globalData.getCriticalCases());
        data.setCasesPerOneMillion(globalData.getCasesPerMillion());
        data.setDeathsPerOneMillion(globalData.getDeathsPerMillion());
        data.setTests(globalData.getTotalTests());
        data.setTestsPerOneMillion(globalData.getTestsPerMillion());
        data.setPopulation(globalData.getPopulation());
        return data;
    }

    private CovidStateData[] mapToStateDataModels(List<StateData> stateDataList) {
        List<CovidStateData> states = new ArrayList<>();
        for (StateData stateData : stateDataList) {
            CovidStateData data = new CovidStateData();
            data.setState(stateData.getState());
            data.setCases(stateData.getCases());
            data.setTodayCases(stateData.getTodayCases());
            data.setDeaths(stateData.getDeaths());
            data.setTodayDeaths(stateData.getTodayDeaths());
            data.setRecovered(stateData.getRecovered());
            data.setActive(stateData.getActive());
            data.setCasesPerOneMillion(stateData.getCasesPerMillion());
            data.setDeathsPerOneMillion(stateData.getDeathsPerMillion());
            data.setTests(stateData.getTests());
            data.setTestsPerOneMillion(stateData.getTestsPerMillion());
            data.setPopulation(stateData.getPopulation());
            states.add(data);
        }
        return states.toArray(new CovidStateData[0]);
    }

    private CovidContinentData[] mapToContinentDataModels(List<ContinentData> continentDataList) {
        List<CovidContinentData> continents = new ArrayList<>();
        for (ContinentData continentData : continentDataList) {
            CovidContinentData data = new CovidContinentData();
            data.setContinent(continentData.getContinent());
            data.setCases(continentData.getTotalCases());
            data.setTodayCases(continentData.getTodayCases());
            data.setDeaths(continentData.getTotalDeaths());
            data.setTodayDeaths(continentData.getTodayDeaths());
            data.setRecovered(continentData.getTotalRecovered());
            data.setTodayRecovered(continentData.getTodayRecovered());
            data.setActive(continentData.getActiveCases());
            data.setCritical(continentData.getCriticalCases());
            data.setCasesPerOneMillion(continentData.getCasesPerMillion());
            data.setDeathsPerOneMillion(continentData.getDeathsPerMillion());
            data.setTests(continentData.getTotalTests());
            data.setTestsPerOneMillion(continentData.getTestsPerMillion());
            data.setPopulation(continentData.getPopulation());
            data.setCountries(continentData.getCountries().split(", "));
            continents.add(data);
        }
        return continents.toArray(new CovidContinentData[0]);
    }

    private CovidCountryData[] mapToCountryDataModels(List<CountryData> countryDataList) {
        List<CovidCountryData> countries = new ArrayList<>();
        for (CountryData countryData : countryDataList) {
            CovidCountryData data = new CovidCountryData();
            data.setCountry(countryData.getCountry());
            data.setCases(countryData.getTotalCases());
            data.setTodayCases(countryData.getTodayCases());
            data.setDeaths(countryData.getTotalDeaths());
            data.setTodayDeaths(countryData.getTodayDeaths());
            data.setRecovered(countryData.getTotalRecovered());
            data.setTodayRecovered(countryData.getTodayRecovered());
            data.setActive(countryData.getActiveCases());
            data.setCritical(countryData.getCriticalCases());
            data.setCasesPerOneMillion(countryData.getCasesPerMillion());
            data.setDeathsPerOneMillion(countryData.getDeathsPerMillion());
            data.setTests(countryData.getTotalTests());
            data.setTestsPerOneMillion(countryData.getTestsPerMillion());
            data.setPopulation(countryData.getPopulation());
            countries.add(data);
        }
        return countries.toArray(new CovidCountryData[0]);
    }
}

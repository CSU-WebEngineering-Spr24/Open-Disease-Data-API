package com.csuwebeng.opendiseaseapp.services;

import com.csuwebeng.opendiseaseapp.models.CovidContinentData;
import com.csuwebeng.opendiseaseapp.models.CovidCountryData;
import com.csuwebeng.opendiseaseapp.models.CovidGlobalData;
import com.csuwebeng.opendiseaseapp.models.CovidStateData;

public interface CovidAPIDataService {
    CovidGlobalData getGlobalData();
    CovidStateData[] getStateData();
    CovidContinentData[] getContinentData();
    CovidCountryData[] getCountryData();
}

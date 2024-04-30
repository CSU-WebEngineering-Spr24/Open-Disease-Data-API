package com.csuwebeng.opendiseaseapp.services.impl;

import com.csuwebeng.opendiseaseapp.models.CovidContinentData;
import com.csuwebeng.opendiseaseapp.models.CovidCountryData;
import com.csuwebeng.opendiseaseapp.models.CovidGlobalData;
import com.csuwebeng.opendiseaseapp.models.CovidStateData;
import com.csuwebeng.opendiseaseapp.services.CovidDataService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.DeserializationFeature;

@Service
public class CovidDataServiceImpl implements CovidDataService {

    private final String BASE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public CovidDataServiceImpl(@Value("${covid.api.baseurl}") String baseUrl) {
        this.BASE_URL = baseUrl;
    }

    @Override
    public CovidGlobalData getGlobalData() {
        String url = BASE_URL + "all";
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        return parseGlobalData(response);
    }

    @Override
    public CovidStateData[] getStateData() {
        String url = BASE_URL + "states?sort=cases";
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        return parseStateData(response);
    }

    @Override
    public CovidContinentData[] getContinentData() {
        String url = BASE_URL + "continents?sort=cases";
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        return parseContinentData(response);
    }

    @Override
    public CovidCountryData[] getCountryData() {
        String url = BASE_URL + "countries?sort=cases";
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        return parseCountryData(response);
    }

    private CovidGlobalData parseGlobalData(JsonNode response) {
        return objectMapper.convertValue(response, CovidGlobalData.class);
    }

    private CovidStateData[] parseStateData(JsonNode response) {
        return objectMapper.convertValue(response, CovidStateData[].class);
    }

    private CovidContinentData[] parseContinentData(JsonNode response) {
        return objectMapper.convertValue(response, CovidContinentData[].class);
    }

    private CovidCountryData[] parseCountryData(JsonNode response) {
        return objectMapper.convertValue(response, CovidCountryData[].class);
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}

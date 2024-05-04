package com.csuwebeng.opendiseaseapp.services.imp;

import com.csuwebeng.opendiseaseapp.models.CovidContinentData;
import com.csuwebeng.opendiseaseapp.models.CovidCountryData;
import com.csuwebeng.opendiseaseapp.models.CovidStateData;
import com.csuwebeng.opendiseaseapp.services.impl.CovidDataServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CovidDataServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ObjectMapper objectMapper;

    private CovidDataServiceImpl covidDataService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        covidDataService = new CovidDataServiceImpl("https://disease.sh/v3/covid-19/");
        covidDataService.setRestTemplate(restTemplate);
        covidDataService.setObjectMapper(objectMapper);
    }

    @Test
    void getStateData() {
        String url = "https://disease.sh/v3/covid-19/states?sort=cases";
        JsonNode jsonResponse = mock(JsonNode.class); // Mocking the JsonNode response

        // Mocking restTemplate response
        when(restTemplate.getForObject(url, JsonNode.class)).thenReturn(jsonResponse);

        // Mocking objectMapper response
        when(objectMapper.convertValue(any(JsonNode.class), eq(CovidStateData[].class))).thenReturn(new CovidStateData[0]);

        assertNotNull(covidDataService.getStateData());

        // Verifying restTemplate method is called once
        verify(restTemplate, times(1)).getForObject(url, JsonNode.class);

        // Verifying objectMapper method is called once with any JsonNode argument
        verify(objectMapper, times(1)).convertValue(any(JsonNode.class), eq(CovidStateData[].class));
    }

    @Test
    void getContinentData() {
        String url = "https://disease.sh/v3/covid-19/continents?sort=cases";
        JsonNode jsonResponse = mock(JsonNode.class); // Mocking the JsonNode response

        // Mocking restTemplate response
        when(restTemplate.getForObject(url, JsonNode.class)).thenReturn(jsonResponse);

        // Mocking objectMapper response
        when(objectMapper.convertValue(any(JsonNode.class), eq(CovidContinentData[].class))).thenReturn(new CovidContinentData[0]);

        assertNotNull(covidDataService.getContinentData());

        // Verifying restTemplate method is called once
        verify(restTemplate, times(1)).getForObject(url, JsonNode.class);

        // Verifying objectMapper method is called once with any JsonNode argument
        verify(objectMapper, times(1)).convertValue(any(JsonNode.class), eq(CovidContinentData[].class));
    }

    @Test
    void getCountryData() {
        String url = "https://disease.sh/v3/covid-19/countries?sort=cases";
        JsonNode jsonResponse = mock(JsonNode.class); // Mocking the JsonNode response

        // Mocking restTemplate response
        when(restTemplate.getForObject(url, JsonNode.class)).thenReturn(jsonResponse);

        // Mocking objectMapper response
        when(objectMapper.convertValue(any(JsonNode.class), eq(CovidCountryData[].class))).thenReturn(new CovidCountryData[0]);

        assertNotNull(covidDataService.getCountryData());

        // Verifying restTemplate method is called once
        verify(restTemplate, times(1)).getForObject(url, JsonNode.class);

        // Verifying objectMapper method is called once with any JsonNode argument
        verify(objectMapper, times(1)).convertValue(any(JsonNode.class), eq(CovidCountryData[].class));
    }
}

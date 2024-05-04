# OpenDiseaseApp

## Overview
OpenDiseaseApp is a Spring Boot application designed to fetch and display COVID-19 data from various external APIs. It provides endpoints to retrieve global data, state-wise data, continent-wise data, and country-wise data related to COVID-19 cases, deaths, and recoveries. The application is aimed at providing up-to-date information on the COVID-19 pandemic to its users.

## Architecture

### Models
The application uses the following models to represent COVID-19 data:
- CovidGlobalData: Represents global COVID-19 data.
- CovidStateData: Represents COVID-19 data for a specific state.
- CovidContinentData: Represents COVID-19 data for a specific continent.
- CovidCountryData: Represents COVID-19 data for a specific country.

### Entities
The entities used in the application are mapped to the database tables:
- GlobalData: Entity representing global COVID-19 data.
- StateData: Entity representing COVID-19 data for a specific state.
- ContinentData: Entity representing COVID-19 data for a specific continent.
- CountryData: Entity representing COVID-19 data for a specific country.

### RestTemplate
The RestTemplate is used to make HTTP requests to external APIs to fetch COVID-19 data. It is configured as a bean and injected into the CovidDataServiceImpl service.

### External APIs
The application fetches COVID-19 data from the Disease.sh API. It uses various endpoints provided by the API to retrieve global, state-wise, continent-wise, and country-wise data.

### Controllers
- CovidDataController: Exposes endpoints to retrieve COVID-19 data, such as global data, state-wise data, continent-wise data, and country-wise data.

### Services
- CovidDataServiceImpl: Implements methods to fetch COVID-19 data from external APIs and map it to model objects.

### Schedulers
- CovidDataSyncService: Scheduled task that runs every hour to fetch and sync COVID-19 data from external APIs to the database.

### DAOs
The application uses repositories to interact with the database:
- GlobalDataRepository: Repository for GlobalData entity.
- StateDataRepository: Repository for StateData entity.
- ContinentDataRepository: Repository for ContinentData entity.
- CountryDataRepository: Repository for CountryData entity.

### Spring Security
The application utilizes Spring Security to protect its endpoints and authenticate users. Basic authentication is used to secure the /api endpoints.

## How It Works
1. The CovidDataSyncService runs every hour to fetch COVID-19 data from external APIs.
2. The fetched data is mapped to entity objects and saved to the database using repositories.
3. Endpoints provided by the CovidDataController can be accessed to retrieve COVID-19 data. Access to these endpoints is secured using Spring Security.

## Dependencies
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Scheduler
- Spring Security
- Jackson (for JSON serialization/deserialization)

## Setup
1. Clone the repository.
2. Set up a MySQL database and configure the connection in application.properties.
3. Run the application using Maven: `mvn spring-boot:run`.

## Contributors
- [Your Name]

@echo off

rem Start Spring Boot App
start cmd /k "cd C:\Users\chait\OneDrive\Desktop\05.04.24\Open-Disease-Data-API\Open-Disease-Data-API\covid_19\server\opendiseaseapp && mvn spring-boot:run"

rem Start React App
start cmd /k "cd C:\Users\chait\OneDrive\Desktop\05.04.24\Open-Disease-Data-API\Open-Disease-Data-API\covid_19\client\ui && npm start"

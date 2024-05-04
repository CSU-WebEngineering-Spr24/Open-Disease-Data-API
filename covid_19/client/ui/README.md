# COVID-19 Disease Information Web Application

The COVID-19 Disease Information Web Application is a comprehensive solution designed to provide up-to-date information and visualizations related to the COVID-19 pandemic. The application consists of two main components: a backend built with Spring Boot and a frontend developed using React.

## Backend

The backend component is a RESTful API built with Spring Boot and Java. It leverages the disease.sh API to fetch COVID-19 data based on various criteria, such as global, continent, country, and state-specific information. The backend development process involved creating APIs following RESTful principles, writing unit tests using JUnit and Mockito, and building and packaging the application using Maven.

## Frontend

The frontend component is a React application that serves as the user interface for displaying COVID-19 data in an intuitive and visually appealing manner. The development process involved creating UI components using React, HTML, CSS, and JavaScript. The application was built using create-react-app and npm, with dependencies managed through the package.json file.

The frontend and backend components communicate seamlessly through HTTP requests
and responses, providing a comprehensive and user-friendly experience for
exploring COVID-19 data from various perspectives.

The React frontend communicates with the Spring Boot backend via HTTP requests. The backend, in turn, fetches data from various external APIs related to COVID-19 and other diseases. The backend processes and serves this data to the frontend, which then presents it in a user-friendly manner through charts, graphs, and visualizations.

## Tech Stack

### Frontend

- React
- React Router
- Chart.js (for data visualization)
- Node
- Npm

### Backend

- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL relational database
- Maven

## Getting Started

Detailed instructions for setting up and running the frontend and backend components are provided below.

## Frontend Setup

1. Navigate to the frontend directory: `cd covid_19/client/ui`
2. Install dependencies: `npm install`
3. Start the frontend server: `npm start`

## Backend Setup

1. Navigate to the backend directory: `cd covid_19/server/opendiseaseapp`
2. Configure the database connection in `application.properties`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`




# OpenDiseaseApp FrontEnd React Application

# COVID-19 Dashboard

The COVID-19 Dashboard is a React application designed to provide visualizations and statistics of COVID-19 trends globally, continent-specific, country-specific, and state-specific. It fetches data from various APIs and displays it in the form of bar charts, pie charts, and line charts.

## Features

- **Global, Continent, Country, and State-specific Data**: The application displays data in various forms of charts to provide a comprehensive view of the pandemic's impact.
- **User Authentication**: Users can log in to access the dashboard.
- **Contact Information**: The application provides contact information for the team behind the project.
- **Search and Sort Functionality**: Users can search for specific countries and sort the data based on various criteria.

## How to Run the Application

### Prerequisites

- Node.js and npm installed on your machine.
- A basic understanding of React and JavaScript.
- OpenDiseaseApp REST API Backend Spring Boot Application rnunning.


### Steps to Run the Application

1. **Clone the Repository**: Clone the repository to your local machine using the command:
   ```
   git clone <repository-url>
   ```

2. **Navigate to the Project Directory**: Change into the project directory using the command:
   ```
   cd covid_19\client\ui
   ```

3. **Install Dependencies**: Install the necessary dependencies by running:
   ```
   npm install
   ```

4. **Start the Development Server**: Start the development server by running:
   ```
   npm start
   ```
   This command starts the server and opens the application in your default web browser.

5. **Building for Production**: To create a production build of the application, run:
   ```
   npm run build
   ```
   This command generates a `build` folder with the production-ready files.

## Usage

Once the application is running, you can access the ui  by navigating to `http://localhost:3000` in your web browser.


Creating a README file for your Spring Boot application is a great way to provide essential information to users and contributors. This file typically includes an introduction to the application, prerequisites for running the application, installation instructions, and usage examples. Below is a template for a README file tailored to your Spring Boot application. You can customize it further based on your specific requirements.


# OpenDiseaseApp REST API Backend Spring Boot Application

## Introduction

OpenDiseaseApp REST API is a Spring Boot application designed to provide insights and data related to diseases, with a focus on COVID-19. The application leverages various APIs to fetch and display disease-related data, including  COVID-19 trends globally, continent-specific, country-specific, and state-specific. It's built with a focus on ease of use and accessibility, making it a valuable tool for researchers, healthcare professionals, and the general public.

## Prerequisites

Before you can run OpenDiseaseApp, ensure you have the following installed on your system:

- Java 17 
- Maven 3.6 
- An IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor (e.g., VSCode)
- MySQL Database

## Installation

### Clone the Repository

First, clone the OpenDiseaseApp repository to your local machine:

```bash
git clone <repository-url>
cd covid_19\server\opendiseaseapp
```

### Build the Application and Run Unit Tests

Open a terminal in the project directory and run the following Maven command to
build the application and run unit tests:

```bash
mvn clean install
```

### Run the Application

After building the application, you can run it using the following command:

```bash
mvn spring-boot:run
```


## Usage

Once the application is running, you can access it by navigating to `http://localhost:8080` in your web browser.

We used a 'start' batch file that enables the simultaneous launch of both back end and front-end components of the application, streamlining workflow and ensuring consistency. This efficient approach optimizes time and enhances productivity for developers and administrators.


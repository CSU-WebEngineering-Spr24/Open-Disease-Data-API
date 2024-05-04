import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { API_BASE_URL } from './constants';
import Navbar from './components/Navbar';
import { Dashboard } from './components/Dashboard';
import AboutPage from './components/AboutPage';
import Footer from './components/Footer';
import ContactPage from './components/ContactPage';
import Register from './components/Register';
import Login from './components/Login';

function App() {
  const [isLoggedIn, setLoggedIn] = useState(false);
  const [globalData, setGlobalData] = useState(null);
  const [stateData, setStateData] = useState([]);
  const [continentData, setContinentData] = useState([]);
  const [countryData, setCountryData] = useState([]);
  useEffect(() => {
    const checkLogin = async () => {
      try {
        // const response = await fetch(API_BASE_URL + '/user', {
        //   method: 'GET',
        //   credentials: 'include',
        // });
        // debugger
        if (
          window.sessionStorage.getItem('user') &&
          window.sessionStorage.getItem('user') != 'Unknown'
        ) {
          setLoggedIn(true);
        } else {
          setLoggedIn(false);
        }
        // if (response.status === 200) {

        //     const userNameData = await response.text();
        //     if(userNameData != "Unknown" && userNameData != "anonymousUser") {
        //     sessionStorage.setItem('username', userNameData);
        //     setLoggedIn(true);
        //   } else {
        //     setLoggedIn(false);
        //   }

        // }
      } catch (error) {
        console.error('Error checking login status:', error);
      }
    };

    checkLogin();
  }, []);

  useEffect(() => {
    // Fetch global data
    fetch(API_BASE_URL + '/api/global')
      .then((response) => response.json())
      .then((data) => setGlobalData(data))
      .catch((error) => console.error('Error fetching global data:', error));

    // Fetch state data
    fetch(API_BASE_URL + '/api/states')
      .then((response) => response.json())
      .then((data) => setStateData(data))
      .catch((error) => console.error('Error fetching state data:', error));

    // Fetch continent data
    fetch(API_BASE_URL + '/api/continents')
      .then((response) => response.json())
      .then((data) => setContinentData(data))
      .catch((error) => console.error('Error fetching continent data:', error));

    // Fetch country data
    fetch(API_BASE_URL + '/api/countries')
      .then((response) => response.json())
      .then((data) => setCountryData(data))
      .catch((error) => console.error('Error fetching country data:', error));
  }, []);

  return (
    <Router>
      <div className="App">
        <Navbar />
        <Routes>
          <Route
            exact
            path="/"
            element={
              isLoggedIn ? (
                <Dashboard
                  globalData={globalData}
                  stateData={stateData}
                  continentData={continentData}
                  countryData={countryData}
                />
              ) : (
                <Login />
              )
            }
          />
          <Route exact path="/about" element={<AboutPage />} />
          <Route exact path="/contact" element={<ContactPage />} />
          <Route exact path="/register" element={<Register />} />
        </Routes>
        <Footer />
      </div>
    </Router>
  );
}

export default App;

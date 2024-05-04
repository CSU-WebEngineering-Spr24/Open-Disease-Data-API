import React from 'react';
import { Bar, Pie, Line } from 'react-chartjs-2';
import Chart from 'chart.js/auto';

function ChartSection({ globalData, stateData, countryData, continentData }) {
  if (!globalData || !stateData || !countryData || !continentData) {
    return (<>Loading...</>);
  }

  const continentLabels = continentData.map(continent => continent.continent);
  const continentDataValues = continentData.map(continent => continent.cases);

  const globalLabels = ['Cases', 'Deaths', 'Recovered', 'Active Cases'];
  const globalDataValues = [
    globalData.cases,
    globalData.deaths,
    globalData.recovered,
    globalData.active,
  ];

  const stateLabels = stateData.map(state => state.state);
  const stateDataValues = stateData.map(state => state.cases);

  const countyLabels = countryData.map(country => country.country);
  const countyDataValues = countryData.map(country => country.cases);

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">COVID-19 Trends</h2>
      <div className="row">
        <div className="col-md-6">
          <Bar
            data={{
              labels: continentLabels,
              datasets: [
                {
                  label: 'Continent-Specific Covid Cases Data',
                  data: continentDataValues,
                  backgroundColor: 'rgba(75, 192, 192, 0.5)',
                  borderColor: 'rgb(75, 192, 192)',
                  borderWidth: 1,
                },
              ],
            }}
            options={{
              scales: {
                y: {
                  beginAtZero: true,
                  type: 'linear',
                },
              },
            }}
          />
        </div>
        <div className="col-md-6">
          <Pie
            data={{
              labels: globalLabels,
              datasets: [
                {
                  label: 'Global COVID-19 Data',
                  data: globalDataValues,
                  backgroundColor: [
                    'rgba(255, 99, 132, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(255, 206, 86, 0.5)',
                    'rgba(75, 192, 192, 0.5)',
                  ],
                  borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                  ],
                  borderWidth: 1,
                },
              ],
            }}
            options={{
              scales: {
                y: {
                  beginAtZero: true,
                },
              },
            }}
          />
        </div>
      </div>
      <div className="row mt-4">
        <div className="col-md-6">
          <Line
            data={{
              labels: stateLabels,
              datasets: [
                {
                  label: 'State-Specific Covid Cases Data',
                  data: stateDataValues,
                  backgroundColor: 'rgba(75, 192, 192, 0.5)',
                  borderColor: 'rgb(75, 192, 192)',
                  borderWidth: 1,
                },
              ],
            }}
            options={{
              scales: {
                y: {
                  beginAtZero: true,
                  type: 'linear',
                },
              },
            }}
          />
        </div>
        <div className="col-md-6">
          <Bar
            data={{
              labels: countyLabels,
              datasets: [
                {
                  label: 'Country-Specific Covid Cases Data',
                  data: countyDataValues,
                  backgroundColor: 'rgba(75, 192, 192, 0.5)',
                  borderColor: 'rgb(75, 192, 192)',
                  borderWidth: 1,
                },
              ],
            }}
            options={{
              scales: {
                y: {
                  beginAtZero: true,
                  type: 'linear',
                },
              },
            }}
          />
        </div>
      </div>
    </div>
  );
}

export default ChartSection;

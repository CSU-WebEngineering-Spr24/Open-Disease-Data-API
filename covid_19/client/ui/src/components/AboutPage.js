import React from 'react';

function AboutPage() {
  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">About</h2>
      <p>
        This application provides visualizations of COVID-19 trends using data from various sources. It displays global, continent-specific, country-specific, and state-specific data in the form of bar charts, pie charts, and line charts.
      </p>
      <p>
        The data is fetched from APIs and updated regularly to provide accurate information about the current situation of the pandemic.
      </p>
      <p>
        For any questions or feedback, please contact us at <a href="mailto:chikka_chaitanya@students.columbusstate.edu/ ramanujam_saikomali@students.columbusstate.edu/ bandla_manibala@students.columbusstate.edu">chikka_chaitanya@students.columbusstate.edu/ ramanujam_saikomali@students.columbusstate.edu/ bandla_manibala@students.columbusstate.edu</a>.
      </p>
    </div>
  );
}

export default AboutPage;

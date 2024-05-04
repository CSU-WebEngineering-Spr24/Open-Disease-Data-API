import React from 'react';

function TileSection({ globalData }) {
  return (
    <div className="container mt-4">
      <div className="row mb-4">
        <div className="col-md-3">
          <div className="card text-white bg-primary">
            <div className="card-body">
              <h5 className="card-title">Global Cases</h5>
              <p className="card-text">
                {globalData ? globalData.cases : 'Loading...'}
              </p>
            </div>
          </div>
        </div>
        <div className="col-md-3">
          <div className="card text-white bg-danger">
            <div className="card-body">
              <h5 className="card-title">Global Deaths</h5>
              <p className="card-text">
                {globalData ? globalData.deaths : 'Loading...'}
              </p>
            </div>
          </div>
        </div>
        <div className="col-md-3">
          <div className="card text-white bg-success">
            <div className="card-body">
              <h5 className="card-title">Global Recovered</h5>
              <p className="card-text">
                {globalData ? globalData.recovered : 'Loading...'}
              </p>
            </div>
          </div>
        </div>
        <div className="col-md-3">
          <div className="card text-white bg-warning">
            <div className="card-body">
              <h5 className="card-title">Global Active Cases</h5>
              <p className="card-text">
                {globalData ? globalData.active : 'Loading...'}
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default TileSection;
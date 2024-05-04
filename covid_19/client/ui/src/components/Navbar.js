import React, { useState } from 'react';
import { API_BASE_URL } from '../constants';

function Navbar() {
  const [showDropdown, setShowDropdown] = useState(false);

  const handleUsernameClick = () => {
    setShowDropdown(!showDropdown);
  };

  const handleLogout = () => {
    window.sessionStorage.removeItem("user");
    window.location.reload();
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container">
        <a className="navbar-brand" href="#">
          COVID-19 Dashboard
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <a className="nav-link active" aria-current="page" href="/">
                Home
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="/about">
                About
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="/contact">
                Contact
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="#" onClick={handleUsernameClick}>
                <i className="fas fa-user-circle fa-lg me-1"></i>
                {window.sessionStorage.getItem("user") ? window.sessionStorage.getItem("user") : "Guest"}
              </a>
              {showDropdown && (
                <div className="dropdown-menu dropdown-menu-end show">
                  <button className="dropdown-item" onClick={handleLogout}>
                    Logout
                  </button>
                </div>
              )}
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;

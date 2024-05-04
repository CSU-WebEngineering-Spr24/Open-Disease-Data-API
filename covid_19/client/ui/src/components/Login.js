import React, { useState } from 'react';
import { API_BASE_URL } from '../constants';

const Login = ({ onLogin }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {
    
    const url =  API_BASE_URL + `/user?action=login&user=${encodeURIComponent(username)}&pass=${encodeURIComponent(password)}`;

    fetch(url, {
      method: 'GET',
      
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      
      response.text().then(data => {
        if(data != "failed") {
          window.sessionStorage.setItem("user", data);
          window.location.reload();
        } else {
          alert("Login Failed");
          window.sessionStorage.setItem("user", "Unknown");
        }
      });
    })
    .catch(error => {
      // Handle error
      console.error('There was a problem with the fetch operation:', error);
    });
  };
  

  return (
    <div className="container" style={{ height: '90vh' }}>
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <h2>Login</h2>
          <div className="mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>
          <div className="mb-3">
            <input
              type="password"
              className="form-control"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
          <button className="btn btn-primary" onClick={handleLogin}>Login</button>
          <p>Don't have an account? <a href="/register">Register</a></p>
        </div>
        
      </div>
    </div>
  );
};

export default Login;

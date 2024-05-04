import React, { useState } from 'react';
import { API_BASE_URL } from '../constants';

const Register = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [error, setError] = useState('');

  const handleRegister = () => {
    if (password !== confirmPassword) {
      setError('Passwords do not match');
      return;
    }

    setError('');

    const url =
      API_BASE_URL +
      `/user?action=create&user=${encodeURIComponent(
        username
      )}&pass=${encodeURIComponent(password)}`;

    fetch(url)
      .then((response) => {
        if (response.ok) {
          response.text().then((data) => {
            if (data != 'failed') {
              alert('Registration success');
              window.location.href = '/';
            } else {
              alert('Registration Failed');
            }
          });
        }
      })
      .catch((error) => {
        alert('Registration failed');
      });
  };

  return (
    <div className="container" style={{ height: '90vh' }}>
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <h2>Register</h2>
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
          <div className="mb-3">
            <input
              type="password"
              className="form-control"
              placeholder="Confirm Password"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
            />
          </div>
          {error && <p className="text-danger">{error}</p>}
          <button className="btn btn-primary" onClick={handleRegister}>
            Register
          </button>
        </div>
      </div>
    </div>
  );
};

export default Register;

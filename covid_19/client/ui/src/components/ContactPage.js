import React from 'react';

function ContactPage() {
  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Contact Us</h2>
      <p>
        If you have any questions, feedback, or inquiries, please feel free to reach out to us using the contact information below. Our team is here to assist you.
      </p>
      <div className="row">
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Member 1</h5>
              <p className="card-text">Email: member1@example.com</p>
              <p className="card-text">Phone: (123) 456-7890</p>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Member 2</h5>
              <p className="card-text">Email: member2@example.com</p>
              <p className="card-text">Phone: (234) 567-8901</p>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Member 3</h5>
              <p className="card-text">Email: member3@example.com</p>
              <p className="card-text">Phone: (345) 678-9012</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ContactPage;

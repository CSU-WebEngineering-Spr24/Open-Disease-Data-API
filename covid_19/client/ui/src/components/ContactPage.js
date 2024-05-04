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
              <h5 className="card-title">Chaitanya Chikka</h5>
              <p className="card-text">Email: chikka_chaitanya@students.columbusstate.edu</p>
              <p className="card-text">TSYS School of CS Phone: (706) 507-8800</p>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Sai Komali Ramanujam</h5>
              <p className="card-text">Email: ramanujam_saikomali@students.columbusstate.edu</p>
              <p className="card-text">TSYS School of CS Phone: (706) 507-8800</p>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Bandla Mani Bala</h5>
              <p className="card-text">Email: bandla_manibala@students.columbusstate.edu</p>
              <p className="card-text">TSYS School of CS Phone: (706) 507-8800</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ContactPage;

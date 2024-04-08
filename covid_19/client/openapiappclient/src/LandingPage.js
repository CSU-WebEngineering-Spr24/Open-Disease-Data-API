import React from 'react';
import { Container, Row, Col, Button } from 'react-bootstrap';

const LandingPage = () => {
  return (
    <Container fluid className="p-5 bg-light">
      <Row className="justify-content-center text-center">
        <Col xs={12} md={8}>
          <h1 className="mb-4">COVID-19 Disease Information</h1>
          <p className="lead">
            Welcome to our platform for obtaining and displaying worldwide COVID-19 statistics,
            vaccination data, pharmaceutical trial information, and variant information.
          </p>
          <Button variant="primary" href="/dashboard">Explore Dashboard</Button>
        </Col>
      </Row>
    </Container>
  );
};

export default LandingPage;

package com.csuwebeng.opendiseaseapp.dao.impl;


import com.csuwebeng.opendiseaseapp.entities.CountryData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDataRepository extends JpaRepository<CountryData, Long> {
}


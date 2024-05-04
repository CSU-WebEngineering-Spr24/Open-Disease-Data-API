package com.csuwebeng.opendiseaseapp.dao.impl;

import com.csuwebeng.opendiseaseapp.entities.GlobalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlobalDataRepository extends JpaRepository<GlobalData, Long> {
}

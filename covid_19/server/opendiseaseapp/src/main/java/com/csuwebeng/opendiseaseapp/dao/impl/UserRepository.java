package com.csuwebeng.opendiseaseapp.dao.impl;

import com.csuwebeng.opendiseaseapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

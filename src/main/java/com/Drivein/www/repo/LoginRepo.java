package com.Drivein.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Drivein.www.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login,Long> {

	Login findByUsername(String string);

}

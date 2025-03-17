package com.Drivein.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Drivein.www.model.Items;
@Repository
public interface ItemsRepo extends JpaRepository<Items,Long> {

}

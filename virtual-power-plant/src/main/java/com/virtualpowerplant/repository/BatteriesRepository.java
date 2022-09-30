package com.virtualpowerplant.repository;

import com.virtualpowerplant.model.Batteries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteriesRepository extends JpaRepository<Batteries,String > {
}

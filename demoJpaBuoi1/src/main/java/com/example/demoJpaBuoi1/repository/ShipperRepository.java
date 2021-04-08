package com.example.demoJpaBuoi1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJpaBuoi1.model.Shipper;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer>{

}

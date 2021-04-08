package com.example.demoJpaManone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJpaManone.model.HocSinh;
@Repository
public interface HocSinhRepository extends JpaRepository<HocSinh, Integer>{

}

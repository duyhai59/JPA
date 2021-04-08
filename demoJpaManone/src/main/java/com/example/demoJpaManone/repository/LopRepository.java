package com.example.demoJpaManone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJpaManone.model.Lop;
@Repository
public interface LopRepository extends JpaRepository<Lop, Integer>{

}

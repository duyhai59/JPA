package com.example.demoSpringBootJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoSpringBootJpa.model.CauThu;
@Repository
public interface CauThuRepository extends JpaRepository<CauThu, Long>{

}

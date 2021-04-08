package com.example.demoSpringBootJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoSpringBootJpa.model.DoiBong;
@Repository
public interface DoiBongRepository extends JpaRepository<DoiBong, Long>{

}

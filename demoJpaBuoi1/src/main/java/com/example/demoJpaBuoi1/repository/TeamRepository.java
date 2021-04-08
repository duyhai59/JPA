package com.example.demoJpaBuoi1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoJpaBuoi1.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{

}

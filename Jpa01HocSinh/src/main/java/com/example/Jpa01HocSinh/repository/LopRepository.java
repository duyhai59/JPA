package com.example.Jpa01HocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jpa01HocSinh.model.Lop;

@Repository
public interface LopRepository extends JpaRepository<Lop, Integer>{

}

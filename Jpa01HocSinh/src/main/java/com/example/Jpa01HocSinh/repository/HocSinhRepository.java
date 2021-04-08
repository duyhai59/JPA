package com.example.Jpa01HocSinh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jpa01HocSinh.model.HocSinh;

@Repository
public interface HocSinhRepository extends JpaRepository<HocSinh, Integer>{

}

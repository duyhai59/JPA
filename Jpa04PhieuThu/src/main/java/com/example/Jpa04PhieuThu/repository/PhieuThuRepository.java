package com.example.Jpa04PhieuThu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jpa04PhieuThu.model.PhieuThu;

@Repository
public interface PhieuThuRepository extends JpaRepository<PhieuThu, Integer>{

}

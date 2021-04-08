package com.example.Jpa02NhanVien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jpa02NhanVien.model.PhanCong;

@Repository
public interface PhanCongRepository extends JpaRepository<PhanCong, Integer>{

}

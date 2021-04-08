package com.example.Jpa02NhanVien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jpa02NhanVien.model.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer>{

}

package com.example.Jpa03KhoaHoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jpa03KhoaHoc.model.HocVien;

@Repository
public interface HocVienRepository extends JpaRepository<HocVien, Integer> {

}
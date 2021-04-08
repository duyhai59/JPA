package com.example.Jpa04PhieuThu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jpa04PhieuThu.model.LoaiNguyenLieu;

@Repository
public interface LoaiNguyenLieuRepository extends JpaRepository<LoaiNguyenLieu, Integer>{

}

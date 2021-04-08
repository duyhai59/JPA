package com.example.Jpa05MonAn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Jpa05MonAn.model.NguyenLieu;

@Repository
public interface NguyenLieuRepository extends JpaRepository<NguyenLieu, Integer>{

}

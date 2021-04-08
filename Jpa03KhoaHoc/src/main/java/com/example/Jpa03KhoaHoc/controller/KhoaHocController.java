package com.example.Jpa03KhoaHoc.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa03KhoaHoc.model.HocVien;
import com.example.Jpa03KhoaHoc.model.KhoaHoc;
import com.example.Jpa03KhoaHoc.repository.HocVienRepository;
import com.example.Jpa03KhoaHoc.repository.KhoaHocRepository;

@RestController
public class KhoaHocController {

	@Autowired
	KhoaHocRepository khoaHocRepository;
	
	@Autowired
	HocVienRepository hocVienRepository;
	
	@PutMapping(value = "/khoahoc/themngay")
	public void Them1NgayChoKhoaHoc(@RequestParam int khoaHocID) {
		KhoaHoc khCurrent = khoaHocRepository.findById(khoaHocID).get();
		
		Calendar c = Calendar.getInstance();
		c.setTime(khCurrent.getNgayBatDau());
		c.add(Calendar.DAY_OF_MONTH, 1);
		khCurrent.setNgayKetThuc(new Date(c.getTime().getTime())); // chuyen tu date unti.java sang date sql
		
		// Kiem tra dk
		ValidatorFactory valFac = Validation.buildDefaultValidatorFactory();
		Validator val = valFac.getValidator();
		
		Set<ConstraintViolation<KhoaHoc>> violation = val.validate(khCurrent);
		violation.forEach(x->{
			System.out.println(x.getMessage());
		});
		if(violation.size() == 0) {
			khoaHocRepository.save(khCurrent);
		}
	}
	
	@DeleteMapping(value = "/khoahoc/xoa")
	public String XoaKhoaHoc(@RequestParam int khoaHocID) {
		Optional<KhoaHoc> op = Optional.empty();
		if(khoaHocRepository.findById(khoaHocID) == op) 
			return "Khong ton tai khoa hoc";
		else {
			hocVienRepository.findAll().forEach(x->{
				if(x.getKhoaHoc().getId() == khoaHocID) {
					x.setKhoaHoc(khoaHocRepository.findById(0).get());
					hocVienRepository.save(x);
				}
			});
			khoaHocRepository.deleteById(khoaHocID);
			return "Thanh Cong";
		}
	}
	
	@GetMapping(value = "/khoahoc/doanhthu")
	public String TinhDoanhThu() {
		String strResult = "";
		Calendar c = Calendar.getInstance();
		for(int  i = 0 ; i < 12 ; i++) {
			int doanhthu = 0;
			for(KhoaHoc kh : khoaHocRepository.findAll()) {
				c.setTime(kh.getNgayBatDau());
				if(c.get(Calendar.MONTH) == i)
					for(HocVien hv : hocVienRepository.findAll())
						if(hv.getKhoaHoc() == kh) {
							doanhthu += kh.getHocPhi();
						}
			}
			strResult += "Thang" + String.valueOf(i + 1) + ":" + String.valueOf(doanhthu) + "\n";
		}
		return strResult;
	}
}

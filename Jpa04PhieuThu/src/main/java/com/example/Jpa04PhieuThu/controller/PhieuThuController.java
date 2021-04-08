package com.example.Jpa04PhieuThu.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Jpa04PhieuThu.model.ChiTietPhieuThu;
import com.example.Jpa04PhieuThu.model.NguyenLieu;
import com.example.Jpa04PhieuThu.model.PhieuThu;
import com.example.Jpa04PhieuThu.repository.ChiTietPhieuThuRepository;
import com.example.Jpa04PhieuThu.repository.NguyenLieuRepository;
import com.example.Jpa04PhieuThu.repository.PhieuThuRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class PhieuThuController {
	
	@Autowired
	PhieuThuRepository phieuThuRepository;
	
	@Autowired
	ChiTietPhieuThuRepository chiTietPhieuThuRepository;
	
	@Autowired
	NguyenLieuRepository nguyenLieuRepository;
	
	ValidatorFactory valFac = Validation.buildDefaultValidatorFactory();
	Validator val = valFac.getValidator();
	
	@PostMapping(value = "/phieuthu/themchitietphieuthu")
	public void ThemChiTietPhieu(@RequestBody String chiTietPhieuThu) {
		Gson gson = new Gson();
		ChiTietPhieuThu ct = gson.fromJson(chiTietPhieuThu, ChiTietPhieuThu.class);
		
		Set<ConstraintViolation<ChiTietPhieuThu>> violation = val.validate(ct);
		Optional<NguyenLieu> op = Optional.empty();
		
		if(violation.size() == 0 && nguyenLieuRepository.findById(ct.getNguyenLieu().getId()) != op) {
			PhieuThu ptCurrent = phieuThuRepository.findById(ct.getPhieuThu().getId()).get();
			NguyenLieu nglCurrent = nguyenLieuRepository.findById(ct.getNguyenLieu().getId()).get();
			
			nglCurrent.setSoLuongKho(nglCurrent.getSoLuongKho() - ct.getSoLuongBan());
			ptCurrent.setThanhTien(ptCurrent.getThanhTien() + ct.getSoLuongBan() * nglCurrent.getGiaBan());
			
			Set<ConstraintViolation<NguyenLieu>> violation_ngl = val.validate(nglCurrent);
			Set<ConstraintViolation<PhieuThu>> violation_pt = val.validate(ptCurrent);
			if(violation_ngl.size() == 0 && violation_pt.size() == 0) {
				chiTietPhieuThuRepository.save(ct);
				phieuThuRepository.save(ptCurrent);
				nguyenLieuRepository.save(nglCurrent);
			}
		}
	}
	
	@PutMapping(value = "/phieuthu/themphieuthu")
	public void ThemPhieuThu(@RequestBody String phieuThu) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		PhieuThu ptMoi = gson.fromJson(phieuThu, PhieuThu.class);
		
		Set<ConstraintViolation<PhieuThu>> violation = val.validate(ptMoi);
		if(violation.size() == 0) 
			phieuThuRepository.save(ptMoi);
		
		List<ChiTietPhieuThu> lst = new ArrayList<ChiTietPhieuThu>(ptMoi.getChiTietPhieuThus());
		lst.forEach(ct ->{
			Optional<NguyenLieu> op = Optional.empty();
			if(nguyenLieuRepository.findById(ct.getNguyenLieu().getId()) != op) {
				NguyenLieu nglCurrent = nguyenLieuRepository.findById(ct.getNguyenLieu().getId()).get();
				PhieuThu pthu = phieuThuRepository.findById(ptMoi.getId()).get();
				
				ct.setPhieuThu(pthu);
				nglCurrent.setSoLuongKho(nglCurrent.getSoLuongKho() - ct.getSoLuongBan());
				pthu.setThanhTien(pthu.getThanhTien() + ct.getSoLuongBan() * nglCurrent.getGiaBan());
				
				Set<ConstraintViolation<NguyenLieu>> violation_ngl = val.validate(nglCurrent);
				Set<ConstraintViolation<ChiTietPhieuThu>> violation_ct = val.validate(ct);
				
				if(violation_ct.size() == 0 && violation_ngl.size() == 0) {
					chiTietPhieuThuRepository.save(ct);
					phieuThuRepository.save(pthu);
					nguyenLieuRepository.save(nglCurrent);
				}
			}
		});
	}
	
	@DeleteMapping(value = "/phieuthu/xoa")
	public void XoaPhieuThu(@RequestParam int phieuThuID) {
		chiTietPhieuThuRepository.findAll().forEach(x->{
			if(x.getPhieuThu().getId() == phieuThuID)
				chiTietPhieuThuRepository.delete(x);
		});
		phieuThuRepository.deleteById(phieuThuID);
	}
	
	@GetMapping(value = "/phieuthu/laythongtin")
	public List<PhieuThu> Get(@RequestParam(value = "thang", required = false) Integer thang){
		Calendar c = Calendar.getInstance();
		if(thang == null) {
			return phieuThuRepository.findAll();
		}
		else {
			List<PhieuThu> lst = new ArrayList<>();
			for(PhieuThu x : phieuThuRepository.findAll()) {
				c.setTime(x.getNgayLap());
				//calendar lấy từ 0 tới 11 nên phải cộng 1 
				if(c.get(Calendar.MONTH) + 1 == thang)
					lst.add(x);
			}
			return lst;
		}
	}
}
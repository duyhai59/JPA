package com.example.demoSpringBootJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoSpringBootJpa.model.CauThu;
import com.example.demoSpringBootJpa.repository.CauThuRepository;

@Service
public class CauThuServiceImpl implements CauThuService{

	@Autowired
	CauThuRepository cauThuRepository;
	
	@Override
	public List<CauThu> getAll() {
		return cauThuRepository.findAll();		
	}

	@Override
	public void add(CauThu cauthu) {
		cauThuRepository.save(cauthu);
	}

	@Override
	public void update(CauThu cauthu) {
		CauThu cauThuHientai = cauThuRepository.getOne(cauthu.getId());
		cauThuHientai.setTen(cauthu.getTen());
		cauThuHientai.setDoiBong(cauthu.getDoiBong());
		cauThuHientai.setSo(cauthu.getSo());
		cauThuRepository.save(cauThuHientai);
	}

	@Override
	public void delete(CauThu cauthu) {
		cauThuRepository.delete(cauthu);
		
	}

	@Override
	public CauThu getOne(long id) {
		return cauThuRepository.getOne(id);
	}

}

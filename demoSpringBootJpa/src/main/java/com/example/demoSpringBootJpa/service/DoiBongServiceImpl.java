package com.example.demoSpringBootJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoSpringBootJpa.model.DoiBong;
import com.example.demoSpringBootJpa.repository.DoiBongRepository;

@Service
public class DoiBongServiceImpl implements DoiBongService{

	@Autowired
	DoiBongRepository doiBongRepository;

	@Override
	public List<DoiBong> getAll() {
		return doiBongRepository.findAll();
	}

	@Override
	public void add(DoiBong doiBong) {
		doiBongRepository.save(doiBong);
		
	}

	@Override
	public void update(DoiBong doiBong) {
		DoiBong doiBongHientai = doiBongRepository.getOne(doiBong.getId());
		doiBongHientai.setTen(doiBong.getTen());
		doiBongHientai.setSanBong(doiBong.getSanBong());
		
	}

	@Override
	public void delete(DoiBong doiBong) {
		doiBongRepository.delete(doiBong);
		
	}

	@Override
	public DoiBong findOne(long id) {
		return doiBongRepository.getOne(id);
	}
	
}

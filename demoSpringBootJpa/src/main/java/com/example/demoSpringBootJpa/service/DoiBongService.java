package com.example.demoSpringBootJpa.service;

import java.util.List;

import com.example.demoSpringBootJpa.model.DoiBong;

public interface DoiBongService {
	List<DoiBong> getAll();
	void add(DoiBong doiBong);
	void update(DoiBong doiBong);
	void delete(DoiBong doiBong);
	DoiBong findOne(long id);
}

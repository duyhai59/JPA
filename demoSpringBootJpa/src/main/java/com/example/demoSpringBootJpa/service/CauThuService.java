package com.example.demoSpringBootJpa.service;

import java.util.List;

import com.example.demoSpringBootJpa.model.CauThu;

public interface CauThuService {
	List<CauThu> getAll();
	void add(CauThu cauthu);
	void update(CauThu cauthu);
	void delete(CauThu cauthu);
	CauThu getOne(long id);
}

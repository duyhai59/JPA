package com.example.demoJpaBuoi1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJpaBuoi1.model.Shipper;
import com.example.demoJpaBuoi1.model.Team;
import com.example.demoJpaBuoi1.repository.ShipperRepository;
import com.example.demoJpaBuoi1.repository.TeamRepository;

import java.util.List;

@RestController
public class ShipperController {
	@Autowired
	ShipperRepository shipperRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@GetMapping(value = "/shipper")
	public void Create() {
		Shipper shipperMinh = new Shipper();
		shipperMinh.setId(1);
		shipperMinh.setName("Minh");
		shipperMinh.setLevel(5);
		shipperRepository.save(shipperMinh);
		
		Shipper shipperDat = new Shipper();
		shipperDat.setId(2);
		shipperDat.setName("Dat");
		shipperDat.setLevel(4);
		shipperRepository.save(shipperDat);
	}
	
	@GetMapping(value = "/upshipper")
	public void Update() {
		Shipper shipperDat = shipperRepository.getOne(2);
		shipperDat.setName("Dinh Tien Dat");
		shipperRepository.save(shipperDat);
	}
	
	@GetMapping(value = "/delshipper")
	public void Delete() {
		Shipper shipperMinh = shipperRepository.getOne(1);
		shipperRepository.delete(shipperMinh);
	}
	
	@GetMapping(value = "/viewshipper" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Shipper> ShowAll() {
		return shipperRepository.findAll();
	}
	
	@GetMapping(value = "/relation" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public void Relation() {
		Team team = new Team();
		team.setId(1);
		team.setName("HAGL");
		team = teamRepository.save(team);
		
		Shipper shipperMinh = shipperRepository.getOne(2);
		shipperMinh.setTeam(team);
		shipperRepository.save(shipperMinh);
		
		Team team1 = new Team();
		team1.setId(2);
		team1.setName("HN T&T");
		team1 = teamRepository.save(team1);
		
		Shipper shipperLong = new Shipper();
		shipperLong.setId(1);
		shipperLong.setName("Duy Long");
		shipperLong.setLevel(1);
		shipperLong.setTeam(team1);
		shipperRepository.save(shipperLong); 
		
	}
}

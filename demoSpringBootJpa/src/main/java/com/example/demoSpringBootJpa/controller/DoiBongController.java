package com.example.demoSpringBootJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoSpringBootJpa.model.DoiBong;
import com.example.demoSpringBootJpa.service.DoiBongService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/doibong")
public class DoiBongController {
	
	@Autowired
	DoiBongService doiBongService;
	
	@GetMapping(value = "/home")
	public List<DoiBong> home() {
		return doiBongService.getAll();
	}
	
	@PostMapping(value = "/add" , produces = MediaType.APPLICATION_JSON_VALUE)
	public DoiBong add(@RequestBody String doiBong) {
		Gson gson = new Gson();
		DoiBong doiBongMoi = gson.fromJson(doiBong, DoiBong.class);
		doiBongService.add(doiBongMoi);
		return doiBongMoi;
	}
	
	@PutMapping(value = "/update" , produces = MediaType.APPLICATION_JSON_VALUE)
	public DoiBong update(@RequestBody String doiBong) {
		Gson gson = new Gson();
		DoiBong doiBongMoi = gson.fromJson(doiBong, DoiBong.class);
		doiBongService.update(doiBongMoi);
		return doiBongMoi;
	}
	
	@DeleteMapping(value = "/delete")
	public void delete(@RequestParam long id) {
		doiBongService.delete(doiBongService.findOne(id));
	}
}

package com.telusko.contest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.contest.entity.Url;
import com.telusko.contest.service.UrlService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UrlController {

	@Autowired
	UrlService service;
	
	@GetMapping("/getAllUrl")
	public List<Url> getAllUrl(){
		return service.getAllUrl();
	}
	
	@PostMapping("/createUrl")
	public String createUrl(@RequestBody Map<String, String> requestBody) {
	    String inUrl = requestBody.get("inUrl");
	    String temp = service.filterUrl(inUrl);
	    return service.createUrl(temp, inUrl);
	}

	
}

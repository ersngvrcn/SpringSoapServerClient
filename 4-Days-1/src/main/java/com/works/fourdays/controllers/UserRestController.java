package com.works.fourdays.controllers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@GetMapping("/allUser")
	public Map<String,Object> allUser(){
		Map<String,Object> hm = new LinkedHashMap<String, Object>();
		hm.putIfAbsent("product", Arrays.asList("Ali","Veli","Hasan"));
		
		return hm;
		
	}
}

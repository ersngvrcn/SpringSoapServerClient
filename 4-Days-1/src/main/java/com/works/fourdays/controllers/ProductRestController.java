package com.works.fourdays.controllers;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	
	@GetMapping("/allProduct")
	public Map<String,Object> allproduct(){
		Map<String,Object> hm = new LinkedHashMap<String, Object>();
		hm.putIfAbsent("product", Arrays.asList("Buzdolabı","Televizyon","Tablet"));
		
		return hm;
		
	}
}

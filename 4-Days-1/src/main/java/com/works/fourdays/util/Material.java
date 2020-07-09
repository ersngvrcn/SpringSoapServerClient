package com.works.fourdays.util;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class Material {
	
	public static void user() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> cls = auth.getAuthorities();
		
		for (GrantedAuthority item : cls) {
			System.out.println(item.getAuthority());
		}
		
		String name = auth.getName();
		System.out.println("username:"+name);
	}
}

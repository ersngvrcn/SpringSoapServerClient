package com.works.fourdays.util;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class CharacterEncoding implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Server init call");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		req.setCharacterEncoding("UTF8");
		res.setCharacterEncoding("UTF8");
		
		System.out.println("doFilter call");
		
		Map<String,String[]> vals = req.getParameterMap();
		Set<String> keys = vals.keySet();
		
		for(String key: keys) {
			System.out.println("key:"+key + "val:"+ vals.get(key)[0]);
		}
		
		Material.user();
		chain.doFilter(request, response);
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy call");
	}

}

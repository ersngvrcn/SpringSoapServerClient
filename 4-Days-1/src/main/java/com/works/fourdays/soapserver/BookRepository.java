package com.works.fourdays.soapserver;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import https.www_java2blog_com.xml.book.Book;

@Component
public class BookRepository {
	
	private static final Map<Integer,Book> books = new HashMap<Integer, Book>();
	
	@PostConstruct
	public void initData() {
		Book b1 = new Book();
		b1.setId(1);
		b1.setTitle("İzmir");
		b1.setPages(30);
		books.put(1, b1);
		
		Book b2 = new Book();
		b2.setId(2);
		b2.setTitle("Antalya");
		b2.setPages(50);
		books.put(2, b2);
		
		Book b3 = new Book();
		b3.setId(3);
		b3.setTitle("Bodrum");
		b3.setPages(70);
		books.put(3, b3);
	}
	
	public Book findBook(int id) {
		Assert.notNull(id,"Id not found");
		return books.get(id);
	}

}

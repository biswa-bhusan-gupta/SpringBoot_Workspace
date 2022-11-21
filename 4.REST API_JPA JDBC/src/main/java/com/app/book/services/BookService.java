package com.app.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.book.entities.Book;
import com.app.book.repo.BookRepositories;

@Component
//@Service
public class BookService {

	@Autowired
	private BookRepositories repo;
	
	
	// GET ALL BOOKS
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>) repo.findAll();
		return list;
	}
	
	// GET BOOK BY ID
	public Book getBookById(int id) {
		Book obj1 = repo.findById(id);
		return obj1;
	}

	
	// ADD BOOK
	public Book addBook(Book book) {
		Book obj2 = repo.save(book);
		return obj2;
	}
	
	// DELETE BOOK
	public void deleteBook(int id) {
	    repo.deleteById(id);
	}
	
	// UPDATE BOOK
	public void updateBook(Book book,int id) {
		book.setId(id);
		repo.save(book);
	}
}

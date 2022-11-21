package com.app.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.book.entities.Book;
import com.app.book.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
		
	
	@GetMapping("/Books")
	public List<Book> getBooks() {
	   List<Book> books=this.bookService.getAllBooks(); 
	   return books;
//	   return this.bookService.getAllBooks();
	}

	
	
	
	@GetMapping("/Books/{id}")
	public Book getBook(@PathVariable("id") int x) {
		return this.bookService.getBookById(x);
	}
	
	
	
	@PostMapping("/Books")
	public Book addBook(@RequestBody Book book) {
		Book obj1=this.bookService.addBook(book);
		return obj1;
	}
	
	
	
	@DeleteMapping("/Books/{id}")
	public String deleteBook(@PathVariable("id") int x) {
		this.bookService.deleteBook(x);
		return "Deleted";
	}
	
	
	
	@PutMapping("/Books/{id}")
	public Book updateBook(@RequestBody Book book,@PathVariable("id") int x) {
		this.bookService.updateBook(book,x);
		return book;
	}

}

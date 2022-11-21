package com.app.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.book.entities.Book;
import com.app.book.repo.BookRepositories;


@RestController
public class BookController {
 	
	@Autowired
	BookRepositories repo;	
	
//	@GetMapping("/Books")
//	public String getBooks() {
//	   return repo.findAll().toString(); 
//	}
	
//	@GetMapping("/Books")
//	public Iterable<Book> getBooks() {
//	   return repo.findAll(); 
//	}

	@GetMapping("/Books")
	public List<Book> getbooks() {
	   System.out.println(repo.findAll());
	   List<Book> list=(List<Book>) repo.findAll();
	   System.out.println(repo.findAll());
	   return list;
	}

	
	
//	@GetMapping("/Books/{id}")
//	public String getBook(@PathVariable("id") int x) {
//		return repo.findById(x).toString();
//	}
	

//	@GetMapping("/Books/{id}")
//	public Optional<Book> getbook(@PathVariable("id") int x) {
//		return repo.findById(x);
//	}

	@GetMapping("/Books/{id}")
	public Optional<Book> getbook(@PathVariable("id") int x) {
		Optional<Book> obj1=repo.findById(x);
		return obj1;
	}	
	
	
	@PostMapping("/Books")
	public Book addBook(@RequestBody Book book) {
		Book obj2=repo.save(book);
		return obj2;
	}
	
	
	
	@DeleteMapping("/Books/{id}")
	public String deleteBook(@PathVariable("id") int x) {
		repo.deleteById(x);
		return "Deleted";
	}
	
	
	
	@PutMapping("/Books/{id}")
	public Book updateBook(@RequestBody Book book,@PathVariable("id") int x) {
		   book.setId(x);
		   repo.save(book);
           return book;
	}

}
	

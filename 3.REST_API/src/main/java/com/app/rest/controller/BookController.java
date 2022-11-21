package com.app.rest.controller;

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

import com.app.rest.entities.Book;
import com.app.rest.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
//	@RequestMapping(value="/",method=RequestMethod.GET)
	
	
	
	
	
	
	@GetMapping("/Books")
	public List<Book> getBooks() {
		
//		Book book = new Book();
//		book.setId(25);
//		book.setAuthor("Biswa Bhusan Gupta");
//		book.setTitle("The Wanderers");
//				
		return this.bookService.getAllBooks(); // Jackson converts Object into JSON // Return Type is Object Type
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getbooks(){
		List<Book> list = bookService.getAllBooks();
	    if(list.size()<=0) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	    return ResponseEntity.of(Optional.of(list));
	}
	
	
	
	
	
	
	@GetMapping("/Books/{id}")
	public Book getBook(@PathVariable("id") int x) {
		return this.bookService.getBookById(x);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getbook(@PathVariable("id") int x) {
		Book book = this.bookService.getBookbyId(x);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	
	
	
	@PostMapping("/Books")
	public Book addBook(@RequestBody Book book) {
		Book obj1=this.bookService.addBook(book);
		return obj1;
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addbook(@RequestBody Book book) {
		Book obj2 = null;
		try {
			obj2=this.bookService.addBook(book);
			return ResponseEntity.of(Optional.of(obj2));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	
	@DeleteMapping("/Books/{id}")
	public String deleteBook(@PathVariable("id") int x) {
		this.bookService.deleteBook(x);
		return "Deleted";
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deletebook(@PathVariable("id") int x) {
		try {
		   this.bookService.deleteBook(x);
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	
	@PutMapping("/Books/{id}")
	public Book updateBook(@RequestBody Book book,@PathVariable("id") int x) {
		this.bookService.updateBook(book,x);
		return book;
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updatebook(@RequestBody Book book,@PathVariable("id") int x) {
		
		try {
	     	this.bookService.updateBook(book,x);
		    return ResponseEntity.of(Optional.of(book));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}

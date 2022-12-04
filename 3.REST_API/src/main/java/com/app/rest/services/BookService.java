package com.app.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.rest.entities.Book;

@Component
//@Service
public class BookService {

	private static List<Book> list = new ArrayList<>();
	
	static{
		list.add(new Book(27,"The Ashes","Tushar Srivastav"));
		list.add(new Book(35,"The Boys","Yash Gupta"));
	}
	
	
	// GET ALL BOOKS
	public List<Book> getAllBooks(){
		return list;
	}
	
	// GET BOOK BY ID
	// @Override
	// public Group validateGroup(Group grp) {
        //
	//	LOGGER.info("Validate Group : " + grp);
        //
	//	List<Group> group = groupDao.findAll();
	//	LOGGER.info("Groups : " + group);
        //
	//	Group grpValidate = group.stream().filter(g -> g.getGroupName().equalsIgnoreCase(grp.getGroupName())
	//			&& g.getGroupText().equalsIgnoreCase(grp.getGroupText())).findFirst().orElse(null);
	//	LOGGER.info("Found Group in DB : " + grpValidate);
        //
	//	return grpValidate;
	// }

	public Book getBookById(int id) {
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	public Book getBookbyId(int id) {
		Book book = null;
		try {
			book=list.stream().filter(e->e.getId()==id).findFirst().get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	// ADD BOOK
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}
	
	// DELETE BOOK
	public void deleteBook(int id) {
		list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
	}
	
	// UPDATE BOOK
	// @Override
	// public List<FormGroup> getFormGroups() {
	//	List<Group> group = groupDao.findAll();
	//	List<FormGroup> fgroup = group.stream().map(b-> new FormGroup(b.getGroupId(),b.getGroupName())).collect(Collectors.toList());
	//	return fgroup;
	// }

	public void updateBook(Book book,int id) {
		list=list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
			
		}).collect(Collectors.toList());
	}
}

package com.app.book.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.book.entities.Book;

public interface BookRepositories extends CrudRepository<Book, Integer>{

}

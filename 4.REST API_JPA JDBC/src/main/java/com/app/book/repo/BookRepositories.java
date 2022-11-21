package com.app.book.repo;

import org.springframework.data.repository.CrudRepository;
import com.app.book.entities.Book;

public interface BookRepositories extends CrudRepository<Book, Integer> {
     public Book findById(int id);
}

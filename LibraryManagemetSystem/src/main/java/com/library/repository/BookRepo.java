package com.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.model.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {

}
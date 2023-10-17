package com.example.bookstore.repository;

;
import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.exception.EntityNotFoundException;
import com.example.bookstore.model.Book;

import java.util.List;
import java.util.Properties;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SQLSelect;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<BookResponseDto> findBookByTitleIgnoreCase(String name);

   //@EntityGraph
    @Query("select b from Book b join b.category c where c.id = :categoryId")
    List<Book> findAllByCategoryId( Long categoryId);


}

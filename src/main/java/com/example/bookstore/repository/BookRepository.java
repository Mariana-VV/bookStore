package com.example.bookstore.repository;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {

    public List<BookDto> findBookByTitleIgnoreCase(String name);

}






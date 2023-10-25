package com.example.bookstore.repository;

import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends JpaRepository<Book, Long> {

    List<BookResponseDto> findBookByTitleIgnoreCase(String name);

}

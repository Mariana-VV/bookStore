package com.example.bookstore.service;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BookService {
    BookDto createBook(CreateBookRequestDto requestDto);

    List<BookDto> findAll(String email, Pageable pageable);

    BookDto findBookById(Long id);

    List<BookDto> findBookByTitleIgnoreCase(String name);

    void deleteById(Long id);

    BookDto update(@RequestBody CreateBookRequestDto createBookRequestDto, @PathVariable Long id);

}

package com.example.bookstore.service;

import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BookService {
    BookResponseDto createBook(CreateBookRequestDto requestDto);

    List<BookResponseDto> findAll(String email, Pageable pageable);

    BookResponseDto findBookById(Long id);

    List<BookResponseDto> findBookByTitleIgnoreCase(String name);

    void deleteById(Long id);

    BookResponseDto update(@RequestBody CreateBookRequestDto createBookRequestDto,
                           @PathVariable Long id);
}

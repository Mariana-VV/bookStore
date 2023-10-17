package com.example.bookstore.service;

import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import java.util.List;

import com.example.bookstore.dto.category.BookDtoWithoutCategoryIds;
import com.example.bookstore.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BookService {
    BookResponseDto createBook(CreateBookRequestDto requestDto);

    List<BookResponseDto> findAll(String email, Pageable pageable);

    BookResponseDto findBookById(Long id);

    List<BookResponseDto> findBookByTitleIgnoreCase(String name);

    void deleteById(Long id);

    BookResponseDto update(@RequestBody CreateBookRequestDto createBookRequestDto, @PathVariable Long id);

    List<BookDtoWithoutCategoryIds> findAllBooksByCategoryId(Long categoryId);
}

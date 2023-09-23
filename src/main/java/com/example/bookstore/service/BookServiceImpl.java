package com.example.bookstore.service;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import com.example.bookstore.exception.EntityNotFoundException;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto createBook(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    public BookDto findBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Cant find book bei id " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findBookByTitleIgnoreCase(String name) {
        return bookRepository.findBookByTitleIgnoreCase(name).stream()
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto update(@RequestBody CreateBookRequestDto createBookRequestDto,
                          @PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Entity exist nicht");
        }
        Book book = bookMapper.toModel(createBookRequestDto);
        book.setId(id);
        book = bookRepository.save(book);

        return bookMapper.toDto(book);
    }
}

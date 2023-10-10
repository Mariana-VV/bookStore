package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book management", description = "Endpoints for managing book")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/books")
public class BookController {
    private final BookService bookService;
    private final UserRepository userRepository;

    @GetMapping
    @Operation(summary = "Get all books", description = "Get a list of all available products")
    public List<BookDto> findAll(Authentication authentication, Pageable pageable) {
        String email = authentication.getName();
        return bookService.findAll(email, pageable);
    }

    //    public List<BookDto> findAll(String email, Pageable pageable) {
    //     User user =  userRepository.findByEmail(email).orElseThrow(() ->
    //                new RuntimeException("Cant find user be email " + email));
    //     return bookService.findAllByUserId(user.getId()).stream()
    //             .map()
    //    }

    @PostMapping
    @Operation(summary = "Create a new book", description = "Create a new book")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public BookDto save(@RequestBody CreateBookRequestDto requestDto) {
        return bookService.createBook(requestDto);
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PutMapping("/{id}")
    public BookDto update(@RequestBody @Valid CreateBookRequestDto createBookRequestDto,
                          @PathVariable Long id) {
        return bookService.update(createBookRequestDto, id);
    }
}

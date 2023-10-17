package com.example.bookstore.controller;

import com.example.bookstore.dto.category.BookDtoWithoutCategoryIds;
import com.example.bookstore.dto.category.CategoryDto;
import com.example.bookstore.dto.category.CategoryDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/category")
@RestController
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    private BookService bookService;

    @GetMapping
    public List<CategoryDto> findAll(){

        return categoryService.findAll();
    }

    @PostMapping
    public CategoryDto createCategory(CategoryDto categoryDto){
       return categoryService.save(categoryDto);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @PutMapping("/{id}")
    public  CategoryDto updateCategory(@PathVariable Long id, CategoryDto categoryDto){
        return categoryService.update(id, categoryDto);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }


    @GetMapping("/{categoryId}/books")
    public List<BookDtoWithoutCategoryIds> findAllBooksByCategoryId(@PathVariable Long categoryId){
        return bookService.findAllBooksByCategoryId(categoryId);
    }

}

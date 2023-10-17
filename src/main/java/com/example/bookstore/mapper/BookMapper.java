package com.example.bookstore.mapper;

import com.example.bookstore.config.MapperConfig;
import com.example.bookstore.dto.BookDtoCategory;
import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import com.example.bookstore.dto.category.BookDtoWithoutCategoryIds;
import com.example.bookstore.model.Book;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {

    BookResponseDto toDto(Book book);

    Book toModel(CreateBookRequestDto bookRequestDto);

//    (HINT: BookDtoWithoutCategoryIds class could be used as a response class for @GetMapping("/{id}/books") endpoint)
    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);


//    @AfterMapping
//    default void setCategoryIds(@MappingTarget BookResponseDto bookDto, Book book) {
//
//    }
}

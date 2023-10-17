package com.example.bookstore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDtoCategory {
    private Long id;
    private String title;

    private String author;

    private String isbn;

    private BigDecimal price;
    private String description;
    private String coverImage;

}

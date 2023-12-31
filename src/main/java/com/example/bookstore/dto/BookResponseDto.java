package com.example.bookstore.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private String description;
    private String coverImage;
    private boolean isDeleted;
}

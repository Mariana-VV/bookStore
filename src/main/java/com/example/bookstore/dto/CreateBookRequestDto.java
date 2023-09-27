package com.example.bookstore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBookRequestDto {
    @NotNull(message = "Title cant be null")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    private String title;
    @NotNull (message = "Author cant be null")
    @Size(min = 1, max = 255, message = "Author must be between 1 and 255 characters")
    private String author;
    @NotNull (message = "Isbt cant be null")
    @Size(min = 11, max = 11, message = "Isbn must be 11 simbols")
    private String isbn;
    @NotNull(message = "Price cant be null")
    @Min (0)
    private BigDecimal price;
    private String description;
    private String coverImage;

}

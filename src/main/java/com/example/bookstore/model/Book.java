package com.example.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false,
            unique = true)
    private String isbn;
    @Column(nullable = false)
    private BigDecimal price;
    private String description;
    private String coverImage;

    public Book(Long id, String title,
                String author, String isbn,
                BigDecimal price, String description,
                String coverImage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.description = description;
        this.coverImage = coverImage;
    }

    public Book(String title, String author,
                String isbn, BigDecimal price,
                String description, String coverImage) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.description = description;
        this.coverImage = coverImage;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id
                + ", title='" + title + '\''
                + ", author='" + author + '\''
                + ", isbn='" + isbn + '\''
                + ", price=" + price
                + ", description='" + description + '\''
                + ", coverImage='" + coverImage + '\'' + '}';
    }
}

package com.example.bookstore.service;

import com.example.bookstore.dto.category.CategoryDto;
import com.example.bookstore.exception.EntityNotFoundException;
import com.example.bookstore.mapper.CategoryMapper;
import com.example.bookstore.model.Book;


import com.example.bookstore.model.Category;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;
    private final BookRepository bookRepository;

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(x -> categoryMapper.toDto(x)).toList();
    }



    public CategoryDto getById(Long id){
        return categoryMapper.toDto(categoryRepository.findById(id).get());
    }
   public CategoryDto save(CategoryDto categoryDto){
       Category category = categoryRepository.save(categoryMapper.toModel(categoryDto));
      return categoryMapper.toDto(category) ;
    }

   public CategoryDto update(Long id, CategoryDto categoryDto){

       if (!categoryRepository.existsById(id)) {
           throw new EntityNotFoundException("Entity exist nicht");
       }

       Category category = categoryMapper.toModel(categoryDto);
       category.setId(id);
       categoryRepository.save(category);

       return  categoryMapper.toDto(category);
    }

      public  void deleteById(Long id){
       categoryRepository.deleteById(id);
    }

//    {
//        "name":"Love",
//            "description":"shjsrfghsh"
//    }
}

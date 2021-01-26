package com.codecool.bookify.controller;

import com.codecool.bookify.model.Category;
import com.codecool.bookify.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> getCategory(){
        return categoryService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @PostMapping()
    public void addCategory(@RequestBody Category category){
        categoryService.insert(category);
    }

    @PutMapping(value = "/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable Long id) {
    }
}

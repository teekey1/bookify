package com.codecool.bookify.Controller;

import com.codecool.bookify.Model.Category;
import com.codecool.bookify.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getCategory(){
        return categoryService.getAll();
    }

    @GetMapping("categories/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getById(id);
    }

    @DeleteMapping("categories/{id}")
    public void removeCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @PostMapping("/categories")
    public void addCategory(@RequestBody Category category){
        categoryService.insert(category);
    }

    @PutMapping("/categories/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable Long id) {
    }
}

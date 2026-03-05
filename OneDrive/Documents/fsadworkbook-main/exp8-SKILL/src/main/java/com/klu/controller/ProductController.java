package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Product;
import com.klu.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    // Insert product
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return repo.save(product);
    }

    // Category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category){
        return repo.findByCategory(category);
    }

    // Price filter
    @GetMapping("/filter")
    public List<Product> filterPrice(@RequestParam double min,
                                     @RequestParam double max){
        return repo.findByPriceBetween(min,max);
    }

    // Sort products
    @GetMapping("/sorted")
    public List<Product> sortProducts(){
        return repo.sortByPrice();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price){
        return repo.findExpensiveProducts(price);
    }
}
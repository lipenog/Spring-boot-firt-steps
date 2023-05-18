package com.example.simplecrud.service;

import com.example.simplecrud.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(int id);
    public Product save(Product product);
    public void deleteProductById(int id);
}

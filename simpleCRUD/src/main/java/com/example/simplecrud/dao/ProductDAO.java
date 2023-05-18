package com.example.simplecrud.dao;

import com.example.simplecrud.entity.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> findAll();
    public Product findById(int id);
    public Product save(Product product);
    public void deleteProductById(int id);

}

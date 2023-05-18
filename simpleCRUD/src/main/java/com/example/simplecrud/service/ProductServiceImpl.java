package com.example.simplecrud.service;

import com.example.simplecrud.dao.ProductDAO;
import com.example.simplecrud.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductDAO productDAO;
    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    @Transactional
    public void deleteProductById(int id) {
        productDAO.deleteProductById(id);
    }
}

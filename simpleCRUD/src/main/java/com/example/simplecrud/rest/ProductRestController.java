package com.example.simplecrud.rest;

import com.example.simplecrud.dao.ProductDAO;
import com.example.simplecrud.entity.Product;
import com.example.simplecrud.service.ProductService;
import com.example.simplecrud.service.ProductServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable int id){
        Product product =  productService.findById(id);
        if(product == null){
            throw new RuntimeException("product id not found - " + id);
        }
        return product;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        // if the user pass an id by json, we force it to 0 so the DAO can handle this as a INSERT
        product.setId(0);
        Product newProduct = productService.save(product);
        return newProduct;
    }

    @PutMapping("/products")
    public Product update(@RequestBody Product product){
        Product updtProduct = productService.save(product);
        return updtProduct;
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable int id){
        Product product = productService.findById(id);

        if(product == null){
            throw new RuntimeException("product id not found - " + id);
        }

        productService.deleteProductById(id);
    }

}

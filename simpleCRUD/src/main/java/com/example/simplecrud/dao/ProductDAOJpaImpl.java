package com.example.simplecrud.dao;

import com.example.simplecrud.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOJpaImpl implements ProductDAO{
    private EntityManager entityManager;

    @Autowired
    public ProductDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product save(Product product) {
        // if id == 0, insert in the db else update the given product by the id
        Product newProduct = entityManager.merge(product);
        return newProduct;
    }


    @Override
    public void deleteProductById(int id) {
        Product product = entityManager.find(Product.class, id);

        entityManager.remove(product);
    }
}

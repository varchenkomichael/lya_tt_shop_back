package com.varchenko.ttshop.service;

import com.varchenko.ttshop.model.Product;

import java.util.List;

public interface ProductService {
    void insert(Product product);

    void insert(List<Product> products);

    List<Product> getAll();

    Product getById(int id);

    Product update(int id, Product product);

    void delete(int id);
}

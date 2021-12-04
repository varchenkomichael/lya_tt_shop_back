package com.varchenko.ttshop.repository;

import com.varchenko.ttshop.model.Product;

import java.util.List;

public interface ProductRepository {
    void insertProduct(Product product);

    void insertProducts(List<Product> products);

    List<Product> getAllProducts();

    Product getProductById(int id);

    Product updateProduct(int id, Product newProduct);

    void deleteProduct(int id);
}

package com.varchenko.ttshop.service;

import com.varchenko.ttshop.exception.ProductNotFoundException;
import com.varchenko.ttshop.repository.ProductRepository;
import com.varchenko.ttshop.model.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productDao) {
        this.productRepository = productDao;
    }

    @Override
    public void insert(Product product) {
        productRepository.insertProduct(product);
    }

    @Override
    public void insert(List<Product> products) {
        productRepository.insertProducts(products);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getById(int id) {
        if (productRepository.getProductById(id) != null) {
            return productRepository.getProductById(id);
        }
        throw new ProductNotFoundException("Product with current id" + StringUtils.SPACE + id + StringUtils.SPACE + "doesn't exist");
    }

    @Override
    public Product update(int id, Product product) {
        return productRepository.updateProduct(id, product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteProduct(id);
    }

}

package com.varchenko.ttshop.controller;

import com.varchenko.ttshop.model.Product;
import com.varchenko.ttshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(Product product) {
        productService.insert(product);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product updateProduct(@PathVariable("id") int id, Product newProduct) {
        productService.update(id, newProduct);
        return newProduct;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
    }
}

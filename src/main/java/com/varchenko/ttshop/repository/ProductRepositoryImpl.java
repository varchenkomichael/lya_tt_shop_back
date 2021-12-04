package com.varchenko.ttshop.repository;

import com.varchenko.ttshop.mapper.ProductMapper;
import com.varchenko.ttshop.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static final String UPDATE_SQL = "UPDATE product SET name = ?, price = ? WHERE product_id = ?";
    private static final String GET_BY_ID_SQL = "SELECT * FROM product WHERE product_id = ?";
    private static final String DELETE_SQL = "DELETE FROM product WHERE product_id = ?";
    private static final String INSERT_SQL = "INSERT INTO product VALUES (?, ?, ?)";
    private static final String GET_ALL_SQL = "SELECT * FROM product";
    private final JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertProduct(Product product) {
        jdbcTemplate.query(INSERT_SQL, new ProductMapper(product));
    }

    @Override
    public void insertProducts(List<Product> products) {
        jdbcTemplate.queryForList(INSERT_SQL, products);
    }

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query(GET_ALL_SQL, new ProductMapper());
    }

    @Override
    public Product getProductById(int id) {
        return jdbcTemplate.query(GET_BY_ID_SQL, new ProductMapper(), new Object[]{id}).get(0);
    }

    @Override
    public Product updateProduct(int id, Product newProduct) {
        jdbcTemplate.update(UPDATE_SQL, newProduct.getName(), newProduct.getPrice(), id);
        return newProduct;
    }

    @Override
    public void deleteProduct(int id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }
}

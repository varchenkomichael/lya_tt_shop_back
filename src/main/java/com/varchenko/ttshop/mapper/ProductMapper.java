package com.varchenko.ttshop.mapper;

import com.varchenko.ttshop.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    private final Product product;

    public ProductMapper(Product product) {
        this.product = product;
    }

    public ProductMapper() {
        this.product = new Product();
    }

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        product.setId(rs.getInt("product_id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }
}

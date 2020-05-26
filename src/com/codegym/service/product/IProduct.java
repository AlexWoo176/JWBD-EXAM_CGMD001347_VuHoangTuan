package com.codegym.service.product;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.ProductResponse;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    List<ProductResponse> finAll() throws SQLException;

    Product selectProduct(int id);

    void insertProduct(Product product, Category category) throws SQLException;

    boolean updateProduct(Product product, Category category) throws SQLException;

    boolean deleteProduct(int id) throws SQLException;

    List<Product> finAllByName(String name) throws SQLException;

}

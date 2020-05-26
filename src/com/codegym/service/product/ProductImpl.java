package com.codegym.service.product;

import com.codegym.constant.SystemConstant;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.ProductResponse;
import com.codegym.dao.JDBCConnection;
import com.codegym.service.category.CategoryServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl extends JDBCConnection implements IProduct {
    public ProductImpl() {
    }
    CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Override
    public List<ProductResponse> finAll() throws SQLException {
        List<ProductResponse> productList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SystemConstant.selectAllProduct)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category_name");

                ProductResponse product = new ProductResponse(id, name, price, quantity, color, description, category);
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement pstm = connection.prepareStatement(SystemConstant.selectAllById)
        ) {
            pstm.setInt(1, id);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("product_name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String des = resultSet.getString("description");
                String category = resultSet.getString("category");

                product = new Product(name, price, quantity, color, des, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void insertProduct(Product product, Category category) throws SQLException {
        String categoryName = category.getCategory_name();
        Integer categoryId = categoryService.findIdByCategoryName(categoryName);

        try (
                Connection connection = getConnection();
                PreparedStatement pstm = connection.prepareStatement(SystemConstant.insertProduct)
        ) {
            pstm.setString(1, product.getProduct_name());
            pstm.setInt(2, product.getPrice());
            pstm.setInt(3, product.getQuantity());
            pstm.setString(4, product.getColor());
            pstm.setString(5, product.getDescription());
            pstm.setInt(6, categoryId);

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateProduct(Product product, Category category) throws SQLException {
        boolean rowUpdate = false;
        try (
                Connection connection = getConnection();
                PreparedStatement pstm = connection.prepareStatement(SystemConstant.updateProduct);) {
            pstm.setInt(1, product.getId());
            pstm.setString(2, product.getProduct_name());
            pstm.setInt(3, product.getPrice());
            pstm.setInt(4, product.getQuantity());
            pstm.setString(5, product.getColor());
            pstm.setString(6, product.getDescription());

            rowUpdate = pstm.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted = false;
        try (
                Connection connection = getConnection();
                PreparedStatement pstm = connection.prepareStatement(SystemConstant.deleteProduct);
        ) {
            pstm.setInt(1, id);
            rowDeleted = pstm.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Product> finAllByName(String name) throws SQLException {
        List<Product> productList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement pstm = connection.prepareStatement(SystemConstant.findByNameProduct)
        ) {
            pstm.setString(1, name);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");

                productList.add(new Product(id, name, price, quantity, color, description, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}

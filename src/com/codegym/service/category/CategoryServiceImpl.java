package com.codegym.service.category;

import com.codegym.constant.SystemConstant;
import com.codegym.model.Category;
import com.codegym.dao.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl extends JDBCConnection implements ICategoryService {
    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> categories = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pstm = connection.prepareStatement(SystemConstant.selectAllCategory)) {
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("category_name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        }
        return categories;
    }

    @Override
    public Integer findIdByCategoryName(String categoryName) throws SQLException {
        Integer id = null;
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(SystemConstant.findByNameCategory)
        ) {
            statement.setString(1, "%" + categoryName + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        }
        return id;
    }
}

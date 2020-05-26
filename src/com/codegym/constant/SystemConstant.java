package com.codegym.constant;

public class SystemConstant {
    public static final String driverName = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/productdemo?autoReconnect=true&useSSL=false";
    public static final String user = "root";
    public static final String password = "123456";
    public static final String selectAllProduct = "select p.id, p.product_name, p.price, p.quantity, p.color, p.description, c.category_name \" +\n" +
            "            \"from product as p inner join category c on p.id_category = c.id_category";
    public static final String insertProduct = "insert into product (product_name, price, quantity, color, description, id_category) " +
            "values (?,?,?,?,?,?) ";
    public static final String updateProduct = "update product set product_name = ?, price = ?, quantity = ?, color = ?, description = ?, \" +\n" +
            "            \"id_category = ? where id = ?";

    public static final String deleteProduct = "delete from product where id = ?";

    public static final String findByNameProduct = "select p.id, p.product_name, p.price, p.quantity, p.color, p.description, c.category_name \" +\n" +
            "            \"from product as p inner join category c on p.id_category = c.id_category where product_name like ?";

    public static final String selectAllById = "select p.id, p.product_name, p.price, p.quantity, p.color, p.description, c.category_name \" +\n" +
            "            \"from product as p inner join category c on p.id_category = c.id_category where p.id";

    public static final String selectAllCategory = "select id_category, category_name from category";

    public static final String findByNameCategory = "select c.id_category from category c where c.category_name like ?";
}

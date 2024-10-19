package com.hexaware.techshop.dao;

import com.hexaware.techshop.entity.Product;
import com.hexaware.techshop.util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM products";
    private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM products WHERE id = ?";
    private static final String ADD_PRODUCT_QUERY = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
    private static final String UPDATE_PRODUCT_QUERY = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE id = ?";
    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM products WHERE id = ?";

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = DBConnUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(GET_ALL_PRODUCTS_QUERY)) {
            while (rs.next()) {
                Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        Product product = null;
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(GET_PRODUCT_BY_ID_QUERY)) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void addProduct(Product product) {
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(ADD_PRODUCT_QUERY)) {
            pstmt.setString(1, product.getProductName());  // Use correct getter
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getStock());  // Use correct getter
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_PRODUCT_QUERY)) {
            pstmt.setString(1, product.getProductName());  // Use correct getter
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getStock());  // Use correct getter
            pstmt.setInt(4, product.getProductId());  // Use correct getter
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE_PRODUCT_QUERY)) {
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

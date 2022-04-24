package com.tesda.daos;

import com.tesda.Dao;
import com.tesda.models.Product;
import com.tesda.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductsDao extends Dao {

    //Constructor
    public ProductsDao() throws ClassNotFoundException, SQLException{


    }

    public Product getProductByName(String name) throws SQLException{

        PreparedStatement statement = conn.prepareStatement("Select * FROM users WHERE product_name LIKE ?");
        statement.setString(1, "%"+name+"%");

        ResultSet rs = statement.executeQuery();

        if(rs.next()){
            return new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("uom"),
                    rs.getInt("max_level"),
                    rs.getInt("min_level"),
                    rs.getInt("reorder_level"),
                    rs.getString("location"),
                    rs.getBoolean("status"),
                    rs.getTimestamp("date_created"),
                    rs.getTimestamp("date_updated")
            );
        }else{
            return null;
        }
    }

    public Product getProductById(int id ) throws SQLException{

        PreparedStatement statement = conn.prepareStatement("Select * FROM products WHERE product_id = ?");
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        if(rs.next()){
            return new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("uom"),
                    rs.getInt("max_level"),
                    rs.getInt("min_level"),
                    rs.getInt("reorder_level"),
                    rs.getString("location"),
                    rs.getBoolean("status"),
                    rs.getTimestamp("date_created"),
                    rs.getTimestamp("date_updated")
            );
        }else{
            return null;
        }
    }

    public List<Product> getAllProducts() throws SQLException{

        List<Product> products = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("Select * FROM products");

        while(rs.next()){
            Product product = new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("uom"),
                    rs.getInt("max_level"),
                    rs.getInt("min_level"),
                    rs.getInt("reorder_level"),
                    rs.getString("location"),
                    rs.getBoolean("status"),
                    rs.getTimestamp("date_created"),
                    rs.getTimestamp("date_updated")
            );

            products.add(product);

        }

        return products;
    }


}

package com.tesda.daos;

import com.tesda.Dao;
import com.tesda.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao {

    //Constructor
    public UserDao() throws ClassNotFoundException, SQLException{

    }

    public List<User> getAllUser() throws SQLException{

        List<User> users = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("Select * FROM users");

        while(rs.next()){
            User user = new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getBoolean("user_type"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getBoolean("status"),
                    rs.getTimestamp("date_created"),
                    rs.getTimestamp("date_updated")
            );

            users.add(user);

        }
        return users;
    }

    public User getUserById(int id ) throws SQLException{

        PreparedStatement statement = conn.prepareStatement("Select * FROM users WHERE user_id = ?");
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        if(rs.next()){
            return new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getBoolean("user_type"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getBoolean("status"),
                    rs.getTimestamp("date_created"),
                    rs.getTimestamp("date_updated")
                    );
        }else{
            return null;
        }
    }

    public void updateUser(User user) {


    }
    public void deleteUser(User user){

    }
}

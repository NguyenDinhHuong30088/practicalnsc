package com.example.sqlinjection.dao;


import com.example.sqlinjection.model.User;
import com.example.sqlinjection.utils.ConnectionUtils;

import java.sql.*;

public class UserDao {
    Connection connection = ConnectionUtils.getConnection();

    public User getUser(String pName, String password) {
        User user = null;
        try {
            Statement statement = connection.createStatement();
            String sqlStatement = String.format("select * from users where username = '"+pName +"' and password = " +password);
            ResultSet res = statement.executeQuery(sqlStatement);
            while (res.next()){
                String name = res.getString("username");
                String pass = res.getString("password");
                user = new User(name, pass);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
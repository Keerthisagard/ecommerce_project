package com.cruds.db;

import com.cruds.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserDAO {

    public User getUserByEmail(String email) {
        User user = null;
        try (Connection connection = DBConnectionManager.getconnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?")) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String phoneNumber = resultSet.getString("phone_number");
                    // Omitting password for security reasons
                    user = new User(username, email, null, phoneNumber);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
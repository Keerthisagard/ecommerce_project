package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cruds.db.DBConnectionManager; // Import DBConnectionManager from your package

public class UserDao {
    // Method to register a new user
    public boolean registerUser(String username, String email, String password, String phoneNumber) {
        // SQL statement to insert user data
        String INSERT_USER_SQL = "INSERT INTO users (username, email, password, phone_number) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnectionManager.getconnection(); // Get connection from DBConnectionManager
             PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL)) {
            // Set parameters for the INSERT statement
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, phoneNumber);

            // Execute the INSERT statement
            int rowsInserted = statement.executeUpdate();

            // Check if user was successfully inserted
            return rowsInserted > 0;
        } catch (SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
            return false;
        }
    }

    // Method to check if a user with the given email already exists
    public boolean userExists(String email) {
        // SQL statement to select user by email
        String SELECT_USER_BY_EMAIL_SQL = "SELECT * FROM users WHERE email = ?";

        try (Connection connection = DBConnectionManager.getconnection(); // Get connection from DBConnectionManager
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_EMAIL_SQL)) {
            // Set parameters for the SELECT statement
            statement.setString(1, email);

            // Execute the SELECT statement
            try (ResultSet resultSet = statement.executeQuery()) {
                // If resultSet.next() returns true, it means a user with the given email exists
                return resultSet.next();
            }
        } catch (SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
            return false;
        }
    }
}
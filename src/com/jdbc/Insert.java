package com.jdbc;

import java.sql.*;

public class Insert {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Dhanureddy";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load the PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create the PreparedStatement object to execute queries
            String insertQuery = "INSERT INTO employee (employee_id, first_name, last_name) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);

            // Insert first row
            pstmt.setInt(1, 6);
            pstmt.setString(2, "John");
            pstmt.setString(3, "Doe");
            pstmt.executeUpdate();

            // Insert second row
            pstmt.setInt(1, 3);
            pstmt.setString(2, "Jane");
            pstmt.setString(3, "Smith");
            pstmt.executeUpdate();

            // Insert third row
            pstmt.setInt(1, 4);
            pstmt.setString(2, "Alice");
            pstmt.setString(3, "Johnson");
            pstmt.executeUpdate();

            System.out.println("Rows inserted successfully!");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

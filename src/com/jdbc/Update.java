package com.jdbc;

import java.sql.*;

public class Update {
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

            // Update data
            String updateQuery = "UPDATE employee SET first_name = ?, last_name = ? WHERE employee_id = ?";
            pstmt = conn.prepareStatement(updateQuery);

            // Update the first row
            pstmt.setString(1, "rohith");
            pstmt.setString(2, "Bhai");
            pstmt.setInt(3, 6);
            pstmt.executeUpdate();

            System.out.println("Row updated successfully!");

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

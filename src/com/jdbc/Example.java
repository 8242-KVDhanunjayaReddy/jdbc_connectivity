package com.jdbc;
import java.sql.*;
public class Example {
    private static final String URL = "jdbc:postgresql://localhost:5432/shopping";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Dhanureddy";

    public static void main(String[] args) {
        Connection conn = null;
       // Statement stmt = null;
        PreparedStatement stmt = null;
        //ResultSet rs = null;

        try{
            //Load the PostgreSQL Driver
            //Class.forName("org.postgresql.Driver");

            //Establish Connection
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//
//            String insertQuery = "INSERT INTO customers (customer_id, name, email) VALUES (?, ?, ?)";
//
//            stmt = conn.prepareStatement(insertQuery);

            // Insert first row
//            stmt.setInt(1, 6);
//            stmt.setString(2, "John");
//            stmt.setString(3, "Doe");
//            stmt.executeUpdate();

            //Create the statement object to execute queries
           // stmt = conn.createStatement();

            //PreparedStatement (Parameterized), CallableStatement (StoresProcedure)
            //Retriving the data
           // String query = "select * from customers";
            //INSERT INTO Customers(first_name, last_name) values(?, ?)
            //rs = stmt.executeQuery(query);//executeUpdate

            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create the PreparedStatement object to execute queries
            String insertQuery = "INSERT INTO customers(customer_id, name) VALUES (?, ?)";
            stmt = conn.prepareStatement(insertQuery);

            ((PreparedStatement) stmt).setInt(1, 234);
            ((PreparedStatement) stmt).setString(2, "John");
            stmt.executeUpdate();

            //Process the data
//            while (rs.next()) {
//                int id = rs.getInt("customer_id");
//                String name = rs.getString("name");
//             // String email = rs.getString("email");
//                System.out.println(id + "\n "+ name + "\n " );
//            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }

            }catch (SQLException e){}
        }

    }
}


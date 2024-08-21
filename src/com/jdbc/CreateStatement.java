package com.jdbc;

import java.sql.*;
public class CreateStatement{
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Dhanureddy";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            //Load the PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            //Establish Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            //Create the statement object to execute queries
            stmt = conn.createStatement();

            //PreparedStatement (Parameterized), CallableStatement (StoresProcedure)
            //Retriving the data
            String query = "select * from employee";
            //INSERT INTO Customers(first_name, last_name) values(?, ?)
            rs = stmt.executeQuery(query);//executeUpdate

            //Process the data
            while (rs.next()) {

                int id = rs.getInt("employee_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                System.out.println(id + "\n " + first_name + "\n " + last_name);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(rs != null){
                    rs.close();
                }
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


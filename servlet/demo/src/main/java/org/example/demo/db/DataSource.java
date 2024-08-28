package org.example.demo.db;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSource {

    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static final HikariDataSource ds = new HikariDataSource();

    static {
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setJdbcUrl(URL);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    public static void close(Connection con, PreparedStatement pstmt) {
        // TODO Auto-generated method stub
        try {

            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
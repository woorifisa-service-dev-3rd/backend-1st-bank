package org.example.demo.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.demo.db.DataSource.getConnection;

public class MemberDAO {

    public int findByLoginIdAndPassword(String userId, String password) {
        final String query = "select * from member where user_id = ? and password = ?";
        Connection connection;
        ResultSet resultSet;
        PreparedStatement pstmt;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public void save(String userId, String password) {
        final String query = "insert into member (user_id, password) values(?,?)";
        Connection connection;
        PreparedStatement pstmt;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

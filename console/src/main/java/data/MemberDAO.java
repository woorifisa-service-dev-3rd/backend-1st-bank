package data;

import db.DBUtil;
import domain.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    // Finds a member by login ID and password
    public Member findByLoginIdAndPassword(String loginId, String password) throws SQLException {
        final String query = "SELECT * FROM member WHERE login_id = ? AND password = ?";

        // Use try-with-resources to ensure all resources are closed properly
        try (Connection connection = DBUtil.getConnection("src/resource/jdbc.properties");
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, loginId);
            pstmt.setString(2, password);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    return new Member(id, loginId, name, password);
                }
            }
        }
        return null;
    }
}

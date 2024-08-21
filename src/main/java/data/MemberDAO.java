package data;

import db.DBUtil;
import domain.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    public Member findByLoginIdAndPassword(String loginId, String password) throws SQLException {
        final String query = "select * from member where login_id = ? and password = ?";
        Connection connection = DBUtil.getConnection("src/resource/jdbc.properties");
		PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, loginId);
        pstmt.setString(2, password);
        ResultSet resultSet = pstmt.executeQuery();
		try (connection; pstmt; resultSet;) {
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
				return new Member(id, loginId, name, password);
			}
		}
        return null;
    }
}

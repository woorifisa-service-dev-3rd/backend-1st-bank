package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBUtil;
import domain.Account;

public class TargetAccountDAO {
	
	public Account findByTargetNumber(String targetNumber) throws SQLException {
		final String query = "select id, number, type, total_money from account "
							+ "where number = ?";
		
		Connection connection = DBUtil.getConnection("src/resource/jdbc.properties");
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, targetNumber);
		
		ResultSet resultSet = pstmt.executeQuery();
		try (connection; pstmt; resultSet;) {
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String number = resultSet.getString("number");
				String type = resultSet.getString("type");
				int total_money = resultSet.getInt("total_money");
				return new Account(id, number, type, total_money);
			}
		}
        return null;
	}

}

package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import domain.Account;

public class AccountDAO {
	
	public List<Account> findAllByMemberId(int member_id) throws SQLException {
		
		final String query = "select * from Account where member_id = ?";
		
		List<Account> AccountList = new ArrayList<>();
		
		Connection connection = DBUtil.getConnection("src/resource/jdbc.properties"); // 여기서 서버와 연결을 하는
		PreparedStatement pstmt = connection.prepareStatement(query); // 여기서 이제 쿼리를 보낸다.
		
		pstmt.setInt(1, member_id);
		
		ResultSet resultSet = pstmt.executeQuery();  // 여기서 쿼리를 보내서 나온 답을 resultSet에 저장이 되도록 한다.
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String number = resultSet.getString("number");
			String type = resultSet.getString("type");
			int total_money = resultSet.getInt("total_money");
			
			
			AccountList.add( new Account(id,number,type,total_money));
		}
		return AccountList;
	}
}

package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBUtil;
import domain.Record;

public class RecordDAO {
	
	public void saveMyRecord(Record myRecord) throws SQLException {
		final String query = "insert into record (type, date, money, target_account_id, account_id) "
				+ "values (?, ?, ?, ?, ?)";
		
		Connection connection = DBUtil.getConnection("resources/jdbc.properties");
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, myRecord.getType());
		pstmt.setDate(2, myRecord.getDate());
		pstmt.setInt(3, myRecord.getMoney());
		pstmt.setInt(4, myRecord.getTarget_account_id());
		pstmt.setInt(5, myRecord.getAccount_id());
		pstmt.executeUpdate();
	}
	
	public void saveTargetRecord(Record targetRecord) throws SQLException {
		final String query = "insert into record (type, date, money, target_account_id, account_id) "
				+ "values (?, ?, ?, ?, ?)";
		
		Connection connection = DBUtil.getConnection("resources/jdbc.properties");
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, targetRecord.getType());
		pstmt.setDate(2, targetRecord.getDate());
		pstmt.setInt(3, targetRecord.getMoney());
		pstmt.setInt(4, targetRecord.getTarget_account_id());
		pstmt.setInt(5, targetRecord.getAccount_id());
		pstmt.executeUpdate();
	}

}

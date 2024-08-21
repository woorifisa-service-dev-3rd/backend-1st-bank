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
	
	public List<Account> findByMemberIdAndBankId(int memberId, int bankId) throws SQLException {
		final String query = "select a.id, a.number, a.type, a.total_money from bank b "
						+ "join account a on b.id = a.bank_id "
						+ "where b.id = ? "
						+ "and a.member_id = ?";
		
		List<Account> accounts = new ArrayList<>();
		Connection connection = DBUtil.getConnection("resources/jdbc.properties");
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setInt(1, bankId);
		pstmt.setInt(2,  memberId);
		
		ResultSet resultSet = pstmt.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String number = resultSet.getString("number");
			String type = resultSet.getString("type");
			int total_money = resultSet.getInt("total_money");
			accounts.add(new Account(id, number, type, total_money));
		}
		return accounts;
	}
	
	public void updateMyAccountSetMoney(int accountId, int totalMoney, int money) throws SQLException {
		final String query = "update account set total_money = ? where id = ?";
		
		Connection connection = DBUtil.getConnection("resources/jdbc.properties");
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setInt(1, totalMoney - money);
		pstmt.setInt(2, accountId);	
		pstmt.executeUpdate();
	}
	
	public void updateTargetAccountSetMoney(int targetAccountId, int totalMoney, int money) throws SQLException {
		final String query = "update account set total_money = ? where id = ?";
		
		Connection connection = DBUtil.getConnection("resources/jdbc.properties");
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setInt(1, totalMoney + money);
		pstmt.setInt(2, targetAccountId);	
		pstmt.executeUpdate();
	}
}

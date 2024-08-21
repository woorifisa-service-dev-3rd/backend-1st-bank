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

	// Fetches all accounts for a given member ID
	public List<Account> findAllByMemberId(int memberId) throws SQLException {
		final String query = "SELECT * FROM Account WHERE member_id = ?";

		List<Account> accountList = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection("src/resources/jdbc.properties");
			 PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setInt(1, memberId);
			try (ResultSet resultSet = pstmt.executeQuery()) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String number = resultSet.getString("number");
					String type = resultSet.getString("type");
					int totalMoney = resultSet.getInt("total_money");
					accountList.add(new Account(id, number, type, totalMoney));
				}
			}
		}
		return accountList;
	}

	// Fetches accounts for a given member ID and bank ID
	public List<Account> findByMemberIdAndBankId(int memberId, int bankId) throws SQLException {
		final String query = "SELECT a.id, a.number, a.type, a.total_money FROM bank b "
				+ "JOIN account a ON b.id = a.bank_id "
				+ "WHERE b.id = ? AND a.member_id = ?";

		List<Account> accounts = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection("src/resources/jdbc.properties");
			 PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setInt(1, bankId);
			pstmt.setInt(2, memberId);
			try (ResultSet resultSet = pstmt.executeQuery()) {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String number = resultSet.getString("number");
					String type = resultSet.getString("type");
					int totalMoney = resultSet.getInt("total_money");
					accounts.add(new Account(id, number, type, totalMoney));
				}
			}
		}
		return accounts;
	}

	// Updates the total money for the given account ID (subtracting money)
	public void updateMyAccountSetMoney(int accountId, int totalMoney, int money) throws SQLException {
		final String query = "UPDATE account SET total_money = ? WHERE id = ?";

		try (Connection connection = DBUtil.getConnection("src/resources/jdbc.properties");
			 PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setInt(1, totalMoney - money);
			pstmt.setInt(2, accountId);
			pstmt.executeUpdate();
		}
	}

	// Updates the total money for the target account ID (adding money)
	public void updateTargetAccountSetMoney(int targetAccountId, int totalMoney, int money) throws SQLException {
		final String query = "UPDATE account SET total_money = ? WHERE id = ?";

		try (Connection connection = DBUtil.getConnection("src/resources/jdbc.properties");
			 PreparedStatement pstmt = connection.prepareStatement(query)) {

			pstmt.setInt(1, totalMoney + money);
			pstmt.setInt(2, targetAccountId);
			pstmt.executeUpdate();
		}
	}
}

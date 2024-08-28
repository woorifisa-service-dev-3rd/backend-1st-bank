package org.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.demo.db.DataSource;
import org.example.demo.domain.Account;
import org.example.demo.util.DBUtil;

public class AccountDAO {
		
		// Fetches all accounts for a given member ID
		public List<Account> findByMemberIdAndBankId(int memberId, int bankId) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset;
			Account account;
			List<Account> accountList = new ArrayList<>();
		
			final String query = "SELECT a.id, a.number, a.type, a.total_money FROM bank b "
					+ "JOIN account a ON b.id = a.bank_id "
					+ "WHERE b.id = ? AND a.member_id = ?";

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(query);
				
				pstmt.setInt(1, bankId);
				pstmt.setInt(2, memberId);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					int id = rset.getInt("id");
					String number = rset.getString("number");
					String type = rset.getString("type");
					int totalMoney = rset.getInt("total_money");
					accountList.add(new Account(id, number, type, totalMoney));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.close(con, pstmt);
			}			
			return accountList;
		}
		
		public List<Account> findAll() throws ClassNotFoundException {
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rset;
	        List<Account> accountList = new ArrayList<>();

	        String query = "SELECT * FROM Account";

	        try {
	            con = DBUtil.getConnection();
	            pstmt = con.prepareStatement(query);
	            rset = pstmt.executeQuery();
	            while (rset.next()) {
	                int id = rset.getInt("id");
	                String number = rset.getString("number");
	                String type = rset.getString("type");
	                int totalMoney = rset.getInt("total_money");
	                accountList.add(new Account(id, number, type, totalMoney));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }  finally {
	            DataSource.close(con, pstmt);
	        }

	        return accountList;
	    }
}

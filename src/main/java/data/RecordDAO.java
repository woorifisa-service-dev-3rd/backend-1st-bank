package data;

import db.DBUtil;
import domain.Record;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordDAO {

    public List<Record> findRecordsByAccountIdAndDateRange(int accountId, Date startDate, Date endDate) throws SQLException {
        final String query = "SELECT * FROM Record WHERE account_id = ? AND date BETWEEN ? AND ? order by date ASC";
        Connection connection = DBUtil.getConnection("src/resource/jdbc.properties");
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, accountId);
        pstmt.setDate(2, startDate);
        pstmt.setDate(3, endDate);

        ResultSet resultSet = pstmt.executeQuery();
        List<Record> recordList = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String type = resultSet.getString("type");
            Date date = resultSet.getDate("date");
            int money = resultSet.getInt("money");
            int targetAccountId = resultSet.getInt("target_account_id");
            String memo = resultSet.getString("memo");

            recordList.add(new Record(id, type, date, money, targetAccountId, accountId, memo));
        }

        return recordList;
    }
}

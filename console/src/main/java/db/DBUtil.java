package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    public static Connection getConnection(String argument) {

        try {
            // 외부 라이브러리 불러오기
            Properties prop = DBConfigurer.readProperties(argument);

            final String USER_NAME = prop.getProperty("USER_NAME");
            final String PASSWORD = prop.getProperty("PASSWORD");
            final String DB_URL = prop.getProperty("DB_URL");
            final String DATABASE = prop.getProperty("DATABASE");

            Connection connection = DriverManager.getConnection(DB_URL + DATABASE, USER_NAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

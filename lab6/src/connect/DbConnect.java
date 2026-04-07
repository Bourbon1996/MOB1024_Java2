package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DBNAME = "lab06_jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "28091996";

    private static final String URL =
            "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME +
            "?useSSL=false&serverTimezone=UTC";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
            return null;
        }
    }
}
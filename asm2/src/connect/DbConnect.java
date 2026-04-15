package connect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	public class DbConnect {
		    private static final String HOST = "localhost";
		    private static final String PORT = "3306";
		    private static final String DBNAME = "asm2";
		    private static final String USER = "root";
		    private static final String PASSWORD = "28091996";
		
		    private static final String URL =
		        "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME +
		        "?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
		
		    public static Connection getConnection() {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            return DriverManager.getConnection(URL, USER, PASSWORD);
		        } catch (SQLException e) {
		            logConnectionFailure(e);
		            throw new RuntimeException("Lỗi kết nối DB");
		        } catch (Exception e) {
		            ExceptionLogging.logUnException("DBConnect.getConnection", e);
		            throw new RuntimeException(e);
		        }
		    }
		
		    private static void logConnectionFailure(SQLException e) {
		        int code = e.getErrorCode();
		        String msg = e.getMessage() != null ? e.getMessage() : "";
		
		        if (code == 1045) {
		            System.err.println("Sai USER/PASSWORD.");
		        } else if (code == 1049) {
		            System.err.println("Sai tên database.");
		        } else if (code == 0 && msg.contains("Communications link failure")) {
		            System.err.println("MySQL chưa chạy hoặc sai host/port.");
		        } else {
		            System.err.println("SQL Error [" + code + "]: " + msg);
		        }
		    }
    
}
package connect;

public class ExceptionLogging {
    public static void logUnException(String message, Exception e) {
        System.err.println("Lỗi không xác định tại: " + message);
        e.printStackTrace();
    }
}
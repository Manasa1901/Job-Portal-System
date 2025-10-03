import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/job_portal";
    private static final String USER = "root";   
    private static final String PASSWORD = "Manasa@123";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully!");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }

    // 🔹 Test connection here
    public static void main(String[] args) {
        getConnection();
    }
}

import java.sql.*;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/job_portal";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Manasa@123";

//Database connection
    public static Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println(" Database connected.");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Couldn't connect to DB.");
            e.printStackTrace();
        }
        return conn;
    }
    
    // Insert a new job seeker
    public static void addJobSeeker(String name, String email, String pwd, String skills, int exp) {
        String sql = "INSERT INTO job_seekers (name, email, password, skills, experience) VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        try {
            conn = getDBConnection();
            if (conn == null) {
                System.out.println("Connection failed. Skipping insert.");
                return;
            }
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, pwd);     
                ps.setString(4, skills);
                ps.setInt(5, exp);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Job seeker added successfully.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error inserting job seeker record.");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) conn.close();
            } catch (SQLException ignore) {}
        }
    }

    // Fetch all job seekers from the DB
    public static void listJobSeekers() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;

        try {
            conn = getDBConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM job_seekers";
            res = stmt.executeQuery(sql);

            System.out.println("\n--- Job Seekers ---");
            while (res.next()) {
                System.out.println(
                    "ID: " + res.getInt("id") +
                    ", Name: " + res.getString("name") +
                    ", Email: " + res.getString("email") +
                    ", Skills: " + res.getString("skills") +
                    ", Experience: " + res.getInt("experience") + " years"
                );
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving job seekers list.");
            e.printStackTrace();
        } finally {
            try {
                if (res != null) res.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ignore) {}
        }
    }

    //  UPDATE JobSeeker
    public static void updateJobSeeker(int id, String name, String email, String skills, int experience) {
        String query = "UPDATE job_seekers SET name = ?, email = ?, skills = ?, experience = ? WHERE id = ?";

        try (Connection conn = getDBConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, skills);
            stmt.setInt(4, experience);
            stmt.setInt(5, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("JobSeeker updated successfully!");
            } else {
                System.out.println("No record found with that ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE JobSeeker
    public static void deleteJobSeeker(int id) {
        String query = "DELETE FROM job_seekers WHERE id = ?";

        try (Connection conn = getDBConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("JobSeeker deleted successfully!");
            } else {
                System.out.println("No record found with that ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Testing
    public static void main(String[] args) {
        //addJobSeeker("Manasa", "manasa@example.com", "pass123", "Java, SQL", 2);
        //updateJobSeeker(3, "Manasa H", "manasa.h@example.com", "Java, SQL, Spring", 3);
        //listJobSeekers();
        deleteJobSeeker(2);
        listJobSeekers();
    }
}

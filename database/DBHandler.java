import java.sql.*;
import java.util.*;

public class DBHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/ElectricityDB";
    private static final String USER = "root";       // your MySQL username
    private static final String PASSWORD = "root";   // your MySQL password

    // Save consumer + bill into database
    public static void saveToDB(Consumer consumer) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO bills (consumer_id, consumer_name, units, bill_amount) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, consumer.getConsumerID());
            ps.setString(2, consumer.getConsumerName());
            ps.setDouble(3, consumer.getUnits());
            ps.setDouble(4, consumer.getBillAmount());
            ps.executeUpdate();
            System.out.println(" Bill saved to database!");
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
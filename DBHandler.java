package mypackage;


import java.sql.*;
import java.util.*;

public class DBHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/electricitydb";
    private static final String USER = "root";       
    private static final String PASSWORD = "Ashmika@123";   


    public static void saveToDB(consumer consumer) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO bills (consumer_id, consumer_name, units, bill_amount) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, consumer.getConsumerID());
            ps.setString(2, consumer.getConsumerName());
            ps.setDouble(3, consumer.getUnits());
            ps.setDouble(4, consumer.getbillAmount());
            ps.executeUpdate();
            System.out.println(" Bill saved to database!");
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
    

    
    public static List<consumer> readFromDB() {
        List<consumer> consumers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM bills";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("consumer_id");
                String name = rs.getString("consumer_name");
                double units = rs.getDouble("units");
                double bill = rs.getDouble("bill_amount");
                consumers.add(new consumer(name, id, units, bill));
            }
        } catch (SQLException e) {
            System.out.println("⚠ Error reading from DB: " + e.getMessage());
        }
        return consumers;
    }
}


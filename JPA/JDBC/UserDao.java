import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private final DatabaseConnection db = new DatabaseConnection();

    public void run() throws SQLException {

        try (Connection connection = db.getConnection()) {

            // Create table
            try (Statement statement = connection.createStatement()) {
                String createSql = 
                    "CREATE TABLE IF NOT EXISTS userTable (" +
                    "user_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "user_name VARCHAR(20), " +
                    "age INT)";
                statement.executeUpdate(createSql);
            }

            // Insert
            String insertSql = 
                "INSERT INTO userTable(user_name, age) VALUES (?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setString(1, "Alice");
                ps.setInt(2, 25);
                ps.executeUpdate();
            }

            // Select
            String selectSql = "SELECT * FROM userTable";

            try (PreparedStatement ps = connection.prepareStatement(selectSql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    System.out.println(
                        rs.getInt("user_id") + " " +
                        rs.getString("user_name") + " " +
                        rs.getInt("age")
                    );
                }
            }
        }
    }
}

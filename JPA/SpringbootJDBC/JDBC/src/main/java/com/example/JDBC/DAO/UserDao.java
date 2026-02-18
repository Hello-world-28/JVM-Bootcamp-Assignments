import com.example.JDBC.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    email VARCHAR(150) NOT NULL
                )
                """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating table", e);
        }
    }

    public void createUser(String name, String email) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting user", e);
        }
    }

    public String readUsers() {
        String sql = "SELECT id, name, email FROM users";
        StringBuilder result = new StringBuilder();

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                result.append(rs.getInt("id"))
                        .append(" | ")
                        .append(rs.getString("name"))
                        .append(" | ")
                        .append(rs.getString("email"))
                        .append("\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error reading users", e);
        }

        return result.toString();
    }
}

import com.example.JDBC.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTable(){
        jdbcTemplate.execute(
                "CREATE TABLE IF NOT EXISTS users (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "name VARCHAR(100) NOT NULL, " +
                        "email VARCHAR(150) NOT NULL UNIQUE, " +
                        "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)"
        );
    }

    public void insertUser(String name, String email){
        String insertQuery = "INSERT INTO users (name, email) VALUES (?, ?)";
        jdbcTemplate.update(insertQuery, name, email);
    }

    public List<User> getUsers(){
        String selectQuery = "SELECT * FROM users";
        return jdbcTemplate.query(selectQuery, (rs, rowNum) -> {
            User user = new User();
            user.setUserId(rs.getInt("id"));
            user.setUserName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }
}

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.JDBC.DAO.UserDao;

@RestController
@RequestMapping("/jdbc")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/get-user-plain-jdbc")
    public String getUser() {
        userDao.createTable();
        userDao.createUser("Alice", "alice@email.com");
        return userDao.readUsers();

    }
}

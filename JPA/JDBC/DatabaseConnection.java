import java.sql.Connection;     //Represents an active session with a database
import java.sql.DriverManager;      //factory for database connections.
import java.sql.SQLException;//Checked exception for database failures.
//It is checked because database failures are expected operational events, not programming errors.
//DB unavailable, Bad credentials, Invalid SQL, Network error

public class DatabaseConnection{

    private static final String URL="jdbc:h2:mem:userDB;DB_CLOSE_DELAY=-1";//Protocol prefix required by JDBC+driver type+memory database+Database name
    //Multiple connections using the same name share the same in memory database, but only while at least one connection is open.
    /*
    DB_CLOSE_DELAY=-1
        Without this:
        When last connection closes
        The database disappears

    With this:
        Database stays alive until JVM shuts down
    */
    private static final String USER="sa";
    private static final String PASSWORD="";

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    /*
    What Happens Internally

    When called:
        1.DriverManager scans registered drivers
        2.Finds H2 driver
        3.Calls driver.connect(...)
        4.H2:
            Creates or retrieves the in memory DB
            Authenticates user
            Allocates internal structures
        5.Returns a live Connection
    */ 
}
/*
in real applications. Use a connection pool such as:
    HikariCP
    Spring Boot’s built-in DataSource

Why?
    Connection creation is expensive. Pools reuse connections and handle timeouts, leaks, and concurrency.
*/
/*
Because an H2 in memory database is not a file. It is just data structures inside the JVM heap.
Internally, H2 keeps something like:
    Map<String, DatabaseInstance>
    Key = "userDB"
    Value = in memory database object

    When a connection is requested:

H2 checks if a database named userDB already exists.
    If yes, it attaches the new connection to that same in memory instance.
    If no, it creates a new one.
    So the name acts as a key.
That is why:
    jdbc:h2:mem:userDB
        from two different calls returns connections to the same database.

An in memory DB only lives in RAM.
    H2 tracks active sessions.
When the last connection closes:
    No sessions are using the database
    No references remain
    H2 removes the database instance
Memory is freed
From H2’s perspective:
    There is no reason to keep it alive.

Unlike a file database:
There is nothing to persist to disk.

DB_CLOSE_DELAY=-1 Changes This
    You tell H2:
        Do not destroy the database when the last connection closes.

Instead:
Keep it alive until JVM shutdown.
Internally, H2 keeps a strong reference so it is not garbage collected.

H2’s in memory mode is optimized for:
    Unit tests
    Embedded apps
    Temporary data
    Fast startup

Automatic cleanup is safer by default.

If you use:
    jdbc:h2:mem:
        without a name
        each connection gets its own private in memory database.
        No sharing at all.
        The name is what enables sharing.
*/
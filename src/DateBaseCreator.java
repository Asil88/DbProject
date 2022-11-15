import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DateBaseCreator {
    public static void main(String[] args) {

        createAlbumTable();
    }

    public static Connection connect() throws SQLException {
        Connection connection;
        String url = "jdbc:sqlite:D:\\Program\\JavaHomework\\DbProject\\datebase.sqlite";
        connection = DriverManager.getConnection(url);
        return connection;
    }

    public static void createAlbumTable() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            int userId = new Scanner(System.in).nextInt();
            int id = new Scanner(System.in).nextInt();
            int title = new Scanner(System.in).nextInt();
            statement.execute(String.format("INSERT INTO albums (userId, id, title) VALUES (%d, %d, '%s')", userId, id, title));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

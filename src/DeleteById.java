import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteById {
    public static final Scanner scanner = new Scanner(System.in);
    public static Connection connect() throws SQLException {
        Connection connection;
        String url = Console.URL;
        connection = DriverManager.getConnection(url);
        return connection;
    }



    public static void deleteAlbumsById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            //int id = new Scanner(System.in).nextInt();
            System.out.println("Введите id для удаления  строки в таблице");
            int id = scanner.nextInt();
            statement.execute(String.format("DELETE FROM albums WHERE id = %d", id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteCommentsById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите id для удаления  строки в таблице");
            int id = scanner.nextInt();
            statement.execute(String.format("DELETE FROM comments WHERE id = %d", id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deletePhotosById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите id для удаления  строки в таблице");
            int id = scanner.nextInt();
            statement.execute(String.format("DELETE FROM photos WHERE id = %d", id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deletePostsById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите id для удаления  строки в таблице");
            int id = scanner.nextInt();
            statement.execute(String.format("DELETE FROM posts WHERE id = %d", id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteUsersById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите id для удаления  строки в таблице");
            int id = scanner.nextInt();
            statement.execute(String.format("DELETE FROM users WHERE id = %d", id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteTableAlbums() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            statement.execute("DELETE FROM albums");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

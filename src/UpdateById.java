import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateById {
    public static Connection connect() throws SQLException {
        Connection connection;
        String url = Console.URL;
        connection = DriverManager.getConnection(url);
        return connection;
    }


    public static void updateAlbumsById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id строки из таблицы");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите title для его обновления в таблице");
            String title = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE albums SET title = '%s' WHERE id = %d",title,id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateCommentsById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id строки из таблицы");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите name для его обновления в таблице");
            String name = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE comments SET name = '%s' WHERE id = %d",name,id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updatePhotosById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id строки из таблицы");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите title для его обновления в таблице");
            String title = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE photos SET title = '%s' WHERE id = %d",title,id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updatePostsById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id строки из таблицы");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите title для его обновления в таблице");
            String title = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE posts SET title = '%s' WHERE id = %d",title,id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateUsersById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id строки из таблицы");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите username для его обновления в таблице");
            String username = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE users SET username = '%s' WHERE id = %d",username,id));
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

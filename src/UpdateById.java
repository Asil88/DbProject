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
            System.out.println("Введите Id строки из таблицы albums");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите title для его обновления в таблице albums");
            String title = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE albums SET title = '%s' WHERE id = %d",title,id));
            System.out.println(String.format("Поле title под id %d обновлено...",id));
            System.out.println("----------------------------------------------------------------");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateCommentsById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id строки из таблицы comments");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите name для его обновления в таблице comments");
            String name = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE comments SET name = '%s' WHERE id = %d",name,id));
            System.out.println(String.format("Поле name под id %d обновлено...",id));
            System.out.println("----------------------------------------------------------------");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updatePhotosById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id строки из таблицы photos");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите title для его обновления в таблице photos");
            String title = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE photos SET title = '%s' WHERE id = %d",title,id));
            System.out.println(String.format("Поле title под id %d обновлено...",id));
            System.out.println("----------------------------------------------------------------");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updatePostsById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id строки из таблицы posts");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите title для его обновления в таблице posts");
            String title = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE posts SET title = '%s' WHERE id = %d",title,id));
            System.out.println(String.format("Поле title под id %d обновлено...",id));
            System.out.println("----------------------------------------------------------------");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateUsersById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id строки из таблицы users");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Введите username для его обновления в таблице users");
            String username = new Scanner(System.in).nextLine();
            statement.execute(String.format("UPDATE users SET username = '%s' WHERE id = %d",username,id));
            System.out.println(String.format("Поле username под id %d обновлено...",id));
            System.out.println("----------------------------------------------------------------");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

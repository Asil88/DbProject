import java.net.URL;
import java.sql.*;
import java.util.Scanner;

public class SelectBy {
    public static void main(String[] args) {
        SelectAlbum();
    }
    public static Connection connect() throws SQLException {
        Connection connection;
        String url = Console.URL;
        connection = DriverManager.getConnection(url);
        return connection;
    }

    public static void SelectAlbumById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите userId для выдачи совпадений с title  ");
            int userId = new Scanner(System.in).nextInt();
            ResultSet albumIdSet = statement.executeQuery(String.format("SELECT title FROM albums WHERE userId = %d", userId));
            while (albumIdSet.next()) {
                System.out.println(albumIdSet.getString("title"));
                System.out.println("------------------------------------------------------------");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void SelectAlbum() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите userId для выдачи совпадений с title  ");
            //int userId = new Scanner(System.in).nextInt();
            ResultSet albumIdSet = statement.executeQuery("SELECT title FROM albums WHERE userId = ?");
            while (albumIdSet.next()) {
                System.out.println(albumIdSet.getString("title"));
                System.out.println("------------------------------------------------------------");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void SelectCommentsByPostId() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите postId для выдачи совпадений с emails");
            int postId = new Scanner(System.in).nextInt();
            ResultSet albumIdSet = statement.executeQuery(String.format("SELECT email FROM comments WHERE postId = %d", postId));
            while (albumIdSet.next()) {
                System.out.println(albumIdSet.getString("email"));
                System.out.println("------------------------------------------------------------");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void SelectPhotosByAlbumId() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите albumId для выдачи совпадений с thumbnailUrl");
            int albumId = new Scanner(System.in).nextInt();
            ResultSet albumIdSet = statement.executeQuery(String.format("SELECT thumbnailUrl FROM photos WHERE albumId = %d", albumId));
            while (albumIdSet.next()) {
                System.out.println(albumIdSet.getString("thumbnailUrl"));
                System.out.println("------------------------------------------------------------");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void SelectPostsByUserId() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите UserId для выдачи совпадений с body");
            int UserId = new Scanner(System.in).nextInt();
            ResultSet albumIdSet = statement.executeQuery(String.format("SELECT body FROM posts WHERE UserId = %d", UserId));
            while (albumIdSet.next()) {
                System.out.println(albumIdSet.getString("body"));
                System.out.println("------------------------------------------------------------");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void SelectUsersById() {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            System.out.println("Введите Id для выдачи совпадений с username ");
            int id = new Scanner(System.in).nextInt();
            ResultSet albumIdSet = statement.executeQuery(String.format("SELECT username FROM users WHERE UserId = %d", id));
            while (albumIdSet.next()) {
                System.out.println(albumIdSet.getString("username"));
                System.out.println("------------------------------------------------------------");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}

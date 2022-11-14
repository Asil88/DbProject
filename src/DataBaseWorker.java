import objects.Albums;
import objects.Comments;
import objects.Photos;
import objects.Posts;
import objects.users.User;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class DataBaseWorker {

    public static void main(String[] args) throws IOException, SQLException {
        GsonHundler gsonHundler = new GsonHundler();

        List<Albums> albums = gsonHundler.parseAlbumsJsonToObject();
        List<Comments> comments = gsonHundler.parseCommentsJsonToObject();
        List<Photos> photos = gsonHundler.parsePhotosJsonToObject();
        List<Posts> posts = gsonHundler.parsePostsJsonToObject();
        List<User> users = gsonHundler.parseUsersJsonToObject();


       /* DataBaseWorker.createAlbumsTable(albums);
        DataBaseWorker.createCommentsTable(comments);
        DataBaseWorker.createPhotosTable(photos);*/

        //DataBaseWorker.createPostsTable(posts);
        //DataBaseWorker.createUsersTable(users);

        DataBaseWorker.deleteAlbumsById(1);

    }


    public static void createAlbumsTable(List<Albums> albums) {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            statement.execute("""
                        Create table if not exists albums(
                         id INTEGER,
                         userId INTEGER,
                         title VARCHAR NOT NULL
                        )
                    """);
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO albums (id, UserId, title) VALUES");
            for (Albums album : albums) {
                sb.append("(").append(album.getId()).append(", ")
                        .append(album.getUserId()).append(",")
                        .append("'").append(album.getTitle()).append("'")
                        .append(")").append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            statement.execute(sb.toString());
            //statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteAlbumsById(Integer id) {
        try (Connection con = connect()) {
            Statement statement = con.createStatement();
            statement.execute(String.format("DELETE FROM albums WHERE id = %d", id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read() {


    }


    public static void createCommentsTable(List<Comments> comments) {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            statement.execute("""
                        Create table if not exists comments(
                        postId INTEGER,
                        id INTEGER,
                        name VARCHAR NOT NULL,
                        email VARCHAR NOT NULL,
                        body VARCHAR NOT NULL
                        )
                    """);
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO comments (postId, id, name,email,body) VALUES");
            for (Comments comment : comments) {
                sb.append("(").append(comment.getPostId()).append(", ")
                        .append(comment.getId()).append(",")
                        .append("'").append(comment.getName()).append("'").append(",")
                        .append("'").append(comment.getEmail()).append("'").append(",")
                        .append("'").append(comment.getBody()).append("'")
                        .append(")").append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            statement.execute(sb.toString());
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createPhotosTable(List<Photos> photos) {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            statement.execute("""
                        Create table if not exists photos( 
                        albumId INTEGER,     
                        id INTEGER,
                        title VARCHAR NOT NULL,
                        url VARCHAR NOT NULL,
                        thumbnailUrl VARCHAR NOT NULL
                        )
                    """);
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO photos (albumId, id, title, url, thumbnailUrl) VALUES");
            for (Photos photo : photos) {
                sb.append("(").append(photo.getAlbumId()).append(", ")
                        .append(photo.getId()).append(",")
                        .append("'").append(photo.getTitle()).append("'").append(",")
                        .append("'").append(photo.getUrl()).append("'").append(",")
                        .append("'").append(photo.getThumbnailUrl()).append("'")
                        .append(")").append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            statement.execute(sb.toString());
            //statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createPostsTable(List<Posts> posts) {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            statement.execute("""
                        Create table if not exists posts( 
                        userId INTEGER,     
                        id INTEGER,
                        title VARCHAR NOT NULL,
                        body VARCHAR NOT NULL,
                        )
                    """);
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO posts (userId, id, title, body) VALUES");
            for (Posts post : posts) {
                sb.append("(").append(post.getUserId()).append(", ")
                        .append(post.getId()).append(",")
                        .append("'").append(post.getTitle()).append("'").append(",")
                        .append("'").append(post.getBody()).append("'")
                        .append(")").append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            statement.execute(sb.toString());
            //statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createUsersTable(List<User> users) {
        try (Connection connect = connect()) {
            Statement statement = connect.createStatement();
            statement.execute("""
                        Create table if not exists users(
                    	id varchar not null,
                    	username varchar not null,
                    	email varchar not null,
                    	street varchar not null,
                    	suite varchar not null,
                    	city varchar not null,
                    	zipcode varchar not null,
                    	lat varchar not null,
                    	lng varchar not null,
                    	phone varchar not null,
                    	website varchar not null,
                    	name varchar not null,
                    	catchPhrase varchar not null,
                    	bs varchar not null
                        )
                    """);

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO users(id," + "name," + " username," + " email," + " street," + " suite," + " city," +
                    " zipcode," + " lat," + " lng," + " phone," + " website," + " name," + " catchPhrase," + " bs) VALUES");
            for (User user : users) {
                String id = user.getId();
                String name = user.getName();
                String username = user.getUserName();
                String email = user.getEmail();
                String street = user.getAddress().getStreet();
                String suite = user.getAddress().getSuite();
                String city = user.getAddress().getCity();
                String zipcode = user.getAddress().getZipcode();
                String lat = user.getAddress().getGeo().getLat();
                String lng = user.getAddress().getGeo().getLng();
                String phone = user.getPhone();
                String website = user.getWebsite();
                String companyName = user.getCompany().getCompanyName();
                String catchPhrase = user.getCompany().getCatchPhrase();
                String bs = user.getCompany().getBs();
                sb.append("(").append("'").append(id).append("', ")
                        .append("'").append(name).append("', ")
                        .append("'").append(username).append("', ")
                        .append("'").append(email).append("', ")
                        .append("'").append(street).append("', ")
                        .append("'").append(suite).append("', ")
                        .append("'").append(city).append("', ")
                        .append("'").append(zipcode).append("', ")
                        .append("'").append(lat).append("', ")
                        .append(", ").append(lng).append("', ")
                        .append("'").append(phone).append("', ")
                        .append("'").append(website).append("', ")
                        .append("'").append(companyName).append("', ")
                        .append("'").append(catchPhrase).append("', ")
                        .append("'").append(bs).append("'").append(")").append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            statement.execute(sb.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void show() {
        try (Connection connect = connect()) {
            PreparedStatement preparedStatement = connect.prepareStatement("""
                        SELECT u.username FROM users u
                        JOIN posts p ON u.id = p.user_id
                        WHERE p.id = ?
                        LIMIT 1
                    """);

            int idPostFromUrl = new Scanner(System.in).nextInt();

            preparedStatement.setInt(1, idPostFromUrl);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString(1);
                System.out.println(title);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection connect() throws SQLException {
        Connection connection;
        String url = "jdbc:sqlite:C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\datebase.sqlite";
        connection = DriverManager.getConnection(url);
        return connection;
    }

}


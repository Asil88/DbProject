import classes.Albums;
import classes.Comments;
import classes.Photos;
import classes.Posts;
import classes.users.User;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class DataBaseRecord {

    public static void main(String[] args) throws IOException, SQLException {
        GsonHundler gsonHundler = new GsonHundler();

        List<Albums> albums = gsonHundler.parseAlbumsJsonToObject();
        List<Comments> comments = gsonHundler.parseCommentsJsonToObject();
        List<Photos> photos = gsonHundler.parsePhotosJsonToObject();
        List<Posts> posts = gsonHundler.parsePostsJsonToObject();
        List<User> users = gsonHundler.parseUsersJsonToObject();


        DataBaseRecord.createAlbumsTable(albums);
        DataBaseRecord.createCommentsTable(comments);
        DataBaseRecord.createPhotosTable(photos);
        DataBaseRecord.createPostsTable(posts);
        //DataBaseRecord.createUsersTable(users);


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
            sb.append("INSERT INTO albums (userId, id, title) VALUES");
            for (Albums album : albums) {
                sb.append("(").append(album.getUserId()).append(", ")
                        .append(album.getId()).append(",")
                        .append("'").append(album.getTitle()).append("'")
                        .append(")").append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            statement.execute(sb.toString());
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
            statement.close();
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
                        body VARCHAR NOT NULL
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
            statement.close();
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
                    	name varchar not null,
                    	userName varchar not null,
                    	email varchar not null,
                    	street varchar not null,
                    	suite varchar not null,
                    	city varchar not null,
                    	zipcode varchar not null,
                    	lat varchar not null,
                    	lng varchar not null,
                    	phone varchar not null,
                    	website varchar not null,
                    	companyName varchar not null,
                    	catchPhrase varchar not null,
                    	bs varchar not null
                        )
                    """);
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO users(id,name,username,email,street,suite,city," +
                    "zipcode,lat,lng,phone,website,companyName,catchPhrase,bs) VALUES");
            for (User user : users) {
                sb.append("(").append("'").append(user.getId()).append("', ")
                        .append("'").append(user.getName()).append("', ")
                        .append("'").append(user.getUserName()).append("', ")
                        .append("'").append(user.getEmail()).append("', ")
                        .append("'").append(user.getAddress().getStreet()).append("', ")
                        .append("'").append(user.getAddress().getSuite()).append("', ")
                        .append("'").append(user.getAddress().getCity()).append("', ")
                        .append("'").append(user.getAddress().getZipcode()).append("', ")
                        .append("'").append(user.getAddress().getGeo().getLat()).append("', ")
                        .append("'").append(user.getAddress().getGeo().getLng()).append("', ")
                        .append("'").append(user.getPhone()).append("', ")
                        .append("'").append(user.getWebsite()).append("', ")
                        .append("'").append(user.getCompany().getCompanyName()).append("', ")
                        .append("'").append(user.getCompany().getCatchPhrase()).append("', ")
                        .append("'").append(user.getCompany().getBs()).append("'")
                        .append(")").append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            statement.execute(sb.toString());
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection connect() throws SQLException {
        Connection connection;
        String url = Console.URL;
        connection = DriverManager.getConnection(url);
        return connection;
    }

}


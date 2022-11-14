import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import objects.Albums;
import objects.Comments;
import objects.Photos;
import objects.Posts;
import objects.users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class GsonHundler {

    public static void main(String[] args) throws Exception {

        GsonHundler gsonHundler = new GsonHundler();

        List<Albums> albums = gsonHundler.parseAlbumsJsonToObject();
        List<Comments> comments = gsonHundler.parseCommentsJsonToObject();
        List<Photos> photos = gsonHundler.parsePhotosJsonToObject();
        List<Posts> posts = gsonHundler.parsePostsJsonToObject();
        List<User> users = gsonHundler.parseUsersJsonToObject();

        gsonHundler.toJsonFileAlbums("D:\\Program\\JavaHomework\\DbProject\\outputJsons\\outAlbums.json", albums);
        gsonHundler.toJsonFileComments("D:\\Program\\JavaHomework\\DbProject\\outputJsons\\outComments.json", comments);
        gsonHundler.toJsonFilePhotos("D:\\Program\\JavaHomework\\DbProject\\outputJsons\\outPhotos.json", photos);
        gsonHundler.toJsonFilePosts("D:\\Program\\JavaHomework\\DbProject\\outputJsons\\outPosts.json", posts);
        gsonHundler.toJsonFileUsers("D:\\Program\\JavaHomework\\DbProject\\outputJsons\\outUser.json", users);

        //gsonHundler.toJsonFileUsers("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outUser.json", users);
    }

    public ArrayList<Albums> parseAlbumsJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("D:\\Program\\JavaHomework\\DbProject\\inputJsons\\albums.json"), new TypeReference<>() {
        });
    }

    public ArrayList<Comments> parseCommentsJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("D:\\Program\\JavaHomework\\DbProject\\inputJsons\\comments.json"), new TypeReference<>() {
        });
    }

    public ArrayList<Photos> parsePhotosJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("D:\\Program\\JavaHomework\\DbProject\\inputJsons\\photos.json"), new TypeReference<>() {
        });
    }

    public ArrayList<Posts> parsePostsJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("D:\\Program\\JavaHomework\\DbProject\\inputJsons\\posts.json"), new TypeReference<>() {
        });
    }

    public ArrayList<User> parseUsersJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("D:\\Program\\JavaHomework\\DbProject\\inputJsons\\users.json"), new TypeReference<>() {
        });
    }


    void toJsonFileAlbums(String file, List<Albums> albums) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), albums);
    }

    void toJsonFileComments(String file, List<Comments> comments) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), comments);
    }

    void toJsonFilePhotos(String file, List<Photos> photos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), photos);
    }

    void toJsonFilePosts(String file, List<Posts> posts) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), posts);
    }

    void toJsonFileUsers(String file, List<User> users) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), users);
    }


}

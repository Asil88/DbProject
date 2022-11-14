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

        gsonHundler.toJsonFileAlbums("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outAlbums.json", albums);
        gsonHundler.toJsonFileComments("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outComments.json", comments);
        gsonHundler.toJsonFilePhotos("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outPhotos.json", photos);
        gsonHundler.toJsonFilePosts("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outPosts.json", posts);
        gsonHundler.toJsonFileUsers("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outUser.json", users);
    }

    public ArrayList<Albums> parseAlbumsJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\albums.json"), new TypeReference<>() {
        });
    }

    public ArrayList<Comments> parseCommentsJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\comments.json"), new TypeReference<>() {
        });
    }

    public ArrayList<Photos> parsePhotosJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\photos.json"), new TypeReference<>() {
        });
    }

    public ArrayList<Posts> parsePostsJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\posts.json"), new TypeReference<>() {
        });
    }

    public ArrayList<User> parseUsersJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\users.json"), new TypeReference<>() {
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

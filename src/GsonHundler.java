import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import classes.Albums;
import classes.Comments;
import classes.Photos;
import classes.Posts;
import classes.users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class GsonHundler {

    public ArrayList<Albums> parseAlbumsJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // return mapper.readValue(new File("D:\\Program\\TeachMeSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json"), List.class);
        System.out.println("albums.json считан и записан в лист albums");
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\albums.json"), new TypeReference<>() {
        });
    }

    public ArrayList<Comments> parseCommentsJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("comments.json считан и записан в лист comments");
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\comments.json"), new TypeReference<>() {
        });
    }

    public ArrayList<Photos> parsePhotosJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("photos.json считан и записан в лист photos");
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\photos.json"), new TypeReference<>() {
        });
    }

    public ArrayList<Posts> parsePostsJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("posts.json считан и записан в лист posts");
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\posts.json"), new TypeReference<>() {
        });
    }

    public ArrayList<User> parseUsersJsonToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("users.json считан и записан в лист users");
        return mapper.readValue(new File("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\inputJsons\\users.json"), new TypeReference<>() {
        });
    }


    public void toJsonFileAlbums(String file, List<Albums> albums) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), albums);
        System.out.println("Лист albums преобразован в .json файл");
    }

    public void toJsonFileComments(String file, List<Comments> comments) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), comments);
        System.out.println("Лист comments преобразован в .json файл");
    }

    public void toJsonFilePhotos(String file, List<Photos> photos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), photos);
        System.out.println("Лист photos преобразован в .json файл");
    }

    public void toJsonFilePosts(String file, List<Posts> posts) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), posts);
        System.out.println("Лист posts преобразован в .json файл");
    }

    public void toJsonFileUsers(String file, List<User> users) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), users);
        System.out.println("Лист users преобразован в .json файл");
    }


}


import objects.Albums;
import objects.Comments;
import objects.Photos;
import objects.Posts;
import objects.users.User;


import javax.xml.bind.JAXBException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Console {
    public static void start() throws JAXBException, IOException {
        Console console = new Console();
        console.Select();
    }

    public  void Select() throws JAXBException, IOException {

        /*GsonHundler gsonHundler = new GsonHundler();

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

        DataBaseCreator.createAlbumsTable(albums);
        DataBaseCreator.createCommentsTable(comments);
        DataBaseCreator.createPhotosTable(photos);
        DataBaseCreator.createPostsTable(posts);
        DataBaseCreator.createUsersTable(users);*/


       /* DeleteById.deleteAlbumsById();
        DeleteById.deleteCommentsById();
        DeleteById.deletePhotosById();
        DeleteById.deletePostsById();
        DeleteById.deleteUsersById();*/

        /*UpdateById.updateAlbumsById();
        UpdateById.updateCommentsById();
        UpdateById.updatePhotosById();
        UpdateById.updatePostsById();
        UpdateById.updateUsersById();*/

      /*  SelectBy.SelectAlbumById();
        SelectBy.SelectCommentsByPostId();
        SelectBy.SelectPhotosByAlbumId();
        SelectBy.SelectPostsByUserId();
        //SelectBy.SelectUsersById();

*/


    }
}
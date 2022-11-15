import classes.Albums;
import classes.Comments;
import classes.Photos;
import classes.Posts;
import classes.users.User;
import com.google.gson.stream.JsonToken;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Console {
    public static void startMain() throws JAXBException, IOException {
        Console console = new Console();
        console.start();
    }

    public static final String URL = "jdbc:sqlite:C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\datebase.sqlite";
    private static GsonHundler gsonHundler = new GsonHundler();

    boolean isTrue = true;

    List<Albums> albums;
    List<Comments> comments;
    List<Photos> photos;
    List<Posts> posts;
    List<User> users;


    public void start() throws JAXBException, IOException {

        while (isTrue) {
            System.out.print("""
                Меню
                ----------------------------------------------------------------
                Нажмите 1 для парсинга .json файлов и записи их в листы объектов
                Нажмите 2 для привидения листов объектов в .json файлы
                Нажмите 3 для импорта таблиц в базу данных
                Нажмите 4 для удаления полей из таблиц по id 
                Нажмите 5 для обновления полей по id таблиц
                Нажмите 6 для выбора значений из базы данных
                Нажмите 7 для создания записи в таблице
                ----------------------------------------------------------------
                """);
            System.out.println("Введите число...");
            switch (new Scanner(System.in).nextInt()) {
                case 1: {
                    albums = gsonHundler.parseAlbumsJsonToObject();
                    comments = gsonHundler.parseCommentsJsonToObject();
                    photos = gsonHundler.parsePhotosJsonToObject();
                    posts = gsonHundler.parsePostsJsonToObject();
                    users = gsonHundler.parseUsersJsonToObject();
                    break;
                }
                case 2: {
                    gsonHundler.toJsonFileAlbums("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outAlbums.json", albums);
                    gsonHundler.toJsonFileComments("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\comments.json", comments);
                    gsonHundler.toJsonFilePhotos("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outPhotos.json", photos);
                    gsonHundler.toJsonFilePosts("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outPosts.json", posts);
                    gsonHundler.toJsonFileUsers("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\OneProject\\outputJsons\\outUser.json", users);
                    break;
                }
                case 3: {

                    DataBaseRecord.recordAlbumsTable(albums);
                    DataBaseRecord.recordCommentsTable(comments);
                    DataBaseRecord.recordPhotosTable(photos);
                    DataBaseRecord.recordPostsTable(posts);
                    //DataBaseRecord.createUsersTable(users);
                    break;
                }

                case 4: {
                    DeleteById.deleteAlbumsById();
                    DeleteById.deleteCommentsById();
                    DeleteById.deletePhotosById();
                    DeleteById.deletePostsById();
                    //DeleteById.deleteUsersById();

                    break;
                }
                case 5: {
                    UpdateById.updateAlbumsById();
                    UpdateById.updateCommentsById();
                    UpdateById.updatePhotosById();
                    UpdateById.updatePostsById();
                    //UpdateById.updateUsersById();

                    break;
                }
                case 6: {
                    SelectBy.SelectAlbumById();
                    SelectBy.SelectCommentsByPostId();
                    SelectBy.SelectPhotosByAlbumId();
                    SelectBy.SelectPostsByUserId();
                    //SelectBy.SelectUsersById()

                    break;
                }
                case 7: {
                    //DateBaseCreator.createAlbumTable();

                }
                default: {
                    isTrue = false;
                    break;
                }
            }
        }
    }
}
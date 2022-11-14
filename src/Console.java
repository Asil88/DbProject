
import objects.Albums;


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


    public void Select() throws JAXBException, IOException {
        Scanner scanner = new Scanner(System.in);
        GsonHundler gsonHundler = new GsonHundler();
        JaxbHundler jaxbHundler = new JaxbHundler();

        Path newXmlPath = Path.of("newXMLFile.xml");
        Path xmlPath = Path.of("newXMLFile.xml");
        Path newJsonPath = Path.of("jsonParseTest");
        Path jsonPath = Path.of("jsonParseTest");

        Path jsonTest = Path.of("albums.json");


        List<Albums> albums = gsonHundler.parseAlbumsJsonToObject();





    }





/*
        System.out.println("""
                Введите '1' для сериализации в XML файл
                Введите '2' для десериализации из XML в объект
                Введите '3' для записи в JSON
                Введите '4' для чтения из JSON
                Введите '5' для сохранения в файл
                """);


        int choose = scanner.nextInt();
        switch (choose) {
            case 1: {
                jaxbHundler.parseToAlbumObj(String.valueOf(newXmlPath),albums1);

            }
            case 2: {
                jaxbHundler.parseToObj(String.valueOf(xmlPath));

            }
            case 3: {
                gsonHundler.toJsonFileAlbums(String.valueOf(jsonPath), albums);

            }
            case 4: {
                gsonHundler.parseAlbumsJsonToObject();

            }
            case 5: {
                *//*System.out.println("Введите название файла...");
                String newPath = scanner.nextLine();
                write(Path.of(newPath),document);*//*
                write(Path.of("FileTest"), document);
            }
        }
    }*/

    /*void write(Path file, Document document) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(file)));
        bufferedWriter.write(String.valueOf(document));
        bufferedWriter.close();
    }*/
}

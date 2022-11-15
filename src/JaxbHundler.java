import classes.Albums;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class JaxbHundler {

    public static void main(String[] args) throws JAXBException {
        JaxbHundler jaxbHundler = new JaxbHundler();
        Path path = Path.of("C:\\Users\\Anton\\Programming\\IdeaProjects\\TeachSkills\\JavaHomework\\SemiProject\\inputJsons\\albums.json");
        Albums albums = jaxbHundler.parseToAlbumObj(String.valueOf(path));
    }

    public Albums parseToAlbumObj(String filePath) throws JAXBException {
        Albums unmarshal = null;
        JAXBContext jaxbContext = JAXBContext.newInstance(Albums.class);
        Unmarshaller jaxbUmarshaller = jaxbContext.createUnmarshaller();
        unmarshal = (Albums) jaxbUmarshaller.unmarshal(new File(filePath));
        return unmarshal;
    }

    public void toXmlFileAlbum(String filePath, List<Albums> albums) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Albums.class);
        Marshaller jaxbUnmarshaller = jaxbContext.createMarshaller();
        jaxbUnmarshaller.marshal(albums, new File(filePath));
    }


 /*public  Document parseToObj(String filePath) throws JAXBException {
            Document unmarshal = null;
            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            Unmarshaller jaxbUmarshaller = jaxbContext.createUnmarshaller();
            unmarshal = (Document) jaxbUmarshaller.unmarshal(new File(filePath));
            return unmarshal;
        }*/

       /* public  void toXmlFile(String filePath, Document document) throws JAXBException {
            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            Marshaller jaxbUnmarshaller = jaxbContext.createMarshaller();
            jaxbUnmarshaller.marshal(document, new File(filePath));
        }*/
}



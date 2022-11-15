package classes;


/*@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)*/
public class Albums {
    //@XmlElement(name = "student")
    private int userId;
   // @XmlElement(name = "student")
    private int id;
   // @XmlElement(name = "student")
    private String title;

    public Albums() {}

    public Albums(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "objects.Albums{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

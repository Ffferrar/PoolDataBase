package logic.docs;

import javax.persistence.*;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.UUID;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "startDate")
    private GregorianCalendar startDate;

    @Column(name = "endDate")
    private GregorianCalendar endDate;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "userId")
    private String userId;



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }
    public void setStartDate() {
        this.startDate = new GregorianCalendar();
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }
    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}

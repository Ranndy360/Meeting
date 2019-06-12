package sv.com.core.meeting.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "meeting")
public class Meeting implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private int user_id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Meeting() {
    }

    public Meeting(int user_id, Date date) {
        this.user_id = user_id;
        this.date = date;
    }
}

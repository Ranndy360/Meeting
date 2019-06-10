package sv.com.core.meeting.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name="user_agend")
public class User implements Serializable {


    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User() {}

    public User(String name, String lastname) {
        super();
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "], lastname=" + lastname + "]";
    }
}

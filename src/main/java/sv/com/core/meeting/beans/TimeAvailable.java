package sv.com.core.meeting.beans;

import sv.com.core.meeting.model.User;

import java.io.Serializable;
import java.util.ArrayList;

public class TimeAvailable implements Serializable {

    private String time;
    private ArrayList<User> users;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}

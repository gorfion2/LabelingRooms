package pl.labelingRooms.model.dbo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String username;
    @ManyToMany(mappedBy = "teacherList")
    private List<Room> roomList;

    @OneToMany(mappedBy = "teacher")
    private List<Event> events;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (!name.equals(teacher.name)) return false;
        if (!surname.equals(teacher.surname)) return false;
        return username.equals(teacher.username);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + username.hashCode();
        return result;
    }
}

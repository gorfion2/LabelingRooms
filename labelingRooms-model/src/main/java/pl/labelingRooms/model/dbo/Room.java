package pl.labelingRooms.model.dbo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
@Entity
public class Room {

    @Id
    @GeneratedValue
    private long id;
    private int number;

    @OneToMany(mappedBy = "room")
    private List<Event> eventList;
    @ManyToMany
    @JoinTable(name = "teacher_room",joinColumns = {@JoinColumn(name = "room_id")},inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
    private List<Teacher> teacherList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}

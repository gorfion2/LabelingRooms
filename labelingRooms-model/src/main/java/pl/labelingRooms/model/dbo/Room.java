package pl.labelingRooms.model.dbo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
@Entity
public class Room {

    @Id
    private Long number;

    @OneToMany(mappedBy = "room")
    private List<Event> eventList;
    @ManyToMany
    @JoinTable(name = "teacher_room",joinColumns = {@JoinColumn(name = "room_id")},inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
    private List<Teacher> teacherList;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
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

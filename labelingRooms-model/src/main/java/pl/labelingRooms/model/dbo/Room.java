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
    private String labColor;
    private String labelColor;
    private String borderColor;
    private String backgroundColor;


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

    public String getLabColor() {
        return labColor;
    }

    public void setLabColor(String labColor) {
        this.labColor = labColor;
    }

    public String getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(String labelColor) {
        this.labelColor = labelColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
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

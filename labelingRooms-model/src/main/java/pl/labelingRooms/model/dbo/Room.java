package pl.labelingRooms.model.dbo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
@Entity
public class Room {

    @Id
    private String number;
    private String labColor;
    private String labelColor;
    private String borderColor;
    private String backgroundColor;
    private Boolean teacherRoom;
    private String title;
    private Integer eventFontSize;
    private Integer messageFontSize;


    @OneToMany(mappedBy = "room")
    private List<Event> eventList;
    @ManyToMany
    @JoinTable(name = "teacher_room", joinColumns = {@JoinColumn(name = "room_id")}, inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
    private List<Teacher> teacherList;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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

    public Boolean getTeacherRoom() {
        return teacherRoom;
    }

    public void setTeacherRoom(Boolean teacherRoom) {
        this.teacherRoom = teacherRoom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEventFontSize() {
        return eventFontSize;
    }

    public void setEventFontSize(Integer eventFontSize) {
        this.eventFontSize = eventFontSize;
    }

    public Integer getMessageFontSize() {
        return messageFontSize;
    }

    public void setMessageFontSize(Integer messageFontSize) {
        this.messageFontSize = messageFontSize;
    }
}

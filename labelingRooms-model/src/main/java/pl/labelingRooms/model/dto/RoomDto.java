package pl.labelingRooms.model.dto;

import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
public class RoomDto {
    private String number;
    private String labColor;
    private String labelColor;
    private String borderColor;
    private String backgroundColor;
    private boolean yourRoom;
    private boolean teacherRoom;
    private List<String> teacherNameList;
    private String title;
    private Integer eventFontSize;
    private Integer messageFontSize;

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

    public List<String> getTeacherNameList() {
        return teacherNameList;
    }

    public void setTeacherNameList(List<String> teacherNameList) {
        this.teacherNameList = teacherNameList;
    }

    public boolean isYourRoom() {
        return yourRoom;
    }

    public void setYourRoom(boolean yourRoom) {
        this.yourRoom = yourRoom;
    }

    public boolean isTeacherRoom() {
        return teacherRoom;
    }

    public void setTeacherRoom(boolean teacherRoom) {
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

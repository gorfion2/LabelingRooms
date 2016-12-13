package pl.labelingRooms.model.dto;

import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
public class RoomDto {
    private Long number;
    private String labColor;
    private String labelColor;
    private String borderColor;
    private String backgroundColor;
    private boolean yourRoom;
    private List<String> teacherNameList;

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
}

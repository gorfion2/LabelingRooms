package pl.labelingRooms.model.dto;

/**
 * Created by Kamil on 2016-11-12.
 */
public class RoomDto {
    private Long number;
    private String labColor;
    private String labelColor;
    private String borderColor;
    private String backgroundColor;

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
}

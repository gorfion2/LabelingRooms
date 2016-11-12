package pl.labelingRooms.model.dto;

/**
 * Created by Kamil on 2016-11-12.
 */
public class EventDto {

    private String title;
    private int weekDayIndex;
    private int startHour;
    private int startMinute;
    private int duration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeekDayIndex() {
        return weekDayIndex;
    }

    public void setWeekDayIndex(int weekDayIndex) {
        this.weekDayIndex = weekDayIndex;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

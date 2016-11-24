package pl.labelingRooms.model;

/**
 * Created by Kamil on 2016-11-12.
 */
public enum WeekDay {
    MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4),
    SATURDAY(5), SUNDAY(6);

    WeekDay(int index) {
        this.index = index;
    }

    public int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static WeekDay getValue(int index) {
        for (WeekDay weekDay : WeekDay.values()) {
            if (weekDay.getIndex() == index)
                return weekDay;
        }
        return null;
    }


}

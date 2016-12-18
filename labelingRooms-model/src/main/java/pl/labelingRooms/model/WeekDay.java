package pl.labelingRooms.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 2016-11-12.
 */
public enum WeekDay {
    MONDAY("Poniedziałek"), TUESDAY("Wtorek"), WEDNESDAY("Środa"), THURSDAY("Czwartek"), FRIDAY("Piątek"),
    SATURDAY("Sobota"), SUNDAY("Niedziela");

    private String name;

    private WeekDay(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static WeekDay getValue(String name) {
        for (WeekDay weekDay : WeekDay.values()) {
            if (weekDay.getName().equals(name))
                return weekDay;
        }
        return null;
    }

    public static List<String> getDayNames(boolean oddWeek) {
        List<String> names = new ArrayList();
        for (WeekDay weekDay : WeekDay.values()) {
            if (oddWeek)
                names.add(weekDay.getName() + " np");
            else
                names.add(weekDay.getName());
        }
        return names;
    }


}

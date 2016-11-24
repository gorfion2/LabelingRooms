package pl.labelingRooms.model;

/**
 * Created by Kamil on 2016-11-12.
 */
public enum WeekDay {
    MONDAY("Poniedziałek"), TUESDAY("Wtorek"), WEDNESDAY("Środa"), THURSDAY("Czwartek"), FRIDAY("Piątek"),
    SATURDAY("Sobota"), SUNDAY("Niedziala");

    private String name;

    private WeekDay(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static WeekDay getValue(String name) {
        for (WeekDay weekDay : WeekDay.values()) {
            if (weekDay.getName() == name)
                return weekDay;
        }
        return null;
    }


}

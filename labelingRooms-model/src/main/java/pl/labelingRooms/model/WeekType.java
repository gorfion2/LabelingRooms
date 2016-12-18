package pl.labelingRooms.model;

/**
 * Created by Kamil on 2016-11-12.
 */
public enum WeekType {
    EVEN("Parzysty"), ODD("Nieparzysty"), ALL("Każdy");

    private String name;

    private WeekType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static WeekType getValue(String name) {
        for (WeekType weekType : WeekType.values()) {
            if (weekType.getName().equals(name))
                return weekType;
        }
        return null;
    }
}

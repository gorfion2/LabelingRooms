package pl.labelingRooms.model;

/**
 * Created by Kamil on 2016-11-22.
 */
public class InvalidDataException extends Exception {
    private final String reason;

    public InvalidDataException(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}

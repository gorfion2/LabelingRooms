package pl.labelingRooms.model;

/**
 * Created by Kamil on 2016-11-27.
 */
public class Status {
    private final String message;
    private final Boolean success;

    public Status(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }
}

package pl.labelingRooms.model;

/**
 * Created by Kamil on 2016-11-21.
 */
public class DataWrapper<T> {
    public String message;
    public T data;

    public DataWrapper(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

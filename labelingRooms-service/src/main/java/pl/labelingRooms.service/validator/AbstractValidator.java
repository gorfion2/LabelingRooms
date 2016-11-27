package pl.labelingRooms.service.validator;

import pl.labelingRooms.model.InvalidDataException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Kamil on 2016-11-22.
 */
public abstract class AbstractValidator<DTO> {

    abstract public void validate(DTO dto) throws InvalidDataException;

    protected void validateNotNull(Object object) throws InvalidDataException {
        if (object == null) {
            throw new InvalidDataException("Object is null");
        }
    }

    protected void validateAllFieldNotNull(DTO dto,String... exceptions) throws InvalidDataException {
        List<String> exceptionsList = Arrays.asList(exceptions);
        Optional<Field> nullField = Arrays.stream(dto.getClass().getDeclaredFields()).filter(field -> {
            if (exceptionsList.contains(field.getName()))
                return false;
            boolean accessible = field.isAccessible();
            try {
                field.setAccessible(true);
                return field.get(dto) == null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                field.setAccessible(accessible);
            }
            return false;
        }).findAny();
        if (nullField.isPresent()) {
            throw new InvalidDataException(nullField.get().getName() + " is null");
        }


    }
}

package pl.labelingRooms.service.validator;

import pl.labelingRooms.model.InvalidDataException;

import java.util.Arrays;

/**
 * Created by Kamil on 2016-11-22.
 */
public abstract class AbstractValidator<DTO> {

    abstract public void validate(DTO dto) throws InvalidDataException;

    protected void validateNotNull(Object object) throws InvalidDataException {
        if (object == null) {
            throw new InvalidDataException();
        }
    }

    protected void validateAllFieldNotNull(DTO dto) throws InvalidDataException {
        if (Arrays.stream(dto.getClass().getDeclaredFields()).filter(field -> {
            boolean accessible = field.isAccessible();
            try {
                field.setAccessible(true);
                return field.get(dto) == null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }finally {
                field.setAccessible(accessible);
            }
            return false;
        }).findAny().isPresent()) {
            throw new InvalidDataException();
        }

    }
}

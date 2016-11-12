package pl.labelingRooms.service.mappers;

import org.springframework.stereotype.Component;
import pl.labelingRooms.model.dbo.Greeting;

/**
 * Created by Kamil S on 2016-03-17.
 */
@Component
public class GreetingMapper extends AbstractMapper<Greeting, Greeting> {

    @Override
    public Greeting convertToDBO(Greeting greeting) {
        return greeting;
    }

    @Override
    public Greeting convertToDTO(Greeting greeting) {
        return greeting;
    }


}

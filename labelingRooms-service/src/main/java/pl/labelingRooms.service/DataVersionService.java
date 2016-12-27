package pl.labelingRooms.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Kamil on 2016-12-20.
 */
@Aspect
@Component
public class DataVersionService {

    private Long dataVersionId;
    private Random rand = new SecureRandom();

    public DataVersionService() {
        generateDataVersionId();
    }

    private void generateDataVersionId() {
        dataVersionId = rand.nextLong();
    }

    @Before("execution(* pl.labelingRooms.service.*.save (..)) || execution(* pl.labelingRooms.service.*.delete (..))" +
            "|| execution(* pl.labelingRooms.service.*.edit (..)) || execution(* pl.labelingRooms.service.RoomService.assignRoom (..))" +
            "|| execution(* pl.labelingRooms.service.RoomService.exitRoom (..))")
    public void beforeSampleCreation() {
        generateDataVersionId();
    }

    public Long getDataVersionId() {
        return dataVersionId;
    }
}

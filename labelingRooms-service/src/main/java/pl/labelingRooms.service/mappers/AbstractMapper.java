package pl.labelingRooms.service.mappers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kamil S on 2016-03-17.
 */
public abstract class AbstractMapper<DBO,DTO> {

    abstract public DBO convertToDBO(DTO dto);

    public abstract DTO convertToDTO(DBO dbo);

    public List<DBO> convertToDBO(List<DTO> dtos){
        return dtos.stream().map(this::convertToDBO).collect(Collectors.toList());
    }

    public List<DTO> convertToDTO(List<DBO> dbos){
        return dbos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }




}

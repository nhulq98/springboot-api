package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.stereotype.Component;

@Component
public class AssignmentBuildingConverter extends AbstractConverter<AssignmentBuildingDTO, AssignmentBuildingEntity> {
    /**
     * Reverts {@code destination} to an instance of type {@code S}.
     *
     * @param entity
     */
    @Override
    protected AssignmentBuildingDTO convertEntityToDTO(AssignmentBuildingEntity entity) {
        return null;
    }

    /**
     * Converts {@code source} to an instance of type {@code D}.
     *
     * @param assignmentBuildingDTO
     */
    @Override
    protected AssignmentBuildingEntity convertDTOToEntity(AssignmentBuildingDTO assignmentBuildingDTO) {
        return null;
    }
}

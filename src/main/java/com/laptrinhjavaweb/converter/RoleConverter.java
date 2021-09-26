package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("BuildingConverter") ==> the same with component("BuildingConverter")
public class RoleConverter extends AbstractConverter<RoleDTO, RoleEntity>{

    /**
     * Reverts {@code destination} to an instance of type {@code S}.
     *
     * @param roleEntity
     */
    @Override
    protected RoleDTO convertEntityToDTO(RoleEntity roleEntity) {
        return null;
    }

    /**
     * Converts {@code source} to an instance of type {@code D}.
     *
     * @param roleDTO
     */
    @Override
    protected RoleEntity convertDTOToEntity(RoleDTO roleDTO) {
        return null;
    }
}

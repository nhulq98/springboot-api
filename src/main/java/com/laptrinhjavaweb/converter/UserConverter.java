package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<UserDTO, UserEntity> {
    /**
     * Reverts {@code destination} to an instance of type {@code S}.
     *
     * @param entity
     */
    @Override
    public UserDTO convertEntityToDTO(UserEntity entity) {
        return null;
    }

    /**
     * Converts {@code source} to an instance of type {@code D}.
     *
     * @param userDTO
     */
    @Override
    public UserEntity convertDTOToEntity(UserDTO userDTO) {
        return null;
    }
}

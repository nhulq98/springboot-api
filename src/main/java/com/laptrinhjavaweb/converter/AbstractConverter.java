package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * Converter support class. Allows for simpler Converter implementations.
 *
 * @param <DTO> source type
 * @param <Entity> destination type
 *
 * @author le quang nhu
 */
@Component
public abstract class AbstractConverter<DTO, Entity>{

    @Autowired
    protected ModelMapper modelMapper;

    /**
     * Converts {@code source} to an instance of type {@code D}.
     */
    public final <D, S> D convert(S source, D dest) {
        //get Type of class
        String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1].getTypeName();
        try {
            Class<?> clazz = Class.forName(className);

            //convert
            dest = this.modelMapper.map(source, (Type) clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dest;
    }

    /**
     * Converts {@code source} to an instance of type {@code D}.
     */
//    public DTO convert(Entity source) throws ClassNotFoundException {
//        //get Type of class
//        String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
//        Class<?> clazz = Class.forName(className);
//
//        //convert
//        DTO des = modelMapper.map(source, (Type) clazz);
//        return des;
//    }

    protected abstract DTO convertEntityToDTO(Entity entity);

    protected abstract Entity convertDTOToEntity(DTO dto);


}

package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.builder.BuildingSearch;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingRequest;
import com.laptrinhjavaweb.dto.response.BuildingResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
//@Qualifier("BuildingConverter") ==> the same with component("BuildingConverter")
public class BuildingConverter extends AbstractConverter<BuildingDTO, BuildingEntity>{

	@Override
	public BuildingDTO convertEntityToDTO(BuildingEntity entity) {
		BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);

		//dto.setAddress(entity.getStreet() +", "+ entity.getWard() +", "+ entity.getDistrict().getName());

		// convert List<RentAreaEntity> to rentAreaStrs with format: 200,300,400...
		List<RentAreaEntity> rentAreas = entity.getRentAreas();
		List<String> rentAreaStrs = new ArrayList<>();
		for (RentAreaEntity item : rentAreas) {
			rentAreaStrs.add(String.valueOf(item.getValue()));
		}
		dto.setRentAreas(String.join(", ", rentAreaStrs));

		return dto;
	}

	@Override
	public BuildingEntity convertDTOToEntity(BuildingDTO buildingDTO) {
		BuildingEntity entity = modelMapper.map(buildingDTO, BuildingEntity.class);

		// convert rentAreaStrs to List<RentAreaEntity>
		String[] rentAreaStrs = buildingDTO.getRentAreas().split(",");
		List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
		for (String item : rentAreaStrs) {
			RentAreaEntity rentAreaEntity = new RentAreaEntity();
			rentAreaEntity.setValue(Integer.parseInt(item));
			rentAreaEntities.add(rentAreaEntity);
		}
		entity.setRentAreas(rentAreaEntities);

		return entity;
	}

	public BuildingSearch convertMapToBuider(Map<String, Object> map){
		BuildingSearch.Builder result = modelMapper.map(map, BuildingSearch.Builder.class);
		return new BuildingSearch(result);
	}
}

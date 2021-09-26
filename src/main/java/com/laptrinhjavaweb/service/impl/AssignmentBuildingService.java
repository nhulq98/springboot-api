package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.AbstractConverter;
import com.laptrinhjavaweb.converter.AssignmentBuildingConverter;
import com.laptrinhjavaweb.dto.AbstractDTO;
import com.laptrinhjavaweb.dto.request.StaffBuildingRequest;
import com.laptrinhjavaweb.dto.response.StaffBuildingResponse;
import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.jdbc.impl.AssignmentBuildingJDBCImpl;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentBuildingService implements IAssignmentBuildingService {

    @Autowired
    private AssignmentBuildingRepository repository;

    @Autowired
    private AssignmentBuildingConverter converter;

    @Override
    public List<StaffBuildingResponse> getAllStaffs() {
       List<StaffBuildingResponse> result = new ArrayList<>();
//        List<UserEntity> entities = assignmentBuildingJDBC.getAllStaffs();
//
//        for(UserEntity userEntity: entities){
//            //StaffBuildingResponse staffBuildingResponse = (StaffBuildingResponse) staffResponseConverter.convertEntityToCustom(userEntity);
//            //result.add(staffBuildingResponse);
//        }
        return result;
    }

    @Override
    public List<Long> getIdStaffsByBuildingId(Long buildingId) {
        List<Long> result = new LinkedList<>();
        List<AssignmentBuildingEntity> staffs = repository.findAllByBuildingId(buildingId);
        //List<StaffBuildingResponse> staffs = getStaffsOfBuildingById(buildingId);
        for (AssignmentBuildingEntity item : staffs) {
            result.add(item.getId());
        }
        return result;
    }

    @Override
    public List<StaffBuildingResponse> getStaffsOfBuildingById(Long buildingId) {
        // call db and get data
        List<StaffBuildingResponse> result = new ArrayList<>();
        //List<UserEntity> entities = assignmentBuildingJDBC.findStaffsByBuildingId(buildingId);
//        List<AssignmentBuildingEntity> entities = repository.findAll(buildingId);
//        //repository.findStaffsByBuildingId()
//        for(UserEntity userEntity: entities){
//            StaffBuildingResponse staffBuildingResponse = (StaffBuildingResponse) staffResponseConverter.convertEntityToCustom(userEntity);
////            staffBuildingResponse.setChecked("checked");
//            result.add(staffBuildingResponse);
//        }
        return result;
    }

    /**
     * Get All Staff and set status is "checked" if staff is managing building
     * @param buildingId
     * @return all staff available
     * @throws ClassNotFoundException
     */
    @Override
    public List<StaffBuildingResponse> getStaffsAssignment(Long buildingId) {
        List<AssignmentBuildingEntity> staffsAll = repository.findAll();
        List<AssignmentBuildingEntity> staffsOfBuilding = repository.findAllByBuildingId(buildingId);

        List<StaffBuildingResponse> result = new ArrayList<>();
        //for()
        //convert to staffResponse

        for(int i = 0; i < staffsAll.size(); i++){
            result.add(converter.convert(staffsAll.get(i), new StaffBuildingResponse()));
            for(AssignmentBuildingEntity staff: staffsOfBuilding){
                if(staffsAll.get(i).getId() == staff.getId()){
                   // staffsAll.get(i).setChecked("checked");
                    staffsOfBuilding.remove(staff);// to reduce loop numbers
                    break;// exit for outside loop
                }
            }
        }

        //return staffAll;
        return result;
    }

    //For change data
      /**
     * ý tưởng:
     * step1: Tìm những phần tử cùng tồn tại ở cả 2 ds thì xóa ra. Bởi vì các ptu này không thay đổi(là không bị bỏ tích ở front-end)
     * step2: Còn lại ta sẽ xóa hết all ptu của danh sách staff load từ DB. Bởi vì những ptu trong ds này không có trong ds mà front-end gửi về, có nghĩa là user đã bỏ tích những đối tượng này
     * step3: Thêm all phần tử của ds staff lấy từ request(front-end). Vì những ptu trong ds này không có trong ds load từ DB thì có nghĩa là nó mới được tích vào
     *
     * @param request
     */
    @Override
    @Transactional
    public void updateAssignment(StaffBuildingRequest request){

        //B1: get List1 staffs is managing this building from database
        List<Long> staffsOfBuildingFromDB = getIdStaffsByBuildingId(request.getBuildingId());

        //B2: get List2 staff is sent from front-end
        List<Long> staffsFromRequest = request.getStaffIds();

        // Step1: find element duplicate and remove it
        for (int i = 0; i < staffsOfBuildingFromDB.size(); i++)
        {
            for (int j = 0; j < staffsFromRequest.size(); j++)
            {
                if (staffsOfBuildingFromDB.get(i).equals(staffsFromRequest.get(j)))
                {
                    staffsOfBuildingFromDB.remove(i);
                    staffsFromRequest.remove(j);
                    i--;
                    break;
                }
            }
        }

        deleteAssignmentStaffs(request.getBuildingId(), staffsOfBuildingFromDB);

        saveAssignmentStaffs(request.getBuildingId(), staffsFromRequest);

        /* Mong muốn cải thiện: dùng 1 vòng lặp lặp qua 2 list số nguyên và tìm xóa được các tu trùng nhau
         bỏ 2 ds vào 1 mảng
         kiểm tra nếu 2ptu liên tiếp == nhau thì ta bỏ vào 1 mảng trùng.
         chạy qua mảng trùng và xóa cùng lúc các phần tử trong cả 2 danh sách*/
    }

    @Override
    @Transactional
    public void deleteAssignmentStaffs(Long buildingId, List<Long> ids) {
        for(Long id: ids){
            repository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public void saveAssignmentStaffs(Long buildingId, List<Long> ids) {
        if(ids.size() > 0){
            AssignmentBuildingEntity item = new AssignmentBuildingEntity();
            BuildingEntity building = new BuildingEntity();
            building.setId(buildingId);
            item.setBuilding(building);

            for(Long id: ids){
                UserEntity user = new UserEntity();
                user.setId(id);

                item.setUser(user);
                repository.save(item);
            }
        }

    }

}

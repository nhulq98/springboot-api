package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.repository.custom.AssignmentBuildingRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AssignmentBuildingRepositoryImpl implements AssignmentBuildingRepositoryCustom {

    @PersistenceContext// giúp khởi tạo đối tượng EntityManager
    private EntityManager entityManager;

    @Override
    public List<UserEntity> getAllStaffs() {
        StringBuilder sql = new StringBuilder("SELECT US.id, US.fullname ")
                .append(" FROM assignmentbuilding ASB ")
                .append(" JOIN user US on US.id = ASB.staffid ")
                .append(" GROUP BY US.id;");
        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.getResultList();
    }

//    @Override
//    public List<UserEntity> findStaffsByBuildingId(Long buildingId) {
//        StringBuilder sql = new StringBuilder("SELECT US.id, US.fullname ")
//                .append(" FROM assignmentbuilding ASB ")
//                .append(" JOIN user US on US.id = ASB.staffid ")
//                .append(" WHERE buildingid = ? ")
//                .append(" GROUP BY US.id;");
//        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
//        return query.getResultList();
//    }

    @Override
    @Transactional
    public int deleteStaffOfBuildingById(Long buildingId, Long staffId) {
        StringBuilder sql = new StringBuilder(" DELETE ")
                .append(" FROM assignmentbuilding ")
                .append(" WHERE buildingid=? AND staffid = ? ");
        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.executeUpdate();
    }

    @Override
    @Transactional
    public int insertStaffOfBuildingById(Long buildingId, Long staffId) {
        StringBuilder sql = new StringBuilder(" INSERT INTO ")
                .append(" assignmentbuilding(buildingid, staffid) ")
                .append(" VALUES (?, ?) ");
        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.executeUpdate();
    }
}

package com.laptrinhjavaweb.repository.jpa.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.jpa.IBuildingJPA;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class BuildingJPA implements IBuildingJPA {

    @PersistenceContext// giúp khởi tạo đối tượng EntityManager
    private EntityManager entityManager;

    public List<BuildingEntity> findAll() {
        //native SQL
        String sqlNative = "SELECT * FROM building";
        Query query = entityManager.createNativeQuery(sqlNative, BuildingEntity.class);

        //cách viết của JPQL
//        String sqlJPQL = "FROM BuildingEntity"; //FROM + Class Entity
//        Query query = entityManager.createQuery(sqlJPQL, BuildingEntity.class);

        return query.getResultList();
    }

    public BuildingEntity findOne(Long id) {
        try {
            //cách viết của JPQL: ta phải sử dụng các tên của java (tên class, tên biến)
            String sqlJPQL = " FROM BuildingEntity WHERE id = " + id; //FROM + Class Entity  WHERE variable of Class Entity
            Query query = entityManager.createQuery(sqlJPQL, BuildingEntity.class);
            return (BuildingEntity) query.getSingleResult();
        }catch (RuntimeException e){
            return new BuildingEntity();
        }
    }


    @Override
    public void saveJPA(BuildingEntity entity) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public BuildingEntity updateJPA(BuildingEntity entity) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return entityManager.merge(entity);
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        return new BuildingEntity();
    }

    @Override
    public void deleteAssignmentStaffs(BuildingEntity entity) {
        entityManager.remove(entity);
    }
}

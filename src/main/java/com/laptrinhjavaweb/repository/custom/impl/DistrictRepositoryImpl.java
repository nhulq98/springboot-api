package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.repository.custom.DistrictRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class DistrictRepositoryImpl implements DistrictRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public DistrictEntity findById(Long id) {
//        String sql = "Select * From district where id = " + id;
//        Query query = entityManager.createNativeQuery(sql, DistrictEntity.class);
//        return (DistrictEntity) query.getSingleResult();
//    }
}

package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.BuildingSearch;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class BuildingRepositoryImplOlder {
//
//    @Autowired
//    BuildingConverter buildingConverter;
//
//    @PersistenceContext// initializer for EntityManager
//    private EntityManager entityManager;
//
//    @Override
//    public List<BuildingEntity> findByCondition(Map<String, Object> requestParam) {
//        BuildingSearch searchBuilder = buildingConverter.convertMapToBuider(requestParam);
//        StringBuilder sql = this.buildQueryForBuildingSearch(searchBuilder);
//        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
//        return query.getResultList();
//    }
//
//    /**
//     * buildQueryForSearchBuilding to concat all clauses to complete sql final
//     *
//     * @param buildingSearch the building from search form
//     * @return sql String final
//     */
//    @Override
//    public StringBuilder buildQueryForBuildingSearch(BuildingSearch buildingSearch) {
//        //SELECT BD.id, BD.name, BD.street, BD.ward, DT.name, BD.managername, BD.managerphone, BD.floorarea, BD.rentprice, BD.servicefee"
//        return new StringBuilder("SELECT BD.id, BD.name, BD.street, BD.ward, BD.managername, BD.managerphone, BD.floorarea, BD.rentprice, BD.servicefee")
//                .append(" FROM building BD ")
//                .append(this.buildJoinSQLClause(buildingSearch))
//                .append(this.buildWhereSQLClause(buildingSearch))
//                .append(" GROUP BY BD.id ");
//    }
//
//    /**
//     * generic method to create condition clause with values have type is String become like this.
//     * Example: " AND name LIKE '%value%' "
//     * @param field
//     * @param value
//     * @return
//     */
//    @Override
//    public StringBuilder createConditionForStringByLike(String field, String value) {
//        if (StringUtils.isNotEmpty(value)) {
//            return new StringBuilder(" AND ")
//                    .append(field)
//                    .append(" LIKE '%")
//                    .append(value)
//                    .append("%' ");
//        }
//        return new StringBuilder("");
//    }
//
//    /**
//     * generic method to create condition with values have type is Integer become like this.
//     * Example: " AND age = 23 "
//     * @param field
//     * @param value
//     * @return
//     */
//    @Override
//    public StringBuilder createConditionForNumber(String field, Number value) {
//        if (value != null) {
//            return new StringBuilder(" AND ")
//                    .append(field)
//                    .append("=")
//                    .append(value).append(" ");
//        }
//        return new StringBuilder("");
//
//    }
//
//    /**
//     * Add condition into Where clause if value != null
//     * @param buildingSearch
//     * @return Where statement String
//     */
//    @Override
//    public StringBuilder buildWhereSQLClause(BuildingSearch buildingSearch) {
//        StringBuilder whereSQLClause = new StringBuilder(" WHERE 1=1 ");// Use StringBuilder with purpose is saved memory
//        whereSQLClause
//                .append(this.createConditionForStringByLike("BD.name", buildingSearch.getName()))
//                .append(this.createConditionForStringByLike("BD.street", buildingSearch.getStreet()))
//                .append(this.createConditionForStringByLike("BD.ward", buildingSearch.getWard()))
//                .append(this.createConditionForStringByLike("BD.direction", buildingSearch.getDirection()))
//                .append(this.createConditionForStringByLike("BD.level", buildingSearch.getLevel()))
//                .append(this.createConditionForStringByLike("BD.managername", buildingSearch.getManagerName()))
//                .append(this.createConditionForStringByLike("BD.managerphone", buildingSearch.getManagerphone()))
//                .append(this.createConditionForStringByLike("BD.district", buildingSearch.getDistrict()))
//                //.append(this.createConditionForNumber("BD.floorarea", buildingSearch.getBuildingArea()))
//                .append(this.checkExistenceOfCondition(" AND BD.floorarea = ", " ", buildingSearch.getBuildingArea()))
//                .append(this.createConditionForNumber("BD.numberofbasement", buildingSearch.getNumberOfBasement()))
//                .append(this.createConditionForNumber("ASB.staffid", buildingSearch.getStaffId()))
//                .append(this.buildBetweenStatement("BD.rentprice", buildingSearch.getCostRentFrom(), buildingSearch.getCostRentTo()))
//                .append(this.buildBetweenStatement("RE.value", buildingSearch.getAreaRentFrom(), buildingSearch.getAreaRentTo()))
//                .append(this.buildConditionForBuildingType(buildingSearch.getBuildingTypes()));
//        return whereSQLClause;
//    }
//
////    @Override
////    public StringBuilder buildWhereSQLClause(BuildingSearch buildingSearch) {
////        StringBuilder whereSQLClause = new StringBuilder(" WHERE 1=1 ");// Use StringBuilder with purpose is saved memory
////
////        whereSQLClause
////                .append(this.checkExistenceOfCondition(" AND BD.name LIKE '%", "%' ", buildingSearch.getName()))
////                .append(this.checkExistenceOfCondition(" AND BD.street LIKE '%", "%' ", buildingSearch.getStreet()))
////                .append(this.checkExistenceOfCondition(" AND BD.ward LIKE '%", "%' ", buildingSearch.getWard()))
////                .append(this.checkExistenceOfCondition(" AND BD.direction  LIKE '%", "%' ", buildingSearch.getDirection()))
////                .append(this.checkExistenceOfCondition(" AND BD.level LIKE '%", "%' ", buildingSearch.getLevel()))
////                .append(this.checkExistenceOfCondition(" AND BD.managername LIKE '%", "%' ", buildingSearch.getManagerName()))
////                .append(this.checkExistenceOfCondition(" AND BD.managerphone LIKE '%", "%' ", buildingSearch.getManagerphone()))
////                .append(this.checkExistenceOfCondition(" AND BD.district = ", " ", "\"" + buildingSearch.getDistrict() + "\""))
////                .append(this.checkExistenceOfCondition(" AND BD.floorarea = ", " ", buildingSearch.getBuildingArea()))
////                .append(this.checkExistenceOfCondition(" AND BD.numberOfBasement = ", " ", buildingSearch.getNumberOfBasement()))
////                .append(this.checkExistenceOfCondition(" AND ASB.staffid = ", " ", buildingSearch.getStaffId()))
////                .append(this.buildBetweenStatement("BD.rentprice", buildingSearch.getCostRentFrom(), buildingSearch.getCostRentTo()))
////                .append(this.buildBetweenStatement("RE.value", buildingSearch.getAreaRentFrom(), buildingSearch.getAreaRentTo())
////                        .append(this.buildConditionForBuildingType(buildingSearch.getBuildingTypes())));
////        return whereSQLClause;
////    }
//
//
//    @Override
//    public StringBuilder buildBetweenStatement(String whereSQLClause, Integer from, Integer to) {
//        StringBuilder result = new StringBuilder("");
//        if (from != null || to != null) {
//            if (from != null && to != null) {
//                return result.append(" AND " + whereSQLClause + " BETWEEN " + from + " AND " + to + " ");
//            } else if (from != null && to == null) {
//                return result.append(" AND " + whereSQLClause + " >= " + from + " ");
//            }
//            return result.append(" AND " + whereSQLClause + " <= " + to + " ");
//
//        }
//        return result;
//    }
//
//    public void appendString(StringBuilder stringResult, StringBuilder str) {
//        stringResult.append(str);
//
//    }
//
//    @Override
//    public StringBuilder buildConditionForBuildingType(List<String> buildingType) {
//        StringBuilder conditionForBuildingType = new StringBuilder("");
//        if (buildingType == null || buildingType.get(0) == null) {
//            return conditionForBuildingType;
//        }
//
//        if (buildingType != null && buildingType.size() > 0) {
//            appendString(conditionForBuildingType, checkExistenceOfCondition(" AND BD.type LIKE \"%", "%\" ", buildingType.get(0)));
//            //conditionForBuildingType.append(checkExistenceOfCondition(" AND RT.code = \"", "\" ", buildingType.get(0)));
//            if (buildingType.size() > 1) {
//                for (int i = 1; i < buildingType.size(); i++) {
//                    //conditionForBuildingType.append(checkExistenceOfCondition(" OR RT.code = \"", "\" ", buildingType.get(i)));
//                    appendString(conditionForBuildingType, checkExistenceOfCondition(" OR BD.type LIKE \"%", "%\" ", buildingType.get(i)));
//                }
//            }
//        }
//        return conditionForBuildingType;
//    }
//
//    /**
//     * Add join statment if it exists
//     * @param buildingSearch
//     * @return join statement String
//     */
//    @Override
//    public StringBuilder buildJoinSQLClause(BuildingSearch buildingSearch) {
//        StringBuilder joinClause = new StringBuilder("");
//        if (buildingSearch.getStaffId() != null) {
//            joinClause.append(" JOIN assignmentbuilding ASB on  ASB.buildingid = BD.id ");
//        }
//        if (buildingSearch.getAreaRentFrom() != null || buildingSearch.getAreaRentTo() != null) {
//            joinClause.append(" JOIN rentarea RE ON RE.buildingid = BD.id ");
//        }
//
//        return joinClause;
//    }
//
//    @Override
//    public StringBuilder checkExistenceOfCondition(String prefix, String suffix, Object parameter) {
//        StringBuilder result = new StringBuilder("");
//        if (parameter == null) {
//            return result;
//        }
//        if (StringUtils.isNotEmpty(parameter.toString()) && !parameter.equals("\"" + null + "\"")) {
//            return result.append(prefix + parameter + suffix);
//        }
//        return result;
//    }
//
//    @Override
//    public StringBuilder buildBuildingSearchPart1(BuildingSearch buildingSearch) {
//        return null;
//    }
//
//    @Override
//    public StringBuilder buildBuildingSearchPart2(BuildingSearch buildingSearch) {
//        return null;
//    }
}

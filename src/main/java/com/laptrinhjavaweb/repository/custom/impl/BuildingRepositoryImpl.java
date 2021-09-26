package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.BuildingSearch;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Repository
@Component
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @Autowired
    BuildingConverter buildingConverter;

    @PersistenceContext// initializer for EntityManager
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findByCondition(Map<String, Object> requestParam) {
        BuildingSearch searchBuilder = buildingConverter.convertMapToBuider(requestParam);
        StringBuilder sql = this.buildQueryForBuildingSearch(searchBuilder);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    /**
     * buildQueryForSearchBuilding to concat all clauses to complete sql final
     *
     * @param buildingSearch the building from search form
     * @return sql String final
     */
    @Override
    public StringBuilder buildQueryForBuildingSearch(BuildingSearch buildingSearch) {
        //SELECT BD.id, BD.name, BD.street, BD.ward, DT.name, BD.managername, BD.managerphone, BD.floorarea, BD.rentprice, BD.servicefee"
        StringBuilder sql = new StringBuilder("SELECT BD.id, BD.name, BD.street, BD.ward, BD.managername, BD.managerphone, BD.floorarea, BD.rentprice, BD.servicefee")
                .append(" FROM building BD ");
        this.buildJoinSQLClause(buildingSearch, sql);
        this.buildWhereSQLClause(buildingSearch, sql);
//        this.build
//
//        return new StringBuilder("SELECT BD.id, BD.name, BD.street, BD.ward, BD.managername, BD.managerphone, BD.floorarea, BD.rentprice, BD.servicefee")
//                .append(" FROM building BD ")
//                .append(this.buildJoinSQLClause(buildingSearch))
//                .append(this.buildWhereSQLClause(buildingSearch))
//                .append(" GROUP BY BD.id ");
        return sql;
    }

    @Override
    public StringBuilder buildBuildingSearchPart1(BuildingSearch buildingSearch) {
        Field[] fields = BuildingSearch.class.getDeclaredFields();

//        for(Field item: fields){
//            //if(item.get())
//            item.getModifiers()
//        }

        return null;
    }

    @Override
    public StringBuilder buildBuildingSearchPart2(BuildingSearch buildingSearch) {
        return null;
    }

    /**
     * Add join statment if it exists
     *
     * @param buildingSearch
     * @return join statement String
     */
    @Override
    public void buildJoinSQLClause(BuildingSearch buildingSearch, StringBuilder sql) {
        if (buildingSearch.getStaffId() != null) {
            sql.append(" JOIN assignmentbuilding ASB on  ASB.buildingid = BD.id ");
        }
        if (buildingSearch.getAreaRentFrom() != null || buildingSearch.getAreaRentTo() != null) {
            sql.append(" JOIN rentarea RE ON RE.buildingid = BD.id ");
        }
    }

    /**
     * Add condition into Where clause if value != null
     *
     * @param buildingSearch
     * @return Where statement String
     */
    @Override
    public void buildWhereSQLClause(BuildingSearch buildingSearch, StringBuilder sql)  {
        sql.append(" WHERE 1=1 ")
                .append(this.createConditionForStringByLike("BD.name", buildingSearch.getName()))
                .append("23");
        Field[] fields = BuildingSearch.class.getDeclaredFields();
        for (Field item : fields) {
            item.setAccessible(true);
            String name = item.getName();
            if (!name.equals("district") && !name.equals("buildingTypes")
                    && !name.startsWith("area") && !name.startsWith("cost")) {
                try{
                    Object objectValue = item.get(buildingSearch); // reflect chay vo then building va scan cai field do xong no boc tach du lieu ra
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }

            }
        }
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
//                .append(this.creatleConditionForNumber("ASB.staffid", buildingSearch.getStaffId()))
//                .append(this.buildBetweenStatement("BD.rentprice", buildingSearch.getCostRentFrom(), buildingSearch.getCostRentTo()))
//                .append(this.buildBetweenStatement("RE.value", buildingSearch.getAreaRentFrom(), buildingSearch.getAreaRentTo()))
//                .append(this.buildConditionForBuildingType(buildingSearch.getBuildingTypes()));
//        return whereSQLClause;
    }

    /**
     * generic method to create condition clause with values have type is String become like this.
     * Example: " AND name LIKE '%value%' "
     *
     * @param fieldName
     * @param value
     * @return
     */
    @Override
    public StringBuilder createConditionForStringByLike(String fieldName, String value) {
        if (StringUtils.isNotEmpty(value)) {
            return new StringBuilder(" AND ")
                    .append(fieldName)
                    .append(" LIKE '%")
                    .append(value)
                    .append("%' ");
        }
        return new StringBuilder("");
    }

    /**
     * generic method to create condition with values have type is Integer become like this.
     * Example: " AND age = 23 "
     *
     * @param fieldName
     * @param value
     * @return
     */
    @Override
    public StringBuilder createConditionForNumber(String fieldName, Number value) {
        if (value != null) {
            return new StringBuilder(" AND ")
                    .append(fieldName)
                    .append("=")
                    .append(value).append(" ");
        }
        return new StringBuilder("");

    }

    @Override
    public void buildBetweenStatement(String fieldName, Integer from, Integer to, StringBuilder sql) {
        if (from != null || to != null) {
            if (from != null && to != null) {
                sql.append(" AND " + fieldName + " BETWEEN " + from + " AND " + to + " ");
            } else if (from != null && to == null) {
                sql.append(" AND " + fieldName + " >= " + from + " ");
            }
            sql.append(" AND " + fieldName + " <= " + to + " ");
        }
    }

    public void appendString(StringBuilder stringResult, StringBuilder str) {
        stringResult.append(str);

    }

    /**
     * solution 1: AND RT.code = 'tang-tret' OR RT.code = 'nguyen-can'
     * solution 2: AND (RT)
     *
     * @param buildingSearch
     * @param sql
     */
    @Override
    public void buildConditionForBuildingType(BuildingSearch buildingSearch, StringBuilder sql) {
        sql.append(" AND (");
        // java 7
        /*
        List<String> buildingTypes = buildingSearch.getBuildingTypes();
        for(int i = 0; i < buildingTypes.size(); i++){
            buildingTypes.set(i, " BD.code LIKE '%" +buildingTypes.get(i)+"%'");
        }
        String typesSQL = String.join(" or ", buildingTypes);
        sql.append(typesSQL);
*/
        // java 8
        String types = Arrays.stream(buildingSearch.getBuildingTypes().toArray())
                .map((item) -> "BD.type LIKE '%" + item + "%'") // dùng lambda để thực hiện hành động cộng chuỗi và trả về giá trị
                .collect(Collectors.joining(" or "));
        sql.append(types);

        sql.append(")");
    }

    @Override
    public StringBuilder checkExistenceOfCondition(String prefix, String suffix, Object parameter) {
        StringBuilder result = new StringBuilder("");
        if (parameter == null) {
            return result;
        }
        if (StringUtils.isNotEmpty(parameter.toString()) && !parameter.equals("\"" + null + "\"")) {
            return result.append(prefix + parameter + suffix);
        }
        return result;
    }

}
package com.laptrinhjavaweb.repository.jdbc.impl;

import com.laptrinhjavaweb.repository.jdbc.IGeneric;
import com.laptrinhjavaweb.repository.jdbc.annotation.ColumnJDBC;
import com.laptrinhjavaweb.repository.jdbc.annotation.EntityJDBC;
import com.laptrinhjavaweb.repository.jdbc.annotation.TableJDBC;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SimpleRepository<T> implements IGeneric<T> {

    /**
     * build generic function to get data from resultset
     *
     * @param rs
     * @param tClass
     * @return
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<T> mapRow(ResultSet rs, Class<T> tClass) throws IllegalAccessException, InstantiationException {
        List<T> result = new ArrayList<>();
        T object = tClass.newInstance();
        if (tClass.isAnnotationPresent(TableJDBC.class)) {// check IF it is table ==> go into to process
            Field[] fields = tClass.getDeclaredFields(); // all fields of class
            try {
                ResultSetMetaData resultSetMetaData = rs.getMetaData();
                while (rs.next()) {// go into row each

                    // go into column each
                    for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                        String columnName = resultSetMetaData.getColumnName(i);
                        Object columnValue = rs.getObject(i);

                        //set value into field of Entity Object Class
                        for (Field item : fields) {
                            if (item.isAnnotationPresent(ColumnJDBC.class)) {
                                //B1: xác định column name
                                //the first, I have to get annotation object
                                ColumnJDBC columnJDBC = item.getAnnotation(ColumnJDBC.class);
                                if (columnName.equals(columnJDBC.name())) {
                                    //item.set(object, columnValue); // way 1
                                    try {
                                        BeanUtils.setProperty(object, item.getName(), columnValue); // way 2
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }

                            }
                        }

                        //set Field from super class
                        Class<?> parentClass = tClass.getSuperclass();
                        while (parentClass != null) {
                            //set value into field of Entity Object Class
                            for (Field item : parentClass.getDeclaredFields()) {
                                if (item.isAnnotationPresent(ColumnJDBC.class)) {
                                    //B1: define column name
                                    //the first, I have to get annotation object
                                    ColumnJDBC columnJDBC = item.getAnnotation(ColumnJDBC.class);
                                    if (columnName.equals(columnJDBC.name())) {
                                        //item.set(object, columnValue); // way 1
                                        try {
                                            BeanUtils.setProperty(object, item.getName(), columnValue); // way 2
                                        } catch (InvocationTargetException e) {
                                            e.printStackTrace();
                                        }
                                        break;
                                    }

                                }
                            }

                            parentClass = parentClass.getSuperclass();
                        }
                    }
                    result.add(object);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<T> findAll() {
        List<T> result = new ArrayList<>();
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (tClass.isAnnotationPresent(EntityJDBC.class)) {
            // process get table name
            String tableName = "";
            if (tClass.isAnnotationPresent(TableJDBC.class)) {
                TableJDBC table = tClass.getAnnotation(TableJDBC.class);
                tableName = table.name();
            }

            String sql = "SELECT * From " + tableName;

            //==========execute query======
            try {
                Statement statement = BaseJDBCImpl.getConnection().createStatement();
                ResultSet rs = statement.executeQuery(sql);
                result = mapRow(rs, tClass);
                return result;

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //BaseJDBCImpl.closeAll();
                return result;
            }
        }
        return result;
    }

    @Override
    public List<T> findByCondition(String sql, Class<T> tClass) {
        List<T> result = new ArrayList<>();
        Class<T> zClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (zClass.isAnnotationPresent(EntityJDBC.class)) {
            // process get table name
            String tableName = "";
            if (zClass.isAnnotationPresent(TableJDBC.class)) {
                TableJDBC table = zClass.getAnnotation(TableJDBC.class);
                tableName = table.name();
            }

            //==========execute query======
            try {
                Statement statement = BaseJDBCImpl.getConnection().createStatement();
                ResultSet rs = statement.executeQuery(sql);
                result = mapRow(rs, zClass);
                return result;

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //BaseJDBCImpl.closeAll();
                return result;
            }
        }
        return result;
    }

    @Override
    public T findById(Integer id) throws IllegalAccessException, InstantiationException {// catch may occur at tClass.newInstance()
        List<T> result = new ArrayList<>();
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T object = tClass.newInstance();

        if (tClass.isAnnotationPresent(EntityJDBC.class)) {
            // process get table name
            String tableName = "";
            if (tClass.isAnnotationPresent(TableJDBC.class)) {
                TableJDBC table = tClass.getAnnotation(TableJDBC.class);
                tableName = table.name();
            }
            String sql = "SELECT * From " + tableName + " WHERE id = " + id;

            //==========execute query======
            try {
                Statement statement = BaseJDBCImpl.getConnection().createStatement();
                ResultSet rs = statement.executeQuery(sql);
                result = mapRow(rs, tClass);
                return result.size() != 0 ? result.get(0) : object;

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                return object;
            }
        }
        return tClass.newInstance();
    }
}

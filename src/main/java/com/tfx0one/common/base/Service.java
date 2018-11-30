package com.tfx0one.common.base;

import java.util.List;

public interface Service<T> {

    /**
     * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
     */
    public List<T> list(T record);

    /**
     * 根据实体类不为null的字段查询总数,条件全部使用=号and条件
     */
    public int count(T record);

    T getByPrimaryKey(Object key);

    T get(T entity);

    int save(T entity);

//    int saveWithoutNull(T entity);

    int delete(T entity);

    //说明：根据主键字段进行删除，方法参数必须包含完整的主键属性
    int deleteByPrimaryKey(Object key);

    //根据主键更新属性不为null的值
//    int updateByPrimaryKeyWithoutNull(T entity);

    //说明：根据主键更新实体全部字段，null值会被更新
//    int updateByPrimaryKeyWithNull(T entity);

//    List<T> selectByExample(Example example);

    //TODO 其他...
}


package com.tfx0one.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 2fx0one on 24/5/2018.
 */
public abstract class BaseService<T extends BaseEntity> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    //    public Mapper<T> getMapper() {
//        return mapper;
//    }
    @Override
    public List<T> select(T entity) {
        //说明：根据实体类不为null的字段进行查询,条件全部使用=号and条件
        return mapper.select(entity);

    }

    @Override
    public int selectCount(T entity) {
        //说明：根据实体类不为null的字段查询总数,条件全部使用=号and条件
        return mapper.selectCount(entity);

    }

    @Override
    public T selectOne(T entity) {
        //说明：根据实体类不为null的字段查询，查询条件使用等号和and调校
        return mapper.selectOne(entity);
//        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        //说明：根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int insertWithNull(T entity) {
        //说明：保存一个实体，null的属性也会保存，不会使用数据库默认值
        return mapper.insert(entity);
    }

    @Override
    public int insertWithoutNull(T entity) {
        //说明：保存一个实体，null的属性不会保存，会使用数据库默认值
        return mapper.insertSelective(entity);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        //说明：根据主键字段进行删除，方法参数必须包含完整的主键属性
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryWithoutNull(T entity) {
        //根据主键更新属性不为null的值
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int updateByPrimaryKeyWithNull(T entity) {
        //说明：根据主键更新实体全部字段，null值会被更新
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public List<T> selectByExample(Object example) {
        //说明：根据Example条件进行查询
        //重点：这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列
        return mapper.selectByExample(example);
    }


}

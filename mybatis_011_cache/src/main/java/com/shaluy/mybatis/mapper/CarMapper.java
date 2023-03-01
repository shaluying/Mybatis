package com.shaluy.mybatis.mapper;

import com.shaluy.mybatis.pojo.Car;

public interface CarMapper {

    /**
     * 根据id获取Car信息。
     * @param id
     * @return
     */
    Car selectById(Long id);

    /**
     * 测试二级缓存
     * @param id
     * @return
     */
    Car selectById2(Long id);
}

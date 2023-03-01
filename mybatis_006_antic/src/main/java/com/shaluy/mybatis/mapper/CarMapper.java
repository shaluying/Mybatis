package com.shaluy.mybatis.mapper;

import com.shaluy.mybatis.pojo.Car;

import java.util.List;

public interface CarMapper {
    /**
     * 根据汽车类型获取汽车信息。
     * @param carType
     * @return
     */
    List<Car> selectByCarType(String carType);

    /**
     * 查询所有的汽车信息。然后通过asc升序，desc降序。
     * @param ascOrDesc
     * @return
     */
    List<Car> selectAllByAscOrDesc(String ascOrDesc);

    /**
     * 批量删除，根据id
     * @param ids
     * @return
     */
    int deleteBatch(String ids);

    /**
     * 根据汽车品牌进行模糊查询
     * @param brand
     * @return
     */
    List<Car> selectByBrandLike(String brand);

    /**
     * 增加汽车同时获取生成的主键
     * @param car
     * @return
     */
    int insertCarUsrGeneratedKeys(Car car);


}

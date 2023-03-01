package com.shaluy.mybatis.mapper;

import com.shaluy.mybatis.pojo.Clazz;

public interface ClazzMapper {

    /**
     * 分步查询第二步：根据cid获取班级信息。
     * @param cid
     * @return
     */
    Clazz selectByIdWithStep2(Integer cid);

    /**
     * 根据班级编号查询班级信息。
     * @param cid
     * @return
     */
    Clazz selectByIdWithCollection(Integer cid);

    /**
     * 分步查询。第一步：根据班级编号获取班级信息。
     * @param cid 班级编号
     * @return
     */
    Clazz selectByIdWithStep1(Integer cid);
}

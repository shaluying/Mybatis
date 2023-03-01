package com.shaluy.mybatis.mapper;

import com.shaluy.mybatis.pojo.Student;

public interface StudentMapper {

    /**
     * 根据id获取学生信息。同时获取学生关联的班级信息。
     * @param sid 学生的id
     * @return 学生对象，但是学生对象当中含有班级对象。
     */
    Student selectById(Integer sid);

    /**
     * 一条SQL语句，association
     * @param sid
     * @return
     */
    Student selectByIdWithAssociation(Integer sid);

    /**
     * 分部查询第一步：先根据学生的sid查询学生的信息。
     * @param sid
     * @return
     */
    Student selectByIdWithStep1(Integer sid);

    /**
     * 分部查询第二步；根据班级编号查询学生信息。
     * @param cid
     * @return
     */
    Student selectByIdWithStep2(Integer cid);
}

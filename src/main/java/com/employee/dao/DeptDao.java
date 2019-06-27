package com.employee.dao;

import com.employee.pojo.DeptPOJO;

import java.util.List;

public interface DeptDao {

    /**
     * 向职位表插入数据
     * @param deptPOJO
     */
    int insertDept(DeptPOJO deptPOJO);

    /**
     * 更新职位表
     * @param deptPOJO
     */
    int updateDept(DeptPOJO deptPOJO);

    /**
     * 删除某条职位信息
     * @param deptNo
     */
    int deleteDept(Integer deptNo);

    /**
     * 根据 职位 NO 查询该条职位信息
     * @param deptNo
     * @return
     */
    DeptPOJO queryDeptByDeptNo(Integer deptNo);

    /**
     * 获取职位列表
     * @return
     */
    List<DeptPOJO> queryAllDepts();


    /**
     * 根据页码来获取列表
     * @param start
     * @param size
     * @return
     */
    List<DeptPOJO> queryDeptByPage(Integer start, Integer size);

}

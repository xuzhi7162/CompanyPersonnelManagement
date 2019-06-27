package com.employee.service;

import com.employee.pojo.DeptPOJO;

import java.util.List;

public interface DeptService {
    /**
     * 添加职位信息
     * @param deptPOJO
     */
    boolean addDept(DeptPOJO deptPOJO);

    /**
     * 修改职位信息
     * @param deptPOJO
     */
    boolean updateDept(DeptPOJO deptPOJO);

    /**
     * 修改职位信息
     * @param deptNo
     */
    boolean deleteDept(Integer deptNo);

    /**
     * 获取职位列表
     * @return
     */
    List<DeptPOJO> getAllDepts();

    /**
     * 根据职位 NO 查询该职位的相关信息
     * @param deptNo
     * @return
     */
    DeptPOJO getDeptsByDeptNo(Integer deptNo);
}

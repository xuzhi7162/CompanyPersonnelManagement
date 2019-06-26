package com.employee.service;

import com.employee.pojo.DeptPOJO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface DeptService {
    /**
     * 添加职位信息
     * @param req
     * @param resp
     */
    void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    /**
     * 修改职位信息
     * @param deptPOJO
     */
    void updateDept(DeptPOJO deptPOJO);

    /**
     * 修改职位信息
     * @param deptNo
     */
    void deleteDept(Integer deptNo);

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

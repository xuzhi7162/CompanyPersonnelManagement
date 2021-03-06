package com.employee.service;

import com.employee.pojo.EmpPOJO;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface EmpService {
    /**
     * 添加员工信息
     * @param empPOJO
     */
    boolean addEmp(EmpPOJO empPOJO);

    /**
     * 修改员工信息
     * @param empPOJO
     */
    boolean updateEmp(EmpPOJO empPOJO);

    /**
     * 员工减员，删除该员工的所有记录
     * @param empNo
     */
    boolean deleteEmp(String empNo);

    /**
     * 员工离职操作，修改状态为离职，但是不删除数据库中的信息
     * @param empPOJO
     */
    boolean leaveEmp(EmpPOJO empPOJO);

    /**
     * 获取员工列表
     * @return
     */
    List<EmpPOJO> getAllEmps();

    List<EmpPOJO> getEmpByPage(Integer start, Integer pageSize);

    /**
     * 根据员工 No 获取该员工的所有信息
     * @param empNo
     * @return
     */
    EmpPOJO getEmpByEmpNO(String empNo);

}

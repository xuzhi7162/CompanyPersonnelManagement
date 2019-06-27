package com.employee.dao;

import com.employee.pojo.EmpPOJO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmpDao {

    /**
     * 插入员工记录
     * @param empPOJO
     */
    int insertEmp(Connection conn, EmpPOJO empPOJO) throws SQLException;

    /**
     * 修改职位记录
     * @param empPOJO
     */
    int updateEmp(Connection conn, EmpPOJO empPOJO) throws SQLException;

    /**
     * 修改员工状态为离职
     * @param empPOJO
     */
    int levelEmp(Connection conn, EmpPOJO empPOJO) throws SQLException;

    /**
     * 删除该员工的所有信息
     * @param empNo
     */
    int deleteEmp(Connection conn, String empNo) throws SQLException;

    /**
     * 根据员工 NO 查询该员工的所有信息
     * @param empNo
     * @return
     */
    EmpPOJO queryEmpByEmpNo(String empNo);

    /**
     * 查询员工列表
     * @return
     */
    List<EmpPOJO> queryAllEmps();


}

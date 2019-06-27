package com.employee.service;

import com.employee.pojo.EmpPOJO;
import com.employee.pojo.HistoryPOJO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface HistoryService {
    /**
     * 添加员工修改个人信息变更记录
     * @param empPOJO
     */
    Integer addHistory(Connection conn, EmpPOJO empPOJO) throws SQLException;

    /**
     * 添加员工离职变更记录
     * @param empPOJO
     */
    Integer addLeave(Connection conn, EmpPOJO empPOJO) throws SQLException;

    /**
     * 员工减员操作，删除该员工的变更记录
     * @param empNo
     */
    Integer deleteHis(Connection conn, String empNo) throws SQLException;

    /**
     * 获取变更记录列表
     * @return
     */
    List<HistoryPOJO> getAllHis();

    /**
     * 模糊查询获得变更记录
     * @param empName
     * @return
     */
    List<HistoryPOJO> getHisByEmpName(String empName);
}

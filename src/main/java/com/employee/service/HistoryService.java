package com.employee.service;

import com.employee.pojo.EmpPOJO;
import com.employee.pojo.HistoryPOJO;

import java.util.List;

public interface HistoryService {
    /**
     * 添加员工修改个人信息变更记录
     * @param empPOJO
     */
    void addHistory(EmpPOJO empPOJO);

    /**
     * 添加员工离职变更记录
     * @param empPOJO
     */
    void addLeave(EmpPOJO empPOJO);

    /**
     * 员工减员操作，删除该员工的变更记录
     * @param empNo
     */
    void deleteHis(String empNo);

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

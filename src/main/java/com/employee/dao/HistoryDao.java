package com.employee.dao;

import com.employee.pojo.HistoryPOJO;

import java.util.List;

public interface HistoryDao {
    /**
     * 插入普通变更记录
     * @param historyPOJO
     */
    int insertHis(HistoryPOJO historyPOJO);

    /**
     * 插入员工离职记录
     * @param historyPOJO
     */
    int insertLeave(HistoryPOJO historyPOJO);

    /**
     * 减员删除该员工的所有变更记录
     * @param empNo
     */
    int deleteHis(String empNo);

    /**
     * 模糊查询员工变更记录
     * @param empName
     * @return
     */
    List<HistoryPOJO> queryHisByHisNo(String empName);

    /**
     * 获取变更表
     * @return
     */
    List<HistoryPOJO> queryAllHis();



}

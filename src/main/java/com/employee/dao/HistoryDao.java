package com.employee.dao;

import com.employee.pojo.HistoryPOJO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface HistoryDao {
    /**
     * 插入普通变更记录
     * @param historyPOJO
     */
    int insertHis(Connection conn, HistoryPOJO historyPOJO) throws SQLException;

    /**
     * 插入员工离职记录
     * @param historyPOJO
     */
    int insertLeave(Connection conn, HistoryPOJO historyPOJO) throws SQLException;

    /**
     * 减员删除该员工的所有变更记录
     * @param empNo
     */
    int deleteHis(Connection conn, String empNo) throws SQLException;

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

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<HistoryPOJO> queryHisByPage(Integer pageNum, Integer pageSize);



}

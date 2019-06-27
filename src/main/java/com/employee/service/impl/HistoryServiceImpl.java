package com.employee.service.impl;

import com.employee.dao.HistoryDao;
import com.employee.dao.impl.HistoryDaoImpl;
import com.employee.pojo.EmpPOJO;
import com.employee.pojo.HistoryPOJO;
import com.employee.service.HistoryService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    private HistoryDao historyDao = new HistoryDaoImpl();


    @Override
    public Integer addHistory(Connection conn, EmpPOJO empPOJO) throws SQLException {

        HistoryPOJO historyPOJO = new HistoryPOJO();
        historyPOJO.setEmpNo(empPOJO.getEmpNo());
        historyPOJO.setDeptNo(empPOJO.getDeptNo());
        historyPOJO.setSalary(empPOJO.getSalary());
        Date date = new Date(new java.util.Date().getTime());
        historyPOJO.setChangeDate(date);
        historyPOJO.setChangeReason(empPOJO.getChangeReason());

        return historyDao.insertHis(conn, historyPOJO);
    }

    @Override
    public Integer addLeave(Connection conn, EmpPOJO empPOJO) throws SQLException {

        HistoryPOJO historyPOJO = new HistoryPOJO();
        historyPOJO.setEmpNo(empPOJO.getEmpNo());
        historyPOJO.setDeptNo(empPOJO.getDeptNo());
        historyPOJO.setSalary(empPOJO.getSalary());
        Date date = new Date(new java.util.Date().getTime());
        historyPOJO.setChangeDate(date);
        historyPOJO.setChangeReason("离职");
        historyPOJO.setDimissionDate(date);
        historyPOJO.setDimissionReason(empPOJO.getChangeReason());

        return historyDao.insertLeave(conn, historyPOJO);
    }

    @Override
    public Integer deleteHis(Connection conn, String empNo) throws SQLException {
        return historyDao.deleteHis(conn, empNo);
    }

    @Override
    public List<HistoryPOJO> getAllHis() {
        return historyDao.queryAllHis();
    }

    @Override
    public List<HistoryPOJO> getHisByEmpName(String empName) {
        return historyDao.queryHisByHisNo(empName);
    }
}

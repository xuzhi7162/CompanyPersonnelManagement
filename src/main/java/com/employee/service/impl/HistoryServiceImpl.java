package com.employee.service.impl;

import com.employee.dao.HistoryDao;
import com.employee.dao.impl.HistoryDaoImpl;
import com.employee.pojo.EmpPOJO;
import com.employee.pojo.HistoryPOJO;
import com.employee.service.HistoryService;

import java.sql.Date;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    private HistoryDao historyDao = new HistoryDaoImpl();


    @Override
    public void addHistory(EmpPOJO empPOJO) {

        HistoryPOJO historyPOJO = new HistoryPOJO();
        historyPOJO.setEmpNo(empPOJO.getEmpNo());
        historyPOJO.setDeptNo(empPOJO.getDeptNo());
        historyPOJO.setSalary(empPOJO.getSalary());
        Date date = new Date(new java.util.Date().getTime());
        historyPOJO.setChangeDate(date);
        historyPOJO.setChangeReason(empPOJO.getChangeReason());

        historyDao.insertHis(historyPOJO);
    }

    @Override
    public void addLeave(EmpPOJO empPOJO) {

        HistoryPOJO historyPOJO = new HistoryPOJO();
        historyPOJO.setEmpNo(empPOJO.getEmpNo());
        historyPOJO.setDeptNo(empPOJO.getDeptNo());
        historyPOJO.setSalary(empPOJO.getSalary());
        Date date = new Date(new java.util.Date().getTime());
        historyPOJO.setChangeDate(date);
        historyPOJO.setChangeReason("离职");
        historyPOJO.setDimissionDate(date);
        historyPOJO.setDimissionReason(empPOJO.getChangeReason());

        historyDao.insertLeave(historyPOJO);
    }

    @Override
    public void deleteHis(String empNo) {
        historyDao.deleteHis(empNo);
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

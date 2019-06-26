package com.employee.service.impl;

import com.employee.dao.EmpDao;
import com.employee.dao.impl.EmpDaoImpl;
import com.employee.pojo.EmpPOJO;
import com.employee.service.EmpService;
import com.employee.service.HistoryService;

import java.sql.Date;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();
    private HistoryService historyService = new HistoryServiceImpl();

    @Override
    public void addEmp(EmpPOJO empPOJO) {
        String empNo = empPOJO.getEmpNo();
        int no = Integer.parseInt(empNo);
        if(no < 10){
            empPOJO.setEmpNo("00000" + empNo);
        }else if(no >9 && no < 100 ) {
            empPOJO.setEmpNo("0000" + empNo);
        }else if(no > 99 && no < 1000){
            empPOJO.setEmpNo("000" + empNo);
        }else if(no > 999 && no < 10000) {
            empPOJO.setEmpNo("00" + empNo);
        }else if(no > 9999 && no < 100000) {
            empPOJO.setEmpNo("0" + empNo);
        }else {
            empPOJO.setEmpNo(empNo);
        }
        empDao.insertEmp(empPOJO);
        empPOJO.setChangeReason("入职");
        historyService.addHistory(empPOJO);
    }

    @Override
    public void updateEmp(EmpPOJO empPOJO) {
        empDao.updateEmp(empPOJO);
        historyService.addHistory(empPOJO);
    }

    @Override
    public void deleteEmp(String empNo) {
        empDao.deleteEmp(empNo);
        historyService.deleteHis(empNo);

    }

    @Override
    public void leaveEmp(EmpPOJO empPOJO) {
        empPOJO.setLeaveDate(new Date(new java.util.Date().getTime()));
        empPOJO.setState(0);
        empDao.levelEmp(empPOJO);
        historyService.addLeave(empPOJO);
    }

    @Override
    public List<EmpPOJO> getAllEmps() {
        return empDao.queryAllEmps();
    }

    @Override
    public EmpPOJO getEmpByEmpNO(String empNo) {
        return empDao.queryEmpByEmpNo(empNo);
    }

}

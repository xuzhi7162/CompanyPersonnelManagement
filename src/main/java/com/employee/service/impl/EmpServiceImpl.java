package com.employee.service.impl;

import com.employee.dao.EmpDao;
import com.employee.dao.HistoryDao;
import com.employee.dao.impl.EmpDaoImpl;
import com.employee.dao.impl.HistoryDaoImpl;
import com.employee.pojo.EmpPOJO;
import com.employee.service.EmpService;
import com.employee.service.HistoryService;
import com.employee.util.DBHelper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();
    private HistoryDao historyDao = new HistoryDaoImpl();
    private HistoryService historyService = new HistoryServiceImpl();


    @Override
    public boolean addEmp(EmpPOJO empPOJO) {
        Connection conn = DBHelper.getConnection();

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
        empPOJO.setChangeReason("入职");

        try {
            conn.setAutoCommit(false);
            int i = empDao.insertEmp(conn, empPOJO);
            Integer integer = historyService.addHistory(conn, empPOJO);
            conn.commit();
            return (i > 0 && integer > 0 ) ? true:false;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateEmp(EmpPOJO empPOJO) {
        Connection conn = DBHelper.getConnection();
        try {
            conn.setAutoCommit(false);
            int i = empDao.updateEmp(conn, empPOJO);
            Integer integer = historyService.addHistory(conn, empPOJO);
            conn.commit();
            return (i > 0 && integer > 0 ) ? true:false;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public boolean deleteEmp(String empNo) {
        Connection conn = DBHelper.getConnection();

        try {
            conn.setAutoCommit(false);
            int i = empDao.deleteEmp(conn, empNo);
            Integer integer = historyService.deleteHis(conn, empNo);
            conn.commit();
            return (i > 0 && integer > 0 ) ? true:false;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public boolean leaveEmp(EmpPOJO empPOJO) {
        Connection conn = DBHelper.getConnection();

        empPOJO.setLeaveDate(new Date(new java.util.Date().getTime()));
        empPOJO.setState(0);

        try {
            conn.setAutoCommit(false);
            int i = empDao.levelEmp(conn, empPOJO);
            Integer integer = historyService.addLeave(conn, empPOJO);
            conn.commit();
            return (i > 0 && integer > 0 ) ? true:false;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

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

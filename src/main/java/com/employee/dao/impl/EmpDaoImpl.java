package com.employee.dao.impl;

import com.employee.dao.EmpDao;
import com.employee.pojo.EmpPOJO;
import com.employee.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {

    @Override
    public int insertEmp(EmpPOJO empPOJO) {
        String sql = "insert into employee(EMPNO,DEPTNO,EMPNAME,EMPSEX,ENTRYDATE,EMPPHONE,EMPADDR,SALARY) values(?,?,?,?,?,?,?,?)";


        return DBHelper.executeUpdate(sql,new Object[]{
                empPOJO.getEmpNo()
                ,empPOJO.getDeptNo()
                ,empPOJO.getEmpName()
                ,empPOJO.getEmpSex()
                ,empPOJO.getEntryDate()
                ,empPOJO.getEmpPhone()
                ,empPOJO.getEmpAddr()
                ,empPOJO.getSalary()});

    }

    @Override
    public int updateEmp(EmpPOJO empPOJO) {
        String sql = "update employee set DEPTNO=?,EMPNAME=?,EMPSEX=?,ENTRYDATE=?,EMPPHONE=?,EMPADDR=?,SALARY=? where EMPNO=?";

        return DBHelper.executeUpdate(sql,new Object[]{
                empPOJO.getDeptNo()
                ,empPOJO.getEmpName()
                ,empPOJO.getEmpSex()
                ,empPOJO.getEntryDate()
                ,empPOJO.getEmpPhone()
                ,empPOJO.getEmpAddr()
                ,empPOJO.getSalary()
                ,empPOJO.getEmpNo()
        });

    }

    @Override
    public int levelEmp(EmpPOJO empPOJO) {
        String sql = "update employee set LEAVEDATE=?,STATE=0 where EMPNO=?";

       return DBHelper.executeUpdate(sql,empPOJO.getLeaveDate(),empPOJO.getEmpNo());

    }

    @Override
    public int deleteEmp(String empNo) {
        String sql = "delete from employee where EMPNO=?";

        return DBHelper.executeUpdate(sql,empNo);

    }

    @Override
    public EmpPOJO queryEmpByEmpNo(String empNo) {
        String sql = "select * from employee,dept where employee.DEPTNO=dept.DEPTNO and EMPNO=?;";

        List<EmpPOJO> list = DBHelper.executeQuery(sql, EmpPOJO.class, empNo);
        return list.get(0);

    }

    @Override
    public List<EmpPOJO> queryAllEmps() {
        String sql = "select * from employee,dept where employee.DEPTNO=dept.DEPTNO";

        List<EmpPOJO> list = DBHelper.executeQuery(sql, EmpPOJO.class);
        return list;

    }


    public static void main(String[] args) {
        EmpDaoImpl empDao = new EmpDaoImpl();
    }
}
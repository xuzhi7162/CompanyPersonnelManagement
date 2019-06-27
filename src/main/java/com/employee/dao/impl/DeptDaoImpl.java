package com.employee.dao.impl;

import com.employee.dao.DeptDao;
import com.employee.pojo.DeptPOJO;
import com.employee.util.DBHelper;

import java.util.List;

public class DeptDaoImpl implements DeptDao {


    @Override
    public int insertDept(DeptPOJO deptPOJO) {
        String sql = "insert into dept(DEPTNAME) values(?)";

        return DBHelper.executeUpdate(sql,deptPOJO.getDeptName());


    }

    @Override
    public int updateDept(DeptPOJO deptPOJO) {
        String sql = "update dept set DEPTNAME=? where DEPTNO=?";

        return DBHelper.executeUpdate(sql,deptPOJO.getDeptName(),deptPOJO.getDeptNo());

    }

    @Override
    public int deleteDept(Integer deptNo) {
        String sql = "delete from dept where DEPTNO=?";

        return DBHelper.executeUpdate(sql,deptNo);

    }

    @Override
    public DeptPOJO queryDeptByDeptNo(Integer deptNo) {
        String sql = "select * from dept where DEPTNO=?";

        List list = DBHelper.executeQuery(sql, DeptPOJO.class, deptNo);
        return (DeptPOJO) list.get(0);

    }

    @Override
    public List<DeptPOJO> queryAllDepts() {
        String sql = "select * from dept";

        List<DeptPOJO> list = DBHelper.executeQuery(sql, DeptPOJO.class);
        return list;

    }

    @Override
    public List<DeptPOJO> queryDeptByPage(Integer start, Integer size) {
        String sql = "select * from dept limit ?,?";
        List<DeptPOJO> list = DBHelper.executeQuery(sql, DeptPOJO.class, start, size);
        return list;
    }


    public static void main(String[] args) {
        DeptDaoImpl deptDao = new DeptDaoImpl();
        DeptPOJO deptPOJO = deptDao.queryDeptByDeptNo(6);
        System.out.println(deptPOJO);
    }


}

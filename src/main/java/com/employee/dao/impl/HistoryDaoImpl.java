package com.employee.dao.impl;

import com.employee.dao.HistoryDao;
import com.employee.pojo.HistoryPOJO;
import com.employee.util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HistoryDaoImpl implements HistoryDao {

    @Override
    public int insertHis(Connection conn, HistoryPOJO historyPOJO) throws SQLException {
        String sql2 = "insert into history(EMPNO,DEPTNO,SALARY,CHANGEDATE,CHANGEREASON) values(?,?,?,?,?)";

        return DBHelper.executeNonQuery(conn, sql2,new Object[]{
                historyPOJO.getEmpNo()
                ,historyPOJO.getDeptNo()
                ,historyPOJO.getSalary()
                ,historyPOJO.getChangeDate()
                ,historyPOJO.getChangeReason()
        });
    }

    @Override
    public int insertLeave(Connection conn, HistoryPOJO historyPOJO) throws SQLException {
        String sql = "insert into history(EMPNO,DEPTNO,SALARY,CHANGEDATE,CHANGEREASON,DIMISSIONDATE,DIMISSIONREASON) values(?,?,?,?,?,?,?)";

        return DBHelper.executeNonQuery(conn,sql,new Object[]{
                historyPOJO.getEmpNo()
                ,historyPOJO.getDeptNo()
                ,historyPOJO.getSalary()
                ,historyPOJO.getChangeDate()
                ,historyPOJO.getChangeReason()
                ,historyPOJO.getDimissionDate()
                ,historyPOJO.getDimissionReason()
        });

    }

    @Override
    public int deleteHis(Connection conn, String empNo) throws SQLException {
        String sql = "delete from history where EMPNO=?";

        return DBHelper.executeNonQuery(conn,sql,empNo);

    }

    @Override
    public List<HistoryPOJO> queryHisByHisNo(String empName) {
        String sql = "SELECT\n" +
                "\t* \n" +
                "FROM\n" +
                "\thistory\n" +
                "\tLEFT OUTER JOIN employee ON history.EMPNO = employee.EMPNO\n" +
                "\tLEFT JOIN dept ON history.DEPTNO = dept.DEPTNO \n" +
                "WHERE EMPNAME LIKE ? OR DEPTNAME LIKE ?";

        List<HistoryPOJO> list = DBHelper.executeQuery(sql, HistoryPOJO.class, "%" + empName + "%","%" + empName + "%");
        return list;

    }

    @Override
    public List<HistoryPOJO> queryAllHis() {
        String sql = "select * from dept,employee,history where dept.DEPTNO=history.DEPTNO and employee.EMPNO=history.EMPNO";

        List list = DBHelper.executeQuery(sql, HistoryPOJO.class);
        return list;
}

    @Override
    public List<HistoryPOJO> queryHisByPage(Integer pageNum, Integer pageSize) {
        String sql = "select * from dept,employee,history where dept.DEPTNO=history.DEPTNO and employee.EMPNO=history.EMPNO limit ?,?";

        List<HistoryPOJO> list = DBHelper.executeQuery(sql, HistoryPOJO.class, pageNum, pageSize);
        return list;
    }
}

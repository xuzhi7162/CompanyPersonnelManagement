package com.employee.dao.impl;

import com.employee.dao.HistoryDao;
import com.employee.pojo.HistoryPOJO;
import com.employee.util.C3P0Utils;
import com.employee.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sun.security.ssl.HandshakeInStream;

import java.sql.SQLException;
import java.util.List;

public class HistoryDaoImpl implements HistoryDao {
    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public int insertHis(HistoryPOJO historyPOJO) {
        String sql2 = "insert into history(EMPNO,DEPTNO,SALARY,CHANGEDATE,CHANGEREASON) values(?,?,?,?,?)";

        return DBHelper.executeUpdate(sql2,new Object[]{
                historyPOJO.getEmpNo()
                ,historyPOJO.getDeptNo()
                ,historyPOJO.getSalary()
                ,historyPOJO.getChangeDate()
                ,historyPOJO.getChangeReason()
        });
    }

    @Override
    public int insertLeave(HistoryPOJO historyPOJO) {
        String sql = "insert into history(EMPNO,DEPTNO,SALARY,CHANGEDATE,CHANGEREASON,DIMISSIONDATE,DIMISSIONREASON) values(?,?,?,?,?,?,?)";

        return DBHelper.executeUpdate(sql,new Object[]{
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
    public int deleteHis(String empNo) {
        String sql = "delete from history where EMPNO=?";

        return DBHelper.executeUpdate(sql,empNo);

    }

    @Override
    public List<HistoryPOJO> queryHisByHisNo(String empName) {
        String sql = "SELECT\n" +
                "\t* \n" +
                "FROM\n" +
                "\thistory\n" +
                "\tLEFT JOIN employee ON history.EMPNO = employee.EMPNO\n" +
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
}

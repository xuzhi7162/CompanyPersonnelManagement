package com.employee.util;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PageUtil {
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet resultSet = null;

    /**
     * 获取某个表的总行数
     * @param tableName 需要查询的表名
     * @return 表行数
     */
    public static int getRows(String tableName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(*) as rows from ").append(tableName);
        try {
            conn = DBHelper.getConnection();
            pstmt = conn.prepareStatement(stringBuilder.toString());
            resultSet = pstmt.executeQuery();
            resultSet.next();
            int s = resultSet.getInt("rows");
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn,pstmt,resultSet);
        }
        return 0;
    }

    /**
     * 查询某个表中符合条件的行数,仅适用于history表查询
     * @param
     * @return 表行数
     */
    public static int getRowsByKey(String key) {
        String sql = "SELECT count(*) as rows FROM history LEFT OUTER JOIN employee ON history.EMPNO = employee.EMPNO LEFT JOIN dept ON history.DEPTNO = dept.DEPTNO WHERE EMPNAME LIKE ? OR DEPTNAME LIKE ?";
        try {
            conn = DBHelper.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+key+"%");
            pstmt.setString(2,"%"+key+"%");
            resultSet = pstmt.executeQuery();
            resultSet.next();
            int s = resultSet.getInt("rows");
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn,pstmt,resultSet);
        }
        return 0;
    }

    /**
     * 获得分页总数
     * @param rows
     * @param
     * @return
     */
    public static int getPageNum(int rows,int pageSize) {
        int pageNum = rows / pageSize;
        int i = rows % pageSize;
        if(i > 0) {
            pageNum += 1;
        }
        return pageNum;
    }

    public static void main(String[] args) {
        int pageNum = getRowsByKey("王");
        System.out.println(pageNum);
    }
}

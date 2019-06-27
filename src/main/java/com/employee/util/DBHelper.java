package com.employee.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBHelper {

    private static ComboPooledDataSource ds = null;
    private static QueryRunner qr = null;
    private static Connection conn = null;
    static{
        ds = new ComboPooledDataSource();
        qr = new QueryRunner(ds);
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取 dataSource 数据源
     * @return
     */
    public DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取数据表
     * @param sql 要执行的 SQL 语句
     * @param clazz 需要封装的实体类型
     * @param params 参数
     * @return
     */
    public static List executeQuery(String sql, Class clazz, Object...params) {
        try {
            List query = (List) qr.query(sql, new BeanListHandler<>(clazz), params);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 执行更新语句
     * @param sql  要执行的 SQL 语句
     * @param params 参数
     * @return
     */
    public static int executeUpdate(String sql, Object...params) {
        try {
//            conn.setAutoCommit(false);
            int update = qr.update(sql, params);
//            conn.commit();
            return update;
        } catch (SQLException e) {
//            try {
////                conn.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取某一列的最大值，并以 Integer 返回
     * @param sql
     * @return
     */
    public static Integer getMax(String sql) {
        int empNoMax = 1;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                empNoMax = resultSet.getInt("max");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn,preparedStatement,resultSet);
        }
        return empNoMax;
    }


    /**
     * 查找某个表的某个列的在什么添加下可以查到多少行数据
     * @param tableName 表名
     * @param colName 列明
     * @param param 参数名
     * @return 查询到的行数
     */
    public static Integer getRows(String tableName, String colName, Object param) {
        StringBuilder sql = new StringBuilder();
        int amount = 0;
        sql.append("select count(*) as amount from ");
        sql.append(tableName);
        sql.append(" where ");
        sql.append(colName);
        sql.append("=?");
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            System.out.println(sql);
            conn = getConnection();
            preparedStatement = conn.prepareStatement(String.valueOf(sql));
            preparedStatement.setString(1, String.valueOf(param));
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                amount = resultSet.getInt("amount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn,preparedStatement,resultSet);
        }
        return amount;
    }



    public static void main(String[] args) {
        Integer rows = DBHelper.getRows("employee", "EMPNO", "0000210");
        System.out.println(rows);
    }


}

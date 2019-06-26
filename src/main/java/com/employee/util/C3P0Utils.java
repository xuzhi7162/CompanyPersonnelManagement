package com.employee.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Utils {

    private static ComboPooledDataSource ds = null;
    static {
        ds = new ComboPooledDataSource();
    }

    /**
     * 获取数据库连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 获取 c3p0 连接池对象
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(C3P0Utils.getConnection());
    }




}

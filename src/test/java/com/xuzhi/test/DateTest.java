package com.xuzhi.test;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;


public class DateTest {

//    @Test
//    public void t1() {
//        Date date = new Date(new java.util.Date().getTime());
//        System.out.println(date);
//    }

    @Test
    public void t2() {
        // 时间精确到秒或者毫秒
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(timestamp);
        // 时间精确到天
        java.sql.Date date = new java.sql.Date(new Date().getTime());
        System.out.println(date);
    }
}

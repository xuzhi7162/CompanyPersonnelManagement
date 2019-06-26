package com.employee.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CheckUtil {


    /**
     * 判断员工编号是否重复
     * @param empNo 待检测的员工编号
     * @return
     */
    public static Boolean isExists(String empNo){
        Integer rows = DBHelper.getRows("employee", "EMPNO", empNo);
        if(rows > 0) {
            return true;
        }
        return false;
    }


    /**
     * 验证是否为正整数
     * @param number 待检验的数据
     * @return
     */
    public static Boolean checkZNumber(String number) {
        boolean matches = number.matches("^\\+?[1-9][0-9]*$");
        return matches;
    }



    /**
     * 正则表达式检验方法
     * //TODO
     * @param regex
     * @param str
     * @return
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static void main(String[] args) {
        boolean nihao = CheckUtil.checkZNumber("123");
        System.out.println(nihao);
    }
}

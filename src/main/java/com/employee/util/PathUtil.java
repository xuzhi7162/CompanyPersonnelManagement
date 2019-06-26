package com.employee.util;

import javax.servlet.http.HttpServletRequest;

public class PathUtil {

    /**
     * 从请求路径中回去具体请求操作
     * @param request
     * @return
     */
    public static String checkPath(HttpServletRequest request) {
        String path = request.getRequestURI();

        int lastNum = path.lastIndexOf("/");
        int firstNum = path.indexOf("?");
        if(firstNum < 0) {

            return path.substring(lastNum + 1);
        }else {
            return path.substring(lastNum + 1,firstNum);
        }
    }


    /**
     * 从路径中获取二级、三级请求命令
     * //TODO
     * @return
     */
    public static String[] checkPath_2() {
        //TODO
        return null;
    }

}

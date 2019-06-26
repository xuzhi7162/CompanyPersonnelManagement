package com.employee.util;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {},loadOnStartup = 2)
public class WebPathInitServlet extends HttpServlet {
    private String sql = "select MAX(CAST(EMPNO as SIGNED INTEGER)) as max from employee";

    @Override
    public void init(ServletConfig config) throws ServletException {
        //在整体应用上下文当中存储了一个ctx的值，用他来引用上下文路径
        config.getServletContext().setAttribute("ctx",config.getServletContext().getContextPath());

        config.getServletContext().setAttribute("empNo",DBHelper.getMax(sql) + 1);
        super.init(config);
    }

}

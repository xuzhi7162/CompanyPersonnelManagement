package com.employee.servlet;

import com.employee.pojo.HistoryPOJO;
import com.employee.pojo.PagePOJO;
import com.employee.service.HistoryService;
import com.employee.service.impl.HistoryServiceImpl;
import com.employee.util.PageUtil;
import com.employee.util.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/history/*")
public class HistoryServlet extends HttpServlet {
    private HistoryService historyService = new HistoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = PathUtil.checkPath(req);

        if(path.equals("list")){
            String currentPage = req.getParameter("currentPage");
            int current = 0;
            if(currentPage != null){
                current = Integer.parseInt(currentPage) - 1;
            }
            List<HistoryPOJO> hisByPage = historyService.getHisByPage(current, 5);
            PagePOJO page = new PagePOJO();
            int rows = PageUtil.getRows("employee");
            page.setRows(rows);
            page.setPageNum(PageUtil.getPageNum(rows,5));
            page.setPageCurrent(current + 1);

            req.setAttribute("page", page);
            req.setAttribute("historys",hisByPage);
            req.getRequestDispatcher("/history.jsp").forward(req,resp);
        } else if(path.equals("search")) {
            String key = req.getParameter("key");
            List<HistoryPOJO> hisByEmpName = historyService.getHisByEmpName(key);
            req.setAttribute("historys",hisByEmpName);
            req.getRequestDispatcher("/history.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

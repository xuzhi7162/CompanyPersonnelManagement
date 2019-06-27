package com.employee.servlet;

import com.employee.pojo.DeptPOJO;
import com.employee.pojo.PagePOJO;
import com.employee.service.DeptService;
import com.employee.service.impl.DeptServiceImpl;
import com.employee.util.PageUtil;
import com.employee.util.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dept/*")
public class DeptServlet extends HttpServlet {
    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = PathUtil.checkPath(req);
        if(path.equals("list")) {
            String currentPage = req.getParameter("currentPage");
            int current = 0;
            if(currentPage != null){
                current = Integer.parseInt(currentPage) - 1;
            }
            List<DeptPOJO> deptByPage = deptService.getDeptByPage(current,5);
            PagePOJO page = new PagePOJO();
            int rows = PageUtil.getRows("dept");
            page.setRows(rows);
            page.setPageNum(PageUtil.getPageNum(rows,5));
            page.setPageCurrent(current + 1);

            req.setAttribute("page", page);
            req.setAttribute("depts",deptByPage);
            req.getRequestDispatcher("/department.jsp").forward(req,resp);
        } else if(path.equals("add")) {
            String deptName = req.getParameter("deptName");
            DeptPOJO deptPOJO = new DeptPOJO();
            deptPOJO.setDeptName(deptName);

            Boolean aBoolean = deptService.addDept(deptPOJO);
            String msg = aBoolean ? "部门添加成功！":"部门添加失败！";

            req.setAttribute("msg",msg);
            req.getRequestDispatcher("dept/list").forward(req,resp);
        } else if(path.equals("info")) {
            String deptNo = req.getParameter("deptNo");
            DeptPOJO deptsByDeptNo = deptService.getDeptsByDeptNo(Integer.valueOf(deptNo));
            req.setAttribute("dept",deptsByDeptNo);
            req.getRequestDispatcher("/updatedept.jsp").forward(req,resp);
        } else if(path.equals("update")) {
            String deptNo = req.getParameter("deptNo");
            String deptName = req.getParameter("deptName");

            DeptPOJO deptPOJO = new DeptPOJO();
            deptPOJO.setDeptNo(Integer.valueOf(deptNo));
            deptPOJO.setDeptName(deptName);
            Boolean aBoolean = deptService.updateDept(deptPOJO);
            String msg = aBoolean ? "部门更新成功！":"部门更新失败！";

            req.setAttribute("msg",msg);
            req.getRequestDispatcher("dept/list").forward(req,resp);
        }else if(path.equals("delete")) {
            String deptNo = req.getParameter("deptNo");
            Boolean aBoolean = deptService.deleteDept(Integer.valueOf(deptNo));
            String msg = aBoolean ? "部门删除成功！":"部门删除失败！";

            req.setAttribute("msg",msg);
            req.getRequestDispatcher("dept/list").forward(req,resp);
        } else if("page".equals(path)) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

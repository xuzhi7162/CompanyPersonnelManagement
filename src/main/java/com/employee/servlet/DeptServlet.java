package com.employee.servlet;

import com.employee.pojo.DeptPOJO;
import com.employee.service.DeptService;
import com.employee.service.impl.DeptServiceImpl;
import com.employee.util.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/deptList")
@WebServlet("/dept/*")
public class DeptServlet extends HttpServlet {
    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = PathUtil.checkPath(req);
        if(path.equals("list")) {
            List<DeptPOJO> allDepts = deptService.getAllDepts();
            req.setAttribute("depts",allDepts);
            req.getRequestDispatcher("/department.jsp").forward(req,resp);
        } else if(path.equals("add")) {
            deptService.addDept(req,resp);
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
            deptService.updateDept(deptPOJO);

            req.getRequestDispatcher("dept/list").forward(req,resp);
        }else if(path.equals("delete")) {
            String deptNo = req.getParameter("deptNo");
            deptService.deleteDept(Integer.valueOf(deptNo));

            req.getRequestDispatcher("dept/list").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

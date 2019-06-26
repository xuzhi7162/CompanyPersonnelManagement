package com.employee.servlet;

import com.employee.pojo.DeptPOJO;
import com.employee.pojo.EmpPOJO;
import com.employee.service.DeptService;
import com.employee.service.EmpService;
import com.employee.service.impl.DeptServiceImpl;
import com.employee.service.impl.EmpServiceImpl;
import com.employee.util.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/emp/*")
public class EmpServlet extends HttpServlet {
    private EmpService empService = new EmpServiceImpl();
    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = PathUtil.checkPath(req);

        if(path.equals("list")) {
            List<EmpPOJO> allEmps = empService.getAllEmps();
            req.setAttribute("emps",allEmps);
            req.getRequestDispatcher("/employee.jsp").forward(req,resp);
        } else if(path.equals("addPage")) {
            List<DeptPOJO> allDepts = deptService.getAllDepts();
            req.setAttribute("depts",allDepts);
            req.getRequestDispatcher("/addemp.jsp").forward(req,resp);
        } else if(path.equals("add")) {
            String deptNo = req.getParameter("deptNo");
            String empName = req.getParameter("empName");
            String empSex = req.getParameter("empSex");
            String entryDate = req.getParameter("entryDate");
            Date date = Date.valueOf(entryDate);
            String empPhone = req.getParameter("empPhone");
            String empAddr = req.getParameter("empAddr");
            String salary = req.getParameter("salary");
            int empNo = (int) req.getSession().getServletContext().getAttribute("empNo");
            req.getSession().getServletContext().setAttribute("empNo",empNo + 1);

            EmpPOJO empPOJO = new EmpPOJO();
            empPOJO.setEmpNo(String.valueOf(empNo));
            empPOJO.setDeptNo(Integer.valueOf(deptNo));
            empPOJO.setEmpName(empName);
            empPOJO.setEmpSex(empSex);
            empPOJO.setEntryDate(date);
            empPOJO.setEmpPhone(empPhone);
            empPOJO.setEmpAddr(empAddr);
            empPOJO.setSalary(Integer.valueOf(salary));

            empService.addEmp(empPOJO);

            req.getRequestDispatcher("/emp/list").forward(req,resp);
        } else if(path.equals("info")) {
            String empNo = req.getParameter("empNo");

            List<DeptPOJO> allDepts = deptService.getAllDepts();
            EmpPOJO empByEmpNO = empService.getEmpByEmpNO(empNo);

            req.setAttribute("depts",allDepts);
            req.setAttribute("emp",empByEmpNO);

            req.getRequestDispatcher("/updateemp.jsp").forward(req,resp);
        } else if(path.equals("update")) {
            String empNo = req.getParameter("empNo");
            String deptNo = req.getParameter("deptNo");
            String empName = req.getParameter("empName");
            String empSex = req.getParameter("empSex");
            String entryDate = req.getParameter("entryDate");
            Date date = Date.valueOf(entryDate);
            String empPhone = req.getParameter("empPhone");
            String empAddr = req.getParameter("empAddr");
            String salary = req.getParameter("salary");
            String changeReason = req.getParameter("changeReason");

            EmpPOJO empPOJO = new EmpPOJO();
            empPOJO.setEmpNo(String.valueOf(empNo));
            empPOJO.setDeptNo(Integer.valueOf(deptNo));
            empPOJO.setEmpName(empName);
            empPOJO.setEmpSex(empSex);
            empPOJO.setEntryDate(date);
            empPOJO.setEmpPhone(empPhone);
            empPOJO.setEmpAddr(empAddr);
            empPOJO.setSalary(Integer.valueOf(salary));
            empPOJO.setChangeReason(changeReason);

            empService.updateEmp(empPOJO);

            req.getRequestDispatcher("/emp/list").forward(req,resp);
        } else if(path.equals("leaveinfo")) {
            String empNo = req.getParameter("empNo");
            EmpPOJO empPOJO = empService.getEmpByEmpNO(empNo);

            req.setAttribute("emp",empPOJO);
            req.getRequestDispatcher("/dimission.jsp").forward(req,resp);
        } else if(path.equals("delete")) {
            String empNo = req.getParameter("empNo");
            empService.deleteEmp(empNo);
            req.getRequestDispatcher("/emp/list").forward(req,resp);
        } else if(path.equals("leave")) {
            String empNo = req.getParameter("empNo");
            String deptNo = req.getParameter("deptNo");
            String empName = req.getParameter("empName");
            String empSex = req.getParameter("empSex");
            String entryDate = req.getParameter("entryDate");
            Date date = Date.valueOf(entryDate);
            String empPhone = req.getParameter("empPhone");
            String empAddr = req.getParameter("empAddr");
            String salary = req.getParameter("salary");
            String changeReason = req.getParameter("dimissionReason");

            EmpPOJO empPOJO = new EmpPOJO();
            empPOJO.setEmpNo(String.valueOf(empNo));
            empPOJO.setDeptNo(Integer.valueOf(deptNo));
            empPOJO.setEmpName(empName);
            empPOJO.setEmpSex(empSex);
            empPOJO.setEntryDate(date);
            empPOJO.setEmpPhone(empPhone);
            empPOJO.setEmpAddr(empAddr);
            empPOJO.setSalary(Integer.valueOf(salary));
            empPOJO.setChangeReason(changeReason);

            empService.leaveEmp(empPOJO);
            req.getRequestDispatcher("emp/list").forward(req,resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}

package com.employee.servlet;

import com.employee.pojo.DeptPOJO;
import com.employee.pojo.EmpPOJO;
import com.employee.pojo.PagePOJO;
import com.employee.service.DeptService;
import com.employee.service.EmpService;
import com.employee.service.impl.DeptServiceImpl;
import com.employee.service.impl.EmpServiceImpl;
import com.employee.util.PageUtil;
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
            String currentPage = req.getParameter("currentPage");
            int current = 0;
            if(currentPage != null){
                current = Integer.parseInt(currentPage) - 1;
            }
            List<EmpPOJO> empByPage = empService.getEmpByPage(current, 5);
            PagePOJO page = new PagePOJO();
            int rows = PageUtil.getRows("employee");
            page.setRows(rows);
            page.setPageNum(PageUtil.getPageNum(rows,5));
            page.setPageCurrent(current + 1);

            req.setAttribute("page", page);
            req.setAttribute("emps", empByPage);
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

            Boolean aBoolean = empService.addEmp(empPOJO);
            String msg = aBoolean ? "员工添加成功":"员工添加失败";

            req.setAttribute("msg", msg);
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

            Boolean aBoolean = empService.updateEmp(empPOJO);
            String msg = aBoolean ? "员工信息更新成功":"员工信息更新失败";

            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/emp/list").forward(req,resp);
        } else if(path.equals("leaveinfo")) {
            String empNo = req.getParameter("empNo");
            EmpPOJO empPOJO = empService.getEmpByEmpNO(empNo);

            req.setAttribute("emp",empPOJO);
            req.getRequestDispatcher("/dimission.jsp").forward(req,resp);
        } else if(path.equals("delete")) {
            String empNo = req.getParameter("empNo");
            Boolean aBoolean = empService.deleteEmp(empNo);
            String msg = aBoolean ? "员工减员成功":"员工减员失败";

            req.setAttribute("msg", msg);
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

            Boolean aBoolean = empService.leaveEmp(empPOJO);
            String msg = aBoolean ? "员工离职成功":"员工离职失败";

            req.setAttribute("msg", msg);
            req.getRequestDispatcher("emp/list").forward(req,resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}

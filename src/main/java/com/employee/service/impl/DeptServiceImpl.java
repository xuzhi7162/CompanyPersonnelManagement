package com.employee.service.impl;

import com.employee.dao.DeptDao;
import com.employee.dao.impl.DeptDaoImpl;
import com.employee.pojo.DeptPOJO;
import com.employee.service.DeptService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao = new DeptDaoImpl();

    @Override
    public void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptName = req.getParameter("deptName");
        DeptPOJO deptPOJO = new DeptPOJO();
        deptPOJO.setDeptName(deptName);
        deptDao.insertDept(deptPOJO);
        req.getRequestDispatcher("dept/list").forward(req,resp);
    }

    @Override
    public void updateDept(DeptPOJO deptPOJO) {
        deptDao.updateDept(deptPOJO);
    }

    @Override
    public void deleteDept(Integer deptNo) {
        deptDao.deleteDept(deptNo);
    }

    @Override
    public List<DeptPOJO> getAllDepts() {
        return deptDao.queryAllDepts();
    }

    @Override
    public DeptPOJO getDeptsByDeptNo(Integer deptNo) {
        return deptDao.queryDeptByDeptNo(deptNo);
    }
}

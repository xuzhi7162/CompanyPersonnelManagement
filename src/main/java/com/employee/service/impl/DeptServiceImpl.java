package com.employee.service.impl;

import com.employee.dao.DeptDao;
import com.employee.dao.impl.DeptDaoImpl;
import com.employee.pojo.DeptPOJO;
import com.employee.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao = new DeptDaoImpl();

    @Override
    public Boolean addDept(DeptPOJO deptPOJO) {
        int i = deptDao.insertDept(deptPOJO);
        return (i > 0)? true:false;
    }

    @Override
    public Boolean updateDept(DeptPOJO deptPOJO) {
        int i = deptDao.updateDept(deptPOJO);
        return (i > 0)? true:false;

    }

    @Override
    public Boolean deleteDept(Integer deptNo) {
        int i = deptDao.deleteDept(deptNo);
        return (i > 0)? true:false;

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

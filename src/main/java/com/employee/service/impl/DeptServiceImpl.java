package com.employee.service.impl;

import com.employee.dao.DeptDao;
import com.employee.dao.impl.DeptDaoImpl;
import com.employee.pojo.DeptPOJO;
import com.employee.service.DeptService;
import com.employee.util.PageUtil;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao = new DeptDaoImpl();

    @Override
    public boolean addDept(DeptPOJO deptPOJO) {
        int i = deptDao.insertDept(deptPOJO);
        return (i > 0)? true:false;
    }

    @Override
    public boolean updateDept(DeptPOJO deptPOJO) {
        int i = deptDao.updateDept(deptPOJO);
        return (i > 0)? true:false;
    }

    @Override
    public boolean deleteDept(Integer deptNo) {
        int i = deptDao.deleteDept(deptNo);
        return (i > 0)? true:false;

    }

    @Override
    public List<DeptPOJO> getAllDepts() {
        return deptDao.queryAllDepts();
    }

    @Override
    public List<DeptPOJO> getDeptByPage(Integer pageNum,Integer pageSize) {
        List<DeptPOJO> deptPOJOS = deptDao.queryDeptByPage(pageNum * pageSize, pageSize);
        return deptPOJOS;
    }

    @Override
    public DeptPOJO getDeptsByDeptNo(Integer deptNo) {
        return deptDao.queryDeptByDeptNo(deptNo);
    }
}

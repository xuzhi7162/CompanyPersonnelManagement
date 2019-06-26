package com.employee.pojo;

import java.util.Date;

public class EmpPOJO {
    private String empNo;
    private Integer deptNo;
    private String deptName;
    private String empName;
    private String empSex;
    private Date entryDate;
    private String empPhone;
    private String empAddr;
    private Integer salary;
    private Date leaveDate;
    private Integer state;
    private String changeReason;

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpAddr() {
        return empAddr;
    }

    public void setEmpAddr(String empAddr) {
        this.empAddr = empAddr;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    @Override
    public String toString() {
        return "EmpPOJO{" +
                "empNo='" + empNo + '\'' +
                ", deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", empName='" + empName + '\'' +
                ", empSex='" + empSex + '\'' +
                ", entryDate=" + entryDate +
                ", empPhone='" + empPhone + '\'' +
                ", empAddr='" + empAddr + '\'' +
                ", salary=" + salary +
                ", leavelDate=" + leaveDate +
                ", state=" + state +
                ", changeReason='" + changeReason + '\'' +
                '}';
    }
}

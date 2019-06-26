package com.employee.pojo;

import java.util.Date;

public class HistoryPOJO {
    private Integer changeNo;
    private String empNo;
    private String empName;
    private Integer deptNo;
    private String deptName;
    private Integer salary;
    private Date changeDate;
    private String changeReason;
    private Date dimissionDate;
    private String dimissionReason;

    public Integer getChangeNo() {
        return changeNo;
    }

    public void setChangeNo(Integer changeNo) {
        this.changeNo = changeNo;
    }

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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public Date getDimissionDate() {
        return dimissionDate;
    }

    public void setDimissionDate(Date dimissionDate) {
        this.dimissionDate = dimissionDate;
    }

    public String getDimissionReason() {
        return dimissionReason;
    }

    public void setDimissionReason(String dimissionReason) {
        this.dimissionReason = dimissionReason;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "HistoryPOJO{" +
                "changeNo=" + changeNo +
                ", empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", salary=" + salary +
                ", changeDate=" + changeDate +
                ", changeReason='" + changeReason + '\'' +
                ", dimissionDate=" + dimissionDate +
                ", dimissionReason='" + dimissionReason + '\'' +
                '}';
    }
}

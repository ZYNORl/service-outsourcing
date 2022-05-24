package com.example.serve.bean.company;
import com.example.serve.bean.company.Employee;

import java.util.List;

public class ComEmployeeBody {
    private Integer code;
    private Integer totalpage;
    private Integer pagenum;
    private Integer total;
    private List<Employee> users;

    public ComEmployeeBody() {
    }

    public ComEmployeeBody(Integer code, Integer totalpage, Integer pagenum, Integer total, List<Employee> users) {
        this.code = code;
        this.totalpage = totalpage;
        this.pagenum = pagenum;
        this.total = total;
        this.users = users;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(Integer totalpage) {
        this.totalpage = totalpage;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public List<Employee> getUsers() {
        return users;
    }

    public void setUsers(List<Employee> users) {
        this.users = users;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":")
                .append(code);
        sb.append(",\"totalpage\":")
                .append(totalpage);
        sb.append(",\"pagenum\":")
                .append(pagenum);
        sb.append(",\"total\":")
                .append(total);
        sb.append(",\"users\":")
                .append(users);
        sb.append('}');
        return sb.toString();
    }
}

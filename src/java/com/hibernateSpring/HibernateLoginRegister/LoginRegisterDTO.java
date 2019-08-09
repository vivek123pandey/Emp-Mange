/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernateSpring.HibernateLoginRegister;

import com.hibernateSpring.HibernateClasses.EmployeeDTO;
import java.sql.Date;
import java.util.List;



/**
 *
 * @author vivek.pandey
 */
public class LoginRegisterDTO {
   private String username;
   private String password;
   private String email;
   private Date joindate;
   private String emptype;
   private String adminrole;
   private List<EmployeeDTO> hibernatedata;

  public List<EmployeeDTO> getHibernatedata() {
    return hibernatedata;
  }

  public void setHibernatedata(List<EmployeeDTO> hibernatedata) {
    this.hibernatedata = hibernatedata;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getJoindate() {
    return joindate;
  }

  public void setJoindate(Date joindate) {
    this.joindate = joindate;
  }

  public String getEmptype() {
    return emptype;
  }

  public void setEmptype(String emptype) {
    this.emptype = emptype;
  }

    public String getAdminrole() {
        return adminrole;
    }

    public void setAdminrole(String adminrole) {
        this.adminrole = adminrole;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernateSpring.HibernateClasses;

/**
 *
 * @author vivek.pandey
 */
public class EmployeeDTO {

  private int id;
  private String name;
  private String address;
  private String email;
  private String phone;
  private String addedEmpType;
  private String addedBy;
 private String emptype;

  public String getEmptype() {
    return emptype;
  }

  public void setEmptype(String emptype) {
    this.emptype = emptype;
  }
  public String getAddedBy() {
    return addedBy;
  }

  public void setAddedBy(String addedBy) {
    this.addedBy = addedBy;
  }

  public String getAddedEmpType() {
    return addedEmpType;
  }

  public void setAddedEmpType(String addedEmpType) {
    this.addedEmpType = addedEmpType;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}

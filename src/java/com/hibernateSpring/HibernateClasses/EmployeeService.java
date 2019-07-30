/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernateSpring.HibernateClasses;

import com.hibernateSpring.HibernateLoginRegister.LoginRegisterDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivek.pandey
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    @Transactional
    public void addEmp(EmployeeDTO empdto) {
        employeeDao.addUser(empdto);
    }

    @Transactional
    public List<EmployeeDTO> listAllEmployee() {
        return employeeDao.displayUser();
    }
    
    @Transactional
    public void updateEmployee(EmployeeDTO empdto){
        employeeDao.updateUser(empdto);
    }
    
    @Transactional
    public void deleteEmployee(int id){
        employeeDao.deleteUserWithId(id);
    }
    
    public LoginRegisterDTO login(LoginRegisterDTO loginregisterdto) {
        return employeeDao.login(loginregisterdto);
    }

    @Transactional
    public void register(LoginRegisterDTO loginregisterdto) {
        employeeDao.register(loginregisterdto);
    }

    public void setEmployeeDao(EmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }
}

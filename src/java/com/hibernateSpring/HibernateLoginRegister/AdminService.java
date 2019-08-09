/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernateSpring.HibernateLoginRegister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivek.pandey
 */
@Service
@Transactional
public class AdminService {
    
    @Autowired
    AdminDAO admindao;
    
    public String addAdminService(LoginRegisterDTO lrd){
      return admindao.createAdminUser(lrd);
    }
    public void updateAdminSerivce(){
        
    }
    public void deleteAdminService(){
        
    }
    public void selectAdminService(){
        
    }
    public LoginRegisterDTO loginAdminService(LoginRegisterDTO lrd){
       return admindao.loginAdmin(lrd.getUsername());
    }

    public void setAdmindao(AdminDAO admindao) {
        this.admindao = admindao;
    }
}

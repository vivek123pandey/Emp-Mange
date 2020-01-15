/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernateSpring.HibernateClasses;

import com.hibernateSpring.HibernateLoginRegister.LoginRegisterDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vivek.pandey
 */
@Repository
public class EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
   
    public void addUser(EmployeeDTO hbd) {
        sessionFactory.getCurrentSession().save(hbd);
    }

    public void updateUser(EmployeeDTO hbd) {
        sessionFactory.getCurrentSession().update(hbd);
    }

    public void deleteUserWithId(int id) {
     EmployeeDTO empdto =(EmployeeDTO)  sessionFactory.getCurrentSession().load(EmployeeDTO.class, id);
     sessionFactory.getCurrentSession().delete(empdto);
    }

   

    public List<EmployeeDTO> displayUser() {
        
       return  sessionFactory.getCurrentSession().createQuery("from EmployeeDTO").list();
    }

    public int countid(String emptype, String noOfRecordPerPage, HttpSession Session) {
       
        return 0;
    }

    public LoginRegisterDTO login(LoginRegisterDTO loginregisterdto) {
               
           return (LoginRegisterDTO) sessionFactory.getCurrentSession().get(LoginRegisterDTO.class, loginregisterdto.getUsername());
       }
    
        //
    public void register(LoginRegisterDTO loginregisterdto) {
        
    }
    
     public Map dynamicJs(){
        Map dynamicJsValue = new HashMap();
        String [] arrEle = new String[3];
        arrEle[0]="ram";
       arrEle[1] = "shyam";
       arrEle[2] = "shubh";
        dynamicJsValue.put("group0", "0013");
        dynamicJsValue.put("group1", "GPI");
        dynamicJsValue.put("group3", "RGT");
        dynamicJsValue.put("group0Div0", "abddddd");
        dynamicJsValue.put("group1Div0", "sdffsdfsdsdfsdfsdfsdf");
         dynamicJsValue.put("groupArray", arrEle);
        return dynamicJsValue;
    }

}

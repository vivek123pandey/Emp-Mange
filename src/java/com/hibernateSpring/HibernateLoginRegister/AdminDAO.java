/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernateSpring.HibernateLoginRegister;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vivek.pandey
 */
@Repository
public class AdminDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public String createAdminUser(LoginRegisterDTO lrd){
      return (String)sessionFactory.getCurrentSession().save(lrd);
    }
    
    public void udateAdminUser(LoginRegisterDTO lrd){
        sessionFactory.getCurrentSession().update(lrd);
    }
    
    public void deleteAdminUser(int id){
      LoginRegisterDTO lrd =(LoginRegisterDTO)  sessionFactory.getCurrentSession().load(LoginRegisterDTO.class, id);
      sessionFactory.getCurrentSession().delete(lrd);
    }
    
    public List<LoginRegisterDTO> selectAllUser(){
       return sessionFactory.getCurrentSession().createQuery("form LoginRegisterDTO").list();
    }
    
    public LoginRegisterDTO loginAdmin(String username){
        return (LoginRegisterDTO)sessionFactory.getCurrentSession().load(LoginRegisterDTO.class, username);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernateSpring.HibernateLoginRegister;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vivek.pandey
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminservice;

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public ModelAndView addAdminController(HttpServletRequest request, HttpSession session, ModelAndView m) {
        LoginRegisterDTO lrd = new LoginRegisterDTO();
        lrd.setUsername(request.getParameter("uname"));
        lrd.setEmail(request.getParameter("email"));
        lrd.setPassword(request.getParameter("password"));
        lrd.setJoindate(Date.valueOf(request.getParameter("datejoin")));
        lrd.setEmptype(request.getParameter("emptype"));
        if("Admin".equals(request.getParameter("emptype"))){
            lrd.setAdminrole("YES");
        }else{
            lrd.setAdminrole("NO");
        }
      String addAdmin = adminservice.addAdminService(lrd);
      if(addAdmin!=null){
        m.addObject("admin", lrd);
        m.setViewName("forward:/listallemp");
      }else{
           m.setViewName("forward:/listallemp?msg='User not registered completelly'");
      }
        return m;
    }

    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    public void updateAdminController() {

    }

    @RequestMapping(value = "/deleteAdmin", method = RequestMethod.POST)
    public void deleteAdminController() {

    }

    @RequestMapping(value = "/selectAdmin", method = RequestMethod.POST)
    public void selectAdminController() {

    }

    @RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
    public ModelAndView loginAdminController(HttpServletRequest request, HttpSession session, ModelAndView m) {
        if (session.getAttribute("loginInfo") == null || session.getAttribute("loginInfo") == "") {
            LoginRegisterDTO loginregisterdto = new LoginRegisterDTO();
            loginregisterdto.setUsername(request.getParameter("uname"));
            loginregisterdto.setPassword(request.getParameter("password"));
            loginregisterdto.setEmptype(request.getParameter("emptype"));
            loginregisterdto = adminservice.loginAdminService(loginregisterdto);
            session.setAttribute("loginInfo", loginregisterdto);
            m.addObject("loginInfo", loginregisterdto);
            m.setViewName("forward:/listallemp");
        } else {
            m.setViewName("forward:/listallemp?msg='already login!!!'");
        }
        return m;
    }
}

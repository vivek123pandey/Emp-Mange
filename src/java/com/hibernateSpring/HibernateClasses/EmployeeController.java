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
public class EmployeeController {

    LoginRegisterDTO loginregister = null;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addEmp(@ModelAttribute EmployeeDTO empdto, HttpSession session, ModelAndView m) {
        LoginRegisterDTO login = (LoginRegisterDTO) session.getAttribute("loginInfo");
        empdto.setAddedBy(login.getUsername());
        empdto.setAddedEmpType(login.getEmptype());
        if (empdto.getId() == 0) {
            employeeService.addEmp(empdto);
        }
        m.setViewName("forward:/listallemp");
        return m;
    }

    @RequestMapping(value = "/listallemp", method = RequestMethod.POST)
    public ModelAndView listAllEmployee(HttpSession session, HttpServletRequest request, ModelAndView m) {
        if (session.getAttribute("loginInfo") != null) {
            List<EmployeeDTO> listdto = employeeService.listAllEmployee();
            session.setAttribute("listdto", listdto);
            m.setViewName("index");
            return m;
        } else {
            m.addObject("msg", "You are not Login Currently!!!!!");
        }
        m.setViewName("index");
        return m;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@ModelAttribute EmployeeDTO empdto, HttpSession session, ModelAndView m) {
        LoginRegisterDTO login = (LoginRegisterDTO) session.getAttribute("loginInfo");
        empdto.setAddedBy(login.getUsername());
        empdto.setAddedEmpType(login.getEmptype());
        if (empdto.getId() != 0) {
            employeeService.updateEmployee(empdto);
        }
        m.setViewName("forward:/listallemp");
        return m;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteEmployee(HttpServletRequest request, HttpSession session, ModelAndView m) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        m.setViewName("forward:/listallemp");
        return m;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpSession session, ModelAndView m) {
        LoginRegisterDTO loginregisterdto = new LoginRegisterDTO();
        loginregisterdto.setUsername(request.getParameter("uname"));
        loginregisterdto.setPassword(request.getParameter("password"));
        loginregisterdto.setEmptype(request.getParameter("emptype"));
        loginregisterdto = employeeService.login(loginregisterdto);
        session.setAttribute("loginInfo", loginregisterdto);
        m.addObject("loginInfo", loginregisterdto);
        m.setViewName("forward:/listallemp");
        return m;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(LoginRegisterDTO loginregisterdto) {
        employeeService.register(loginregisterdto);
        return new ModelAndView("/index");
    }

}

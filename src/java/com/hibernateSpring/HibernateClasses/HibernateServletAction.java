/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernateSpring.HibernateClasses;

import com.hibernateSpring.HibernateLoginRegister.LoginRegisterDTO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vivek.pandey
 */
@WebServlet(name = "HibernateServletAction", urlPatterns = {"/HibernateServletAction"})
public class HibernateServletAction extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try {
      HttpSession session = request.getSession();
      String emptype = (String) session.getAttribute("emptype");
      String username = (String) session.getAttribute("username");
      String value = "Data inserted into database Successfully";
      EmployeeDTO hbd = new EmployeeDTO();
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String address = request.getParameter("address");
      String phone = request.getParameter("phone");
      System.out.println(name + "" + email + "" + address + "" + phone);
      hbd.setName(name);
      hbd.setEmail(email);
      hbd.setAddress(address);
      hbd.setPhone(phone);
      hbd.setAddedEmpType(emptype);
      hbd.setAddedBy(username);
      LoginRegisterDTO lrd = new LoginRegisterDTO();
      lrd.setUsername(name);
      lrd.setEmptype(emptype);
      lrd.setPassword("default");
      lrd.setEmail(email);
      lrd.setJoindate(new Date(0));
      EmployeeDAO hsa = new EmployeeDAO();
//      hsa.addUser(hbd,lrd);

      request.getRequestDispatcher("index.jsp?pageid=1&value=" + value).include(request, response);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}

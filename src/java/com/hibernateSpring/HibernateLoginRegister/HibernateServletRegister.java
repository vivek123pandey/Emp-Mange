/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernateSpring.HibernateLoginRegister;

import com.hibernateSpring.HibernateClasses.EmployeeDAO;
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
@WebServlet(name = "HibernateServletRegister", urlPatterns = {"/HibernateServletRegister"})
public class HibernateServletRegister extends HttpServlet {

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
      HttpSession session= request.getSession(true);
      String sessionuname=(String) session.getAttribute("username");
      String sessionemptype=(String) session.getAttribute("emptype");
      LoginRegisterDTO lrd = new LoginRegisterDTO();
      EmployeeDAO hsa = new EmployeeDAO();
      String name = request.getParameter("uname");
      String password = request.getParameter("password");
      String email = request.getParameter("email");
      String emptype = request.getParameter("emptype");
      Date datejoin = Date.valueOf(request.getParameter("datejoin"));
      lrd.setUsername(name);
      lrd.setPassword(password);
      lrd.setEmail(email);
      lrd.setEmptype(emptype);
      lrd.setJoindate(datejoin);
      hsa.register(lrd);
      request.getRequestDispatcher("index.jsp?value="+lrd.getEmptype()+" Successfully Register by "+sessionuname+"("+sessionemptype+") with username "+name+" and password "+password+"").include(request, response);

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

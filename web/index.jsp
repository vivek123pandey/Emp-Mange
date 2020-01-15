<%-- 
    Document   : index
    Created on : Mar 6, 2019, 3:47:05 PM
    Author     : vivek.pandey
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.hibernateSpring.HibernateClasses.EmployeeController"%>
<%@page import="com.hibernateSpring.HibernateLoginRegister.LoginRegisterDTO"%>
<%@page import="com.hibernateSpring.HibernateClasses.EmployeeDTO"%>
<%@page import="com.hibernateSpring.HibernateClasses.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
          <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href='http://fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="resource/css/datatables.css">
        <link rel="stylesheet" href="resource/css/datatables.min.css">
        <link rel="stylesheet" href="resource/css/dataTableCustomisation.css">
        <link rel="stylesheet" href="resource/css/print.css">
        <link rel="stylesheet" href="resource/css/hibernateEmployee.css">
        <link rel="stylesheet" href="resource/css/left-panel.css">
    </head>
    <body id="body">
        <% LoginRegisterDTO loginregister = (LoginRegisterDTO) session.getAttribute("loginInfo");
            String username = null;
            String emptype = null;
            if (loginregister != null) {
                username = loginregister.getUsername();
                emptype = (String) loginregister.getEmptype();
            }
            String pageid = request.getParameter("pageid");
            String value = request.getParameter("value");
            EmployeeDAO hsa = new EmployeeDAO();
            int str = hsa.countid(emptype, request.getParameter("noOfRecordPerPage"), session);
        %>
        <p class="hidden" id="username"><%=username%></p>
        <p class="hidden" id="emptype"><%=emptype%></p>
        <p class="backend-data dynamicJs"><%=hsa.dynamicJs()%></p>
        <%@include file="top-panel.jsp"%>

        <div class="content">
            <%@include file="left-panel.jsp"%>  
            <%@include file="page-header.jsp"%> 
            <div class="page-content">
                <p> <c:out value="${msg}" ></c:out></p>
                    <p class="alert alert-info" id="withoutsession">Unable to access data before login, To veiw data please login</p>
                    <p class="alert alert-warning" id="aftertablehide">NO Record In Database Table !!!!</p>
                    <p class="backend-data error-msg">PLACEHOLDER</p>
                <!--    dataTable content-->
                <div class="row">
                    <div class="">
                        <div id="collapse1" class="table-responsive panel-collapse">
                            <!--panel body section-->
                            <div class="panel-body">
                                <div class="well table-responsive">
                                    <table class="table table-striped table-hover table-condensed" id="table">
                                        <thead>
                                            <tr class="bg-info">
                                                <th>id</th>
                                                <th>Name</th>
                                                <th>Email</th>
                                                <th>Address</th>
                                                <th>Phone</th>
                                                <th class="admmincol">AddedByName</th>
                                                <th class="admmincol">AddedByType</th>
                                                <th>Actions</th>

                                            </tr>
                                        </thead>
                                        <tbody id="checkbox1">
                                            <%
                                                if (emptype != null) {
                                                    List<EmployeeDTO> list = (List<EmployeeDTO>) session.getAttribute("listdto");
                                                    if (list != null) {
                                                        for (EmployeeDTO hbd : list) {
                                            %>

                                            <tr>
                                                <td><%=hbd.getId()%></td>
                                                <td><%=hbd.getName()%></td>
                                                <td><%=hbd.getEmail()%></td>
                                                <td><%=hbd.getAddress()%></td>
                                                <td><%=hbd.getPhone()%></td>
                                                <td class="admmincol"><%=hbd.getAddedBy()%></td>
                                                <td class="admmincol"><%=hbd.getAddedEmpType()%></td>
                                                <td>
                                                    <a href="#editEmployeeModal<%=hbd.getId()%>" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                    <a href="#deleteEmployeeModal<%=hbd.getId()%>" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                                </td>
                                            </tr>
                                            <!-- Delete Modal HTML -->
                                        <div id="deleteEmployeeModal<%=hbd.getId()%>" class="modal fade">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <form action="delete" method="post">
                                                        <div class="modal-header">
                                                            <h4 class="modal-title">Delete Employee</h4>
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="form-group">
                                                                <label><%=hbd.getId()%></label>
                                                                <input type="hidden" id="getid" value="<%=hbd.getId()%>" name="id" class="form-control" required>
                                                            </div>
                                                            <p>Are you sure you want to delete these Records?</p>
                                                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                                            <input type="submit" class="btn btn-danger" value="Delete">
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Edit Modal HTML -->
                                        <div id="editEmployeeModal<%=hbd.getId()%>" class="modal fade">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <form action="update" method="post">
                                                        <div class="modal-header">
                                                            <h4 class="modal-title">Edit Employee</h4>
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="form-group">
                                                                <label>Id</label>
                                                                <input type="text" name="id" value="<%=hbd.getId()%>" readonly="true" class="form-control" required>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Name</label>
                                                                <input type="text" name="name" value="<%=hbd.getName()%>" class="form-control" required>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Email</label>
                                                                <input type="email" name="email" value="<%=hbd.getEmail()%>" class="form-control" required>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Address</label>
                                                                <textarea class="form-control" name="address" required><%=hbd.getAddress()%></textarea>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Phone</label>
                                                                <input type="text" class="form-control" name="phone" value="<%=hbd.getPhone()%>" required>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Emp Type</label>
                                                                <select class="form-control" name="emptype">
                                                                    <option class="form-control">Select Employee Type</option>
                                                                    <option class="form-control">Admin</option>
                                                                    <option class="form-control">Employee</option>
                                                                    <option class="form-control">Manager</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                                            <input type="submit" class="btn btn-info" value="Save">
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>                              
                                        <%
                                                    }
                                                }
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input type="button" class="print no-print" onclick="window.print()" value="print">              
                </div>
                <!-- login Modal HTML -->
                <div id="loginEmployeeModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="login" method="post">
                                <div class="modal-header bg-primary">
                                    <h4 class="modal-title">Login</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input type="text" name="uname" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" name="password" autocomplete="new-password" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Emp Type</label>
                                        <select class="form-control" name="emptype">
                                            <option class="form-control">Select Employee Type</option>
                                            <option class="form-control">Admin</option>
                                            <option class="form-control">Employee</option>
                                            <option class="form-control">Manager</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer bg-info">
                                    <input type="button" class="btn btn-warning" data-dismiss="modal" value="Cancel">
                                    <input type="submit" class="btn btn-success" value="Save">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- logout Modal HTML -->
                <div id="logoutEmployeeModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="HibernateServletlogout" method="post">
                                <div class="modal-header bg-primary">
                                    <h4 class="modal-title ">Logout</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label class="text-danger">Are You Sure To Logout, Click On Ok Button To Logout Otherwise Click On Cancel Button</label>
                                    </div>
                                    <div class="modal-footer bg-info">
                                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                        <input type="submit" class="btn btn-danger" value="Ok">
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Register Modal HTML -->
            <div id="registerEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="addAdmin" method="post">
                            <div class="modal-header bg-primary">
                                <h4 class="modal-title">Register Employee</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Username</label>
                                    <input type="text" name="uname" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" name="password" autocomplete="current-password" value="" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" name="email"  class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Emp Type</label>
                                    <select class="form-control" name="emptype">
                                        <option class="form-control">Select Employee Type</option>
                                        <option class="form-control">Admin</option>
                                        <option class="form-control">Manager</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Date Joining</label>
                                    <input type="date" class="form-control" name="datejoin" required>
                                </div>
                            </div>
                            <div class="modal-footer bg-info">
                                <input type="button" class="btn btn-warning" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Register">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Add Modal HTML -->
            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="add" method="post">
                            <div class="modal-header bg-primary">
                                <h4 class="modal-title">Add Employee</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" name="name" required>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" class="form-control" name="email" required>
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <textarea class="form-control" name="address" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Phone</label>
                                    <input type="text" class="form-control" name="phone" required>
                                </div>
                                <div class="form-group">
                                    <label>Emp Type</label>
                                    <select class="form-control" name="emptype">
                                        <option class="form-control">Select Employee Type</option>
                                        <option class="form-control">Employee</option>
                                        <option class="form-control">Manager</option>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-footer bg-info">
                                <input type="button" class="btn btn-warning" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Without Login Add Modal HTML -->
            <div id="withoutLoginAddEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header bg-primary">
                            <h4 class="modal-title">Login First</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <label class="text-danger">Please Login First To Add Data In Database Table</label>
                        </div>
                        <div class="modal-footer bg-info">
                            <input type="button" class="btn btn-warning" data-dismiss="modal" value="Cancel">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row footer col-sm-12">
        <span>
            this is the footer
        </span>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="resource/js/jquery-3-1-1.js"></script>
    <script src="resource/js/jquery.js"></script>
    <script src="resource/js/datatables.min.js"></script>
    <script src="resource/js/datatables.js"></script>
    <script type="text/javascript" src="resource/js/appPage.js"></script>  
</body>    
</html>






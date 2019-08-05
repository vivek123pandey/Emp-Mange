<%-- 
    Document   : home
    Created on : Mar 15, 2019, 10:13:04 AM
    Author     : vivek.pandey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="hibernateEmployee.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>
   <div class="container">
      <div class="panel panel-primary">
        <div class="panel-body">
          <nav class="navbar navbar-default container-fluid navbar-fixed-top">

            <div>
              <!--              Brand and toggle get grouped for better mobile display-->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">Employee Demo</a>
              </div>
              <!--              Collect the nav links, forms, and other content for toggling-->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <li class="active"><a href="Home.html"> <span class="glyphicon glyphicon-home"></span>Home</a></li>
                  <li><a href="#"> <span class="glyphicon glyphicon-king"></span>About</a></li>
<!--                  <li><a href="#addEmployeeModal" data-toggle="modal"> <span class="glyphicon glyphicon-plus" aria-hidden="true"></span><span>Add New Employee</span></a></li>
                  <li> <a href="#deleteEmployeeModal" data-toggle="modal"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> <span>Delete</span></a></li>
-->
                </ul>
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="#loginEmployeeModal" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                  <li><a href="#registerEmployeeModal" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                </ul>
              </div> <!--  //.navbar-collapse-->
            </div> <!--  //.container-fluid-->
          </nav>
        </div>
      </div>
    </div>
  </body>
</html>

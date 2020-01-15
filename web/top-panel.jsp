<%-- 
    Document   : top-panel
    Created on : Jan 6, 2020, 5:46:19 PM
    Author     : vivek.pandey
--%>
<header class="navbar navbar-inverse">
    <div class="container-fluid custom-container">
        <nav class="navbar">
            <div>
                <!--Brand and toggle get grouped for better mobile display-->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Employee Demo</a>
                    <input type="button" class="inputUrl" value="Open New">
                </div>
                <!--Collect the nav links, forms, and other content for toggling-->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">

                        <li id="login"><a href="#loginEmployeeModal"  data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>

                        <li id="logout"><a href="#logoutEmployeeModal"  data-toggle="modal"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>

                        <li><a href="#registerEmployeeModal" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                    </ul>
                </div>   
            </div>   
        </nav>
    </div>
</header>

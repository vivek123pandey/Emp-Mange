/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var uname = null;
var emptype = null;

$(document).ready(function () {
     $("#logout").hide();
    $("#withoutsession").hide();
    $("#aftertablehide").hide();
    $(".admmincol").hide();
    $(".print").hide();
    uname = $("#username").text();
    emptype = $("#emptype").text();
    $('[data-toggle="tooltip"]').tooltip();
   
    basicViewValidation();
    changeUrlForAddEmp();
    checkboxSelection();
    toggleLoginLogout();
    upDownSymbol();
    initalizeDataTable();
    openUrlWithClickByJquery()
});

function basicViewValidation() {

    if (emptype == "Admin") {
        $(".admmincol").show();
    }

    if (uname == "null") {
        $("#collapse1").hide();
        $("#withoutsession").show();
        $(".print").show();
    }
   else if (!$("#checkbox1").length) {
        $("#collapse1").hide();
        $("#aftertablehide").show();
    }
    if (!$("#pageLink").length) {
        $("#clearfix").hide();
    }
}

// Select/Deselect checkboxes
function checkboxSelection() {
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
}

function changeUrlForAddEmp() {
    $("#addemp").click(function () { //alert(uname);
        if (uname == "null") {
            if ($("#addemp").attr('href') === "#addEmployeeModal") {
                var oldUrl = $(this).attr("href"); // Get current url
                var newUrl = oldUrl.replace("#addEmployeeModal", "#withoutLoginAddEmployeeModal"); // Create new url
                $(this).attr("href", newUrl);
            }
        }
    });
}

function toggleLoginLogout() {
    if (uname != "null") {
        $("#login").hide();
        $("#logout").show();
    } else {
        $("#login").show();
    }

}

function upDownSymbol() {
    $("#Add").click(function () {
        if ($("#Add").attr('class') === "glyphicon glyphicon-chevron-up") {
            $("#Add").removeClass("glyphicon glyphicon-chevron-up");
            $("#Add").addClass("glyphicon glyphicon-chevron-down");
        } else {
            $("#Add").removeClass("glyphicon glyphicon-chevron-down");
            $("#Add").addClass("glyphicon glyphicon-chevron-up");
        }
    });
}
function initalizeDataTable() {
    $("#user-table").DataTable()
}
function openUrlWithClickByJquery(){
  
    $(".inputUrl").click(function(r){
        if(r){
         window.open("http://localhost:8080/Emp_Management", "Open New Url", "width=200,height=200");     
        }
    });
}

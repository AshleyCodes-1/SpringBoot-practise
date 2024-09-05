<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>congratulation page </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div class="container">
 
  <h4> ${message} </h4>   
   
  <table class="table table-hover">
    <thead>
      <tr bgcolor="yellow">
        <th>Employee Id</th>
        <th>Employee Name</th>
        <th>Salary</th>
        <th>Email address</th>
        <th>Password</th>
        <th colspan=2>Operations(Delete/edit)</th>
      </tr>
    </thead>
    
    <tbody>
      	<c:forEach items="${employeeDTO}" var="tempVar" >
			<tr bgcolor="pink">
				<td>${tempVar.employeeId}</td>
        		<td>${tempVar.employeeName}</td>
        		<td>${tempVar.salary}</td>
        		<td>${tempVar.emailId}</td>
        		<td>${tempVar.password}</td>
        		<td><a href="deleteEmployee?employeeId=${tempVar.employeeId}"><button class="btn btn-primary"><img alt="login logo" src="images/delete.png" style="height:40px;width:40px"></button></a></td>
        		<td><a href="updateEmployee?employeeId=${tempVar.employeeId}"><button class="btn btn-warning"><img alt="update logo" src="images/edit.jpg" style="height:40px;width:40px"></button></a></td>
			</tr>
	  	</c:forEach>
   </tbody>
  </table>
  
</div>
</body>
</html>
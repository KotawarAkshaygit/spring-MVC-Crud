<%@page import="springcrud2.employeeBean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Employee emp=(Employee)request.getAttribute("edits");
//out.print(emp.getId()+" "+emp.getName());
%>
<form action="update" method="post">
Id<input type="text" name="id" value="<%=emp.getId()%>" readonly="readonly"><br>
Name<input type="text" name="name" value="<%=emp.getName()%>"><br>
Salary:    <input type="text" name="salary" value="<%=emp.getSalary()%>"><br>
department:<input type="text" name="dept" value="<%=emp.getDept()%>"><br>
<input type="submit" value="submit"></form>
</body>
</html>
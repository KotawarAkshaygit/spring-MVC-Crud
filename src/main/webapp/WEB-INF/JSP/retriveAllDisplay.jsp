<%@page import="springcrud2.employeeBean.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
List Of Employees are<br>

<% List<Employee> list=(List<Employee>)request.getAttribute("employeeList");
for(Employee emp:list)
{
	out.println("<center>"+emp.getId());
	out.println(emp.getName());
	out.println(emp.getSalary());
	out.println(emp.getDept());
	request.setAttribute("empid",emp.getId());
	out.println("<a href='delete?id="+emp.getId()+"'><button>delete</button></a>");

	out.println("<a href='edit?id="+emp.getId()+"'><button>update</button></a><br></center>");
	
}
%>
<a href="form"><button>Click here to go to home Page</button></a>
<br>
</body>
</html>
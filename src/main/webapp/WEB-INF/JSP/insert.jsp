<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>  
.error{color:red}  
</style>  
</head>  
<body>  
<center><pre>
<form:form action="insert" method="post"  modelAttribute="employee">  
Enter Name(*) <form:input path="name"/> <br> <form:errors path="name" cssClass="error"/><br>   
Enter Salary(*): <form:input path="salary"/> <form:errors path="salary" cssClass="error"/><br>   
Enter Department(*): <form:input path="dept"/>  <form:errors path="dept" cssClass="error"/><br> 

<input type="submit" value="submit">  
</form:form>
</pre>
</center>
<br>

Click here to retrive details by id<br>
<a href="retrive.jsp"><button>retrive by id</button></a><br>

<br>Click here to retrive All Employees<br>
<a href="retriveAll"><button>retriveAll Employees</button></a>

</body>
</html>






<!--  
<center><pre>
<form action="insert" method="post">
Please Provide Employee Details<br>
Enter Name:      <input type="text" name="name" required><br>
Enter Salary:    <input type="text" name="salary" required><br>
Enter department:<input type="text" name="dept" required><br>
<input type="submit" value="submit">
</pre>

</form>
</center>
Click here to retrive details by id<br>
<a href="retrive.jsp"><button>retrive by id</button></a><br>

Click here to retrive All Employees<br>
<a href="retriveAll"><button>retriveAll Employees</button></a>
-->

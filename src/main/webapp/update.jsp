<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><pre>
<form action="update" method="post">
Enter the details to Update Employee<br>
Enter Id<input type="text" name=id value=<%request.getAttribute("empid");%>><br>
Enter Name<input type="text" name="name"><br>
Enter Salary<input type="text" name="salary"><br>
Enter Department<input type="text" name="dept"><br>
<input type="submit" value="submit">
</form>
</pre>
</center>
</body>
</html>
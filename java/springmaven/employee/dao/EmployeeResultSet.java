package springmaven.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmaven.pojo.Employee;

public class EmployeeResultSet implements RowMapper<Employee>{

	
	 public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
     {
     	
     	Employee employee = new Employee();
         employee.setId(rs.getInt(1));
         employee.setName(rs.getString(2));
         employee.setSalary(rs.getInt(3));
         employee.setDept(rs.getString(4));
         return employee;
     }
}

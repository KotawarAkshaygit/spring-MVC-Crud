package springmaven.employee.dao;

import java.util.List;

import springmaven.pojo.Employee;

public interface EmployeeDao {

	long create(Employee employee);
	public Employee retrive(int id);
	int update(Employee employee);
	public List<Employee> getAllEmployees();
	int removeEmployee(int id);
	public Employee edit(int id);
}

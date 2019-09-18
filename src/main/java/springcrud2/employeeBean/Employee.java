package springcrud2.employeeBean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import springcrud2.validation.IsValidDept;

public class Employee {

	private int id;
	
	@Pattern(regexp="^[A-Z][a-zA-Z]{1,15}$")
	@Size(min=3,max=15)
	private String name;
	//[^0-9]*
	
	@Min(1)
	private int salary;
	
	@Size(min=2,max=15) @IsValidDept
	private String dept;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
	}
	
}

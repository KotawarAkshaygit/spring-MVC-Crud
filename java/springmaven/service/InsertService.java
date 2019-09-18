package springmaven.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import springmaven.pojo.Employee;

public class InsertService {


	public boolean isValidNames(String name) {
		
		if(isValidName(name)) {
			return true;
		}
	else
	{
		return false;
	}
	}
	public boolean isValidSalarys(int sal) {
		if(isValidSalary(sal)) {
			return true;
		}
	else
	{
		return false;
	}
		
	}
	public boolean isValidDepts(String dept) {
		if(isValidDepartment(dept)) {
			return true;
		}
	else
	{
		return false;
	}
	}

	

	private boolean isValidDepartment(String dept) {
		Pattern deptPattern = Pattern.compile("^[A-Z][a-z]{3,}$");
		Matcher deptMatcher = deptPattern.matcher(dept);
		return deptMatcher.matches();
	}

	private boolean isValidSalary(int salary) {
		
		if(salary>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean isValidName(String name) {
		Pattern namePattern = Pattern.compile("^[A-Z][a-z]{3,}$");
		Matcher nameMatcher = namePattern.matcher(name);
		return nameMatcher.matches();
	}

	
	
}

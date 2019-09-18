package springcrud2.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DeptValidation implements ConstraintValidator<IsValidDept,String>{

	
	public boolean isValid(String dept, ConstraintValidatorContext context) {
		if(dept== null)
		{
		return false;
		}
		if(dept.matches("Development|Testing|Hr|Cloud"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
}

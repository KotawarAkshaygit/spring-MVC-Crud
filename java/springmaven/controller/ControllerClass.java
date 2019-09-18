package springmaven.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmaven.employee.dao.EmployeeDaoImpl;
import springmaven.pojo.Employee;
import springmaven.service.InsertService;

@Controller
public class ControllerClass {

	@Autowired
	EmployeeDaoImpl dao;
	
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String register(@ModelAttribute("employee") Employee emp,ModelMap model) {
		
		
		
		
		/*InsertService iservice=new InsertService();
		String name=emp.getName();
		int count=0;
		if(iservice.isValidNames(emp.getName()))
		{
		count++;
		}
		else {
			model.addAttribute("resultname","Please Provide first letter of Name as Capital");
			// return "insertdisplayerror";
		//	model.addAttribute("resultname");
		
		}
		if(iservice.isValidSalarys(emp.getSalary()))
		{
		count++;
		}
		else
		{
		model.addAttribute("resultsalary","Please Provide Valid salary ");
		// return "insertdisplayerror";
	}
		if(iservice.isValidDepts(emp.getDept()))
		{
		count++;
		}
		else
		{
			model.addAttribute("resultdept","Please Provide First Letter of department as capital");
			 return "insertdisplayerror";
		}
		
		 if(count==3)
		 {
				long result=dao.create(emp);
				model.addAttribute("result",result);
				return "insertdisplay";
		 }
		 
		 else
		 {
			// model.addAttribute("result","please Provide Valid details");
			 return "insertdisplayerror";
		 }
		 */
	}
	
	@RequestMapping(value="/retrive",method=RequestMethod.GET)
	public String retrive(@RequestParam("id") int id,ModelMap mod)
	{
		
		Employee emp=dao.retrive(id);
		System.out.println(emp);
		if(emp.getId()==0)
		{
			mod.addAttribute("retrives","Given Id is not exist");
			return "retrivedisplay";
		}
		else
		{
			mod.addAttribute("retrives",emp);
			return "retrivedisplay";
		}
		
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(@RequestParam("id") int id,ModelMap mod)
	{
		
		Employee emp=dao.edit(id);
		if(emp.equals(null))
		{
			mod.addAttribute("retrives","Given Id is not exist'+id'");
		}
	mod.addAttribute("edits",dao.edit(id));
		return "editdisplay";
		
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute Employee emps,ModelMap model)
	{ 
		
		int result=dao.update(emps);
		int res=emps.getId();
		model.addAttribute("result", res);
		return "updatedisplay";
	}
	
	
	@RequestMapping(value="/retriveAll",method=RequestMethod.GET)
	public ModelAndView listEmployees(@ModelAttribute("employee") Employee emps)
	{
		
		ModelAndView model=new ModelAndView("retriveAllDisplay");
		java.util.List<Employee>  employeeList=dao.getAllEmployees();
		   model.addObject("employeeList", employeeList);
	        
	        return model;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String removeEmployee(@RequestParam("id") int id,ModelMap modelmp)
	{
		System.out.println(id);
		
		int deleted=dao.removeEmployee(id);
		System.out.println(deleted);
		modelmp.addAttribute("deleted",deleted);
		
		return "deletedisplay";
	}
}

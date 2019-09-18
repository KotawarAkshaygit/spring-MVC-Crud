package springcrud2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springcrud2.EmployeeDao.EmployeeDaoImpl;
import springcrud2.employeeBean.Employee;

@Controller
public class ControllerClass {

	@Autowired
	EmployeeDaoImpl dao;
	
	@RequestMapping("form")
	public String showIndex(Model m) {
		m.addAttribute("employee",new Employee());
		return "insert";
	}
	
	

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("employee") Employee emp, BindingResult br, ModelMap model) {
		if (br.hasErrors()) {
			return "insert";
		} else {
			long result = dao.create(emp);
			model.addAttribute("result", result);
			return "insertdisplay";
		}
	}

	@RequestMapping(value = "/retrive", method = RequestMethod.GET)
	public String retrive(@RequestParam("id") int id, ModelMap mod) {

		Employee emp = dao.retrive(id);
		System.out.println(emp);
		if (emp.getId() == 0) {
			mod.addAttribute("retrives", "Given Id is not exist");
			return "retrivedisplay";
		} else {
			mod.addAttribute("retrives", emp);
			return "retrivedisplay";
		}

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap mod) {

		Employee emp = dao.retrive(id);
		if (emp.equals(null)) {
			mod.addAttribute("retrives", "Given Id is not exist'+id'");
		}
		mod.addAttribute("edits", emp);
		return "editdisplay";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute Employee emps, ModelMap model) {

		int result = dao.update(emps);
		int res = emps.getId();
		model.addAttribute("result", res);
		return "updatedisplay";
	}

	@RequestMapping(value = "/retriveAll", method = RequestMethod.GET)
	public ModelAndView listEmployees(@ModelAttribute("employee") Employee emps) {

		ModelAndView model = new ModelAndView("retriveAllDisplay");
		java.util.List<Employee> employeeList = dao.getAllEmployees();
		model.addObject("employeeList", employeeList);

		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String removeEmployee(@RequestParam("id") int id, ModelMap modelmp) {
		System.out.println(id);

		int deleted = dao.removeEmployee(id);
		System.out.println(deleted);
		modelmp.addAttribute("deleted", deleted);

		return "deletedisplay";
	}
}

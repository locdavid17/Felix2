package assets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assets.dao.DepartmentDAO;
import assets.entities.Asset_List;
import assets.entities.Assets;
import assets.entities.Department;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentDAO departmentDAO;

	@RequestMapping("/listDepartment")
	public String listDepartment(Model model) {

		List<Department> departments = departmentDAO.getDepartments();
		model.addAttribute("list", departments);

		return "listDepartment";
	}

	@RequestMapping("/initInsertDepartment")
	public String initInsertDepartment(Model model) {
		List<Department> departments = departmentDAO.getDepartments();
		model.addAttribute("listDepartment", departments);

		Department d = new Department();
		model.addAttribute("d", d);

		return "insertDepartment";

	}

	@RequestMapping("/insertDepartment")
	public String insertDepartment(@ModelAttribute("d") Department d, Model model) {
			boolean bl = departmentDAO.insertDepartment(d);
			if(bl) {
				List<Department> departments = departmentDAO.getDepartments();
				model.addAttribute("d", departments);
				return "redirect:/listDepartment";
			}else {
				model.addAttribute("d", d);
				model.addAttribute("error", "insert failed!");
				return "insertDepartment";
			}
	}
	
	@RequestMapping("/detailDepartment")
	public String detailDepartment(@RequestParam("departmentID")String departmentID,Model model) {
		
		Department department = departmentDAO.getDepartmentById(departmentID);
		model.addAttribute("d", department);
		
		return"detailDepartment";
	}
	@RequestMapping("/deleteDepartment")
	public String deleteDepartment(@RequestParam("departmentID")String departmentID,Model model) {
		boolean bl = departmentDAO.deleteDepartment(departmentID);
		if(bl){
			model.addAttribute("succes", "delete successfully!!");
		}else {
			model.addAttribute("err", " delete  failed!!");
		}
		List<Department> departments = departmentDAO.getDepartments();
		model.addAttribute("list", departments);

		return "listDepartment";
	}
	
	@RequestMapping("/initUpdateDepartment")
	public String initUpdateDepartment(@RequestParam("departmentID")String departmentID,Model model) {
		List<Department> departments = departmentDAO.getDepartments();
		model.addAttribute("listDepartment", departments);
		
		Department depart = departmentDAO.getDepartmentById(departmentID);
		model.addAttribute("d", depart);
		
		return "UpdateDepartment";
	}

	@RequestMapping("/UpdateDepartment")
	public String UpdateDepartment(@ModelAttribute("d")Department d,Model model) {
		boolean bl = departmentDAO.updateDepartment(d);
		if(bl) {
			return "redirect:/listDepartment";
		}else {
			model.addAttribute("d", d);
			model.addAttribute("err", "update Failed!");
			return"UpdateDepartment";
		}
	}
}

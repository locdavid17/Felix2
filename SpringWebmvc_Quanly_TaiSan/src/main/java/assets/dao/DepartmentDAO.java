package assets.dao;

import java.util.List;

import assets.entities.Department;

public interface DepartmentDAO {
	
	public List<Department> getDepartments();
	public boolean insertDepartment(Department d);
	public Department getDepartmentById(String departmentID);
	public boolean deleteDepartment(String departmentID);
	public boolean updateDepartment(Department d);
}

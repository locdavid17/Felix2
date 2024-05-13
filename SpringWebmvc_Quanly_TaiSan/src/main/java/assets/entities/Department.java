package assets.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
	
	@Id
	@Column(name = "DepartmentID")
	private String departmentID;
	@Column(name = "DepartmentName")
	private String departmentName;
	@Column(name = "Manager")
	private String manager;
	@Column(name = "Address")
	private String address;
	@Column(name = "Status")
	private Boolean status;
	
	@OneToMany(mappedBy = "depart")
	private Set<Asset_List> listAsset_Lists;
	
	@OneToMany(mappedBy = "depart")
	private Set<Staff> listStaffs;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String departmentID, String departmentName, String manager, String address, Boolean status) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.manager = manager;
		this.address = address;
		this.status = status;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<Asset_List> getListAsset_Lists() {
		return listAsset_Lists;
	}

	public void setListAsset_Lists(Set<Asset_List> listAsset_Lists) {
		this.listAsset_Lists = listAsset_Lists;
	}

	public Set<Staff> getListStaffs() {
		return listStaffs;
	}

	public void setListStaffs(Set<Staff> listStaffs) {
		this.listStaffs = listStaffs;
	}
	
}

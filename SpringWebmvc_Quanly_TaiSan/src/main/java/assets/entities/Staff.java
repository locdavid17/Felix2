package assets.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Staff")
public class Staff {
	@Id
	@Column(name = "StaffID")
	private String staffID;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "LastName")
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name = "DepartmentID",referencedColumnName = "DepartmentID")
	private Department depart;
	
	
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(String staffID, String firstName, String lastName) {
		super();
		this.staffID = staffID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	
	

}

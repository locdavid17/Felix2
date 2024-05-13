package assets.entities;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String passWord;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<User_Role> userRoles;


	public User() {
		// TODO Auto-generated constructor stub
		super();
	}


	public User(Long id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Set<User_Role> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<User_Role> userRoles) {
		this.userRoles = userRoles;
	}
	
	
}
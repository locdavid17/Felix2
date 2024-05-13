package assets.entities;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails {
	private Collection<? extends GrantedAuthority> authorities;
	
	private String password;
	private String username;
	private Boolean enabled;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private boolean credentialsNonExpired;

	
	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
		super();
	}


	public CustomUserDetails(Collection<? extends GrantedAuthority> authorities, String password, String username,
			Boolean enabled, Boolean accountNonExpired, Boolean accountNonLocked, boolean credentialsNonExpired) {
		super();
		this.authorities = authorities;
		this.password = password;
		this.username = username;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
	}


	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}


	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}


	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}


	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked	;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	public void eraseCredentials() {
		this.password = null;
	}
	
	

}

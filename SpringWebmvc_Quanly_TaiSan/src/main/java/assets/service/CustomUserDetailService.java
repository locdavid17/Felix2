package assets.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import assets.dao.UserRepositoryDAO;
import assets.dao.UserRepositoryDAO;
import assets.entities.User_Role;
import assets.entities.CustomUserDetails;
import assets.entities.User;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepositoryDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return loadUser(username);
	}

	private UserDetails loadUser(String username) {
		assets.entities.User user = userDAO.findByUsername(username);
		if (user == null) {
			return null;
		}
		Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
		Set<User_Role> roles = user.getUserRoles();
		for (User_Role account_Role : roles) {
			grantedAuthoritySet.add(new SimpleGrantedAuthority(account_Role.getRole().getName()));
		}
		return new CustomUserDetails(grantedAuthoritySet,  user.getPassWord(), user.getUserName() , true,
				true, true, true);
	}
}

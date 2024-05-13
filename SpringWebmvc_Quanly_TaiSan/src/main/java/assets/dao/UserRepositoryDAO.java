package assets.dao;

import assets.entities.User;

public interface UserRepositoryDAO {

		public User findByUsername(String username);
}

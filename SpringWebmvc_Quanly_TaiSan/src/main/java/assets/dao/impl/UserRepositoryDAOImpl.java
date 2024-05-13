
package assets.dao.impl;

import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assets.dao.UserRepositoryDAO;
import assets.entities.User;

@Repository
public class UserRepositoryDAOImpl implements UserRepositoryDAO {
	@Autowired
	private SessionFactory sessionFactory;



	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = sessionFactory.openSession();
		
		try {
			User user = (User) session.createQuery("from User where userName = :userName  ")
					.setParameter("userName", username).uniqueResult();
			
			
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

}
package assets.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assets.dao.LocationDAO;
import assets.entities.Location;

@Repository
public class LocationDAOImpl implements LocationDAO{
@Autowired
private SessionFactory sessionFactory;
	@Override
	public List<Location> getloLocations() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Location").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}

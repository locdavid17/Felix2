package assets.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assets.dao.StaffDAO;
import assets.entities.Staff;
@Repository
public class StaffDAOImpl implements StaffDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Staff> getstStaffs() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Staff").list();
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

}

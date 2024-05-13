package assets.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assets.dao.HandoverDAO;
import assets.entities.Department;
import assets.entities.Handover;
@Repository
public class HandoverDAOImpl implements HandoverDAO {
@Autowired
private SessionFactory sessionFactory;
	@Override
	public List<Handover> getHandovers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Handover").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	@Override
	public boolean insertHandover(Handover h) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(h);
			session.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			
		}finally {
			session.close();
		}
		return false;
	}
	@Override
	public Handover getHandoverById(String handoverID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Handover handover = session.get(Handover.class, handoverID);
			return handover;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return null;
	}
	@Override
	public boolean deleteHandover(String handoverID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getHandoverById(handoverID));
			session.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}
	

}

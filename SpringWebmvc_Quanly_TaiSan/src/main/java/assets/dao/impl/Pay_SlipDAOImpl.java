package assets.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assets.dao.Pay_SlipDAO;
import assets.entities.Handover;
import assets.entities.Pay_Slip;

@Repository
public class Pay_SlipDAOImpl implements Pay_SlipDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Pay_Slip> getPay_Slips() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Pay_Slip").list();
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
	public boolean insertPay_Slip(Pay_Slip p) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(p);
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
	public Pay_Slip getPay_SlipById(String Pay_Slip_Id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		try {
			Pay_Slip pay_Slip = session.get(Pay_Slip.class, Pay_Slip_Id);
			
			return pay_Slip;
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
	public boolean deletePay_Slip(String Pay_Slip_Id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getPay_SlipById(Pay_Slip_Id));
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

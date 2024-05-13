package assets.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assets.dao.AssetsDAO;
import assets.entities.Assets;

@Repository
public class AssetsDAOImpl implements AssetsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Assets> getAssets() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Assets").list();
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
	public boolean insertAssets(Assets a) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(a);
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
	public Assets assetsById(Integer asetId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Assets assets = session.get(Assets.class, asetId);
			return assets;
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
	public boolean deleteAssets(Integer asetId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(assetsById(asetId));
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
	public boolean updateAssets(Assets a) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(a);
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
	public List<Assets> getAssetsByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			if(name==null || name.length()==0) {
				name="%";
			}else {
				name ="%"+name+"%";
				List list = session.createQuery("from Assets where asetName like: asetName")
				.setParameter("asetName", name)
				.list();
				
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	@Override
	public List<Assets> getAssetsPagination(Integer offset, Integer maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Assets").setFirstResult(offset)
			.setMaxResults(maxResult)
			.list();
			
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
	public Long getTotalAssetsPagination() {
		// TODO Auto-generated method stub
Session openSession = sessionFactory.openSession();
		
		try {
			List list = openSession.createQuery("select count(*) from Assets").list();
			
			return (Long) list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}

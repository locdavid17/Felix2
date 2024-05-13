package assets.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assets.dao.Asset_ListDAO;
import assets.entities.Asset_List;
@Repository
public class Asset_listDAOImpl implements Asset_ListDAO{
@Autowired
private SessionFactory sessionFactory;
	@Override
	public List<Asset_List> getAsset_Lists() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Asset_List").list();
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
	public Asset_List getAsset_ListById(Integer assetID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Asset_List asset_List = session.get(Asset_List.class, assetID);
			return asset_List;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	@Override
	public List<Asset_List> getAsset_ListsByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			if(name==null || name.length()==0) {
				name="%";
			}else {
				name ="%"+name+"%";
				List list = session.createQuery("from Asset_List where assetName like: assetName")
				.setParameter("assetName", name)
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
	public boolean insertAsset_List(Asset_List a) {
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
	public boolean deleteAssets_List(Integer assetID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getAsset_ListById(assetID));
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
	public boolean updateAssets_List(Asset_List a) {
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
	public List<Asset_List> getAsset_ListsPagination(Integer offset, Integer maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Asset_List").setFirstResult(offset)
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
	public Long getTotalAsset_ListsPagination() {
		// TODO Auto-generated method stub
		Session openSession = sessionFactory.openSession();
		
		try {
			List list = openSession.createQuery("select count(*) from Asset_List").list();
			
			return (Long) list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}

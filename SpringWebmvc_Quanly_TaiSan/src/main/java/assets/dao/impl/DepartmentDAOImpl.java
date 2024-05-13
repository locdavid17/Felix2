package assets.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assets.dao.DepartmentDAO;
import assets.entities.Assets;
import assets.entities.Department;
@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
@Autowired
private SessionFactory sessionFactory;
	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		
			Session session = sessionFactory.openSession();
			try {
				List list = session.createQuery("from Department").list();
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
	public boolean insertDepartment(Department d) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(d);
			session.getTransaction().commit();;
			
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
	public Department getDepartmentById(String departmentID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Department department = session.get(Department.class, departmentID);
			return department;
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
	public boolean deleteDepartment(String departmentID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getDepartmentById(departmentID));
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
	public boolean updateDepartment(Department d) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(d);
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

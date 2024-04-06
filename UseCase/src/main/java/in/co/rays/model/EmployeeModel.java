package in.co.rays.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.dto.EmployeeDTO;

public class EmployeeModel {

	public void add(EmployeeDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
	}
	public void update(EmployeeDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();
	
	}
	
	public void delete(EmployeeDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();
	
	}
	
	public EmployeeDTO findByPk(int pk) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
          EmployeeDTO dto = (EmployeeDTO) session.get(EmployeeDTO.class, pk);
		session.close();
		return dto;
		
		
	}
	
	
	public List search(EmployeeDTO dto,int pageNo,int pageSize) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(EmployeeDTO.class);
		if(dto!=null) {
			if(dto.getName()!=null && dto.getName().length()>0) {
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
//			if(dto.getName()!=null && dto.getName().length()>0) {
//				criteria.add(Restrictions.like("model", dto.getDob()+"%"));
//			}
			if(dto.getDob() != null && dto.getDob().getDate()> 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
			}
		}
		if(pageNo>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list=criteria.list();
		session.close();
		return list;
	}

}

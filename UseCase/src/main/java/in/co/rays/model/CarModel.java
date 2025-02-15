package in.co.rays.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.dto.CarDTO;

public class CarModel {

	public void add(CarDTO dto) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		session.close();
	}
	public void update(CarDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dto);
		tx.commit();
		session.close();
	
	}
	
	public void delete(CarDTO dto) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		session.close();
	
	}
	
	public CarDTO findByPk(int pk) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
          CarDTO dto = (CarDTO) session.get(CarDTO.class, pk);
		session.close();
		return dto;
		
		
	}
	
	
	public List search(CarDTO dto,int pageNo,int pageSize) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Criteria criteria=session.createCriteria(CarDTO.class);
		if(dto!=null) {
			if(dto.getOwnerName()!=null && dto.getOwnerName().length()>0) {
				criteria.add(Restrictions.like("name", dto.getOwnerName()+"%"));
			}
//			if(dto.getName()!=null && dto.getName().length()>0) {
//				criteria.add(Restrictions.like("model", dto.getDob()+"%"));
//			}
			if(dto.getPurchaseDate() != null && dto.getPurchaseDate().getDate()> 0) {
				criteria.add(Restrictions.eq("purchaseDate", dto.getPurchaseDate()));
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

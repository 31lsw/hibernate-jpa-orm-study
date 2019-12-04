package jpastart.jpa.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

/**
 * @author S
 * 사용자 정보 조회 : 목록
 */
public class GetUserListService {
	
	private static final String q = "select u from User u order by u.name";
	
	public List<User> getAllUsers() {
		EntityManager em = EMF.createEntityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<User> query = em.createQuery(q, User.class); 
			List<User> result = query.getResultList();
			em.getTransaction().commit();
			return result;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
		
	}
}

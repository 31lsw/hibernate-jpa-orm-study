package jpastart.jpa.application;

import javax.persistence.EntityManager;

import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

/**
 * @author S
 * 사용자 정보 삭제 : 탈퇴
 */
public class WithdrawService {
	
	public void withdraw(String email) {
		
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		
		try {
			User user = em.find(User.class, email); //식별자가 email인 User 조회
			if(user == null) {
				throw new UserNotFoundException(); //존재하지 않으면 익셉션 처리
			}
			
			em.remove(user);					//EntityManager#remove() 메서드로 user삭제 
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			em.close();
		}
	}
}

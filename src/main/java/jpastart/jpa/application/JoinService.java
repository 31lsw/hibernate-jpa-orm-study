package jpastart.jpa.application;

import java.util.Optional;

import javax.persistence.EntityManager;

import jpastart.jpa.EMF;
import jpastart.reserve.model.User;


/**
 * @author S
 * 사용자 가입 기능 구현
 * 가입을 처리하는 클래스 : 이미 동일한 이메일을 가진 사용자 정보가 존재하면 DuplicatedEmailException을 발생시킴
 */
public class JoinService {
//	public void join(User user) {
	public Optional<User> join(User user) {
		
		User result = null; // 담아보자
		
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		try {
			User found = em.find(User.class, user.getEmail());
			if(found != null) {
				throw new DuplicatedEmailException();
			}
			em.persist(user);
			em.getTransaction().commit();
			result = user;
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
			throw ex;
		} finally {
			em.close();
		}
		return Optional.ofNullable(result);
	}
}

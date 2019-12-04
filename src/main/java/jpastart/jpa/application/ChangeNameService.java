package jpastart.jpa.application;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;

import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

/**
 * @author S
 * 사용자 정보 변경
 */
public class ChangeNameService {
//	public void changeName(String email, String newName) {
	public Optional<User> changeName(String email, String newName) {
		EntityManager em = EMF.createEntityManager();
		User result = null;	
		
		try {
			em.getTransaction().begin();
			User user = em.find(User.class, email);
			
			//if(user == null) throw new UserNotFoundException();
			if(!Optional.ofNullable(user).isPresent()) throw new UserNotFoundException();
			
			//user.changeName(newName);
			result = user.changeName(newName)
						.updateModifiedDate(new Date());
			
			em.getTransaction().commit();

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

package jpastart.reserve.model;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author S
 *
 */
@Entity
@Table(name = "user")
public class User {
	
	
	@Id
	private String email;
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifed_date")
	private Date modifiedDate;
	
	protected User() {
//		super();
	}
	
	public User(String email, String name, Date createDate) {
		super();
		this.email = email;
		this.name = name;
		this.createDate = createDate;
	}
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	

//	public void changeName(String newName) {
//		this.name = newName;
//	}
	public User changeName(String newName) {
		this.name = newName;
		return this;
	}
	
	public User updateModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}
	
}

package jpastart.reserve.model;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "room_info")
public class Room4 {
	
	private String number;
	private String name;
	private String desc;
	private Long dbId;

	// @Access(AccessType.FIELD)
	// - 프로퍼티 접근 타입을 기본으로 사용하고, 특정 영속 대상만 필드 접근 타입을 사용해야 하는 경우
	
	@Column(name = "id", insertable = false, updatable = false)
	@Access(AccessType.FIELD)
	public Long getDbId() {
		return dbId;
	}
	
	// 접근 타입이 필드이므로 setter 사용하지 x
//	public void setDbId(Long dbId) {
//		this.dbId = dbId;
//	}
	
	@Id
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}

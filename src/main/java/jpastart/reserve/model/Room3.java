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
public class Room3 {
	
	@Id
	private String number;
	private String name;
	@Column(name = "description")
	private String desc;

	// @Access(AccessType.PROPERTY)
	// - 기본적으로 필드 접근 방식을 사용하는 가운데, 특정 영속 대상에 대해서만 프로퍼티 접근 방식을 사용해야 하는 경우
	
	@Column(name = "id", insertable = false, updatable = false)
	@Access(AccessType.PROPERTY)
	private Long dbId;
	
	
	public Long getDbId() {
		return dbId;
	}

	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}
	
}

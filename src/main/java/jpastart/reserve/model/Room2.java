package jpastart.reserve.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "room_info")
public class Room2 {

	private String number;
	private String name;
	private String desc;
	private Long dbId;
	
	
	// 매핑을 필드에만 설정할 수 있는 것은 아님
	// 다음처럼 자바빈 방식의 프로퍼티 메서드 중 getter에 설정 가능
	
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
	
	@Column(name = "id", insertable = false, updatable = false)
	public Long getDbId() {
		return dbId;
	}

	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}
	
}

package jpastart.reserve.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


// 접근타입 : 필드

@Entity
@Table(name = "room_info")
public class Room {
	@Id
	private String number;
	private String name;
	
	// transient 키워드 또는 @Transient 애노테이션 -> 필드를 영속 대상에서 제외시킬 수 있음
	@Transient
	private long timestamp = System.currentTimeMillis();
	//transient private long timestamp = System.currentTimeMillis();
	
	// 열거 타입에 대한 기본 매핑 설정은 @Enumerated(EnumType.ORDINAL)이므로,
	// 상수 이름을 값으로 매핑하려면 @Enumerated(EnumType.STRING)를 명시적으로 설정해야 함
	@Enumerated(EnumType.STRING)
	private Grade grade;
	
	@Column(name = "description")
	private String desc;
	
	// 하이버네이트 5.2는 자바 8의 날짜/시간 타입 지원함
	private LocalDateTime createTime;
	
	// 읽기 전용 매핑 설정
	// 엔티티를 DB에 저장,변경할 때 insert,update쿼리에서 해당 값 제외함
	@Column(name = "id", insertable = false, updatable = false)
	private Long dbId;
	
}

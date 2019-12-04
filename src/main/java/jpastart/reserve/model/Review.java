package jpastart.reserve.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hotel_review")
public class Review {
	// DB 테이블에 insert를 해야 식별자를 구할 수 있을 땐 persist()를 실행하는 시점에 insert쿼리를 실행함
	// 대표적인 예가 MySQL auto_increment 칼럼 (insert를 하는 순간에 주요키 값이 결정 되잖아)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //식별자의 값을 JPA가 생성
	private Long id;
	@Column(name = "hotel_id")
	private String hotelId;
	private int rate;
	private String comment;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rating_date")
	private Date ratingDate;
	
	protected Review() {
		
	}
	
	public Review(String hotelId, int rate, String comment) {
		this.hotelId = hotelId;
		this.rate = rate;
		this.comment = comment;
	}
	
}

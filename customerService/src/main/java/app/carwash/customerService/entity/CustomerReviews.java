package app.carwash.customerService.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CustomerReviews")
public class CustomerReviews {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	public Integer custId;
	public Integer washerId;
	public Integer rating;

	public CustomerReviews() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerReviews(Integer custId, Integer washerId, Integer rating) {
		super();
		this.custId = custId;
		this.washerId = washerId;
		this.rating = rating;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getWasherId() {
		return washerId;
	}

	public void setWasherId(Integer washerId) {
		this.washerId = washerId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "CustomerReviews [custId=" + custId + ", washerId=" + washerId + ", rating=" + rating + "]";
	}

	
}

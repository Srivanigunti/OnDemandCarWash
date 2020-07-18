package app.carwash.customerService.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PaymentDetails")
public class PaymentDetails {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	public Integer id;
	public Integer orderId;
	public String status;
	public Integer amount;
	public Integer paymentTypeId;

	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentDetails(Integer id, Integer orderId, String status, Integer amount, Integer paymentTypeId) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.status = status;
		this.amount = amount;
		this.paymentTypeId = paymentTypeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	@Override
	public String toString() {
		return "PaymentDetails [id=" + id + ", orderId=" + orderId + ", status=" + status + ", amount=" + amount
				+ ", paymentTypeId=" + paymentTypeId + "]";
	}

}

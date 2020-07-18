package app.carwash.customerService.entity;
import java.util.Date;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OrderDetails")
public class Orders {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	public Integer id;
	public Integer custID;
	public Integer carID;
	public String workStatus;
	public Integer washTypeID;
	public Integer washPackageID;
	public Date orderDate;
	public Date completionDate;
	public String washLocation;

	public Orders() {
		super();
	}

	public Orders(Integer id, Integer custID, Integer carID, String workStatus, Integer washTypeID,
			Integer washPackageID, Date orderDate, Date completionDate, String washLocation) {
		super();
		this.id = id;
		this.custID = custID;
		this.carID = carID;
		this.workStatus = workStatus;
		this.washTypeID = washTypeID;
		this.washPackageID = washPackageID;
		this.orderDate = orderDate;
		this.completionDate = completionDate;
		this.washLocation = washLocation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(long l) {
		this.id = (int) l;
	}

	public Integer getCustID() {
		return custID;
	}

	public void setCustID(Integer custID) {
		this.custID = custID;
	}

	public Integer getCarID() {
		return carID;
	}

	public void setCarID(Integer carID) {
		this.carID = carID;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public Integer getWashTypeID() {
		return washTypeID;
	}

	public void setWashTypeID(Integer washTypeID) {
		this.washTypeID = washTypeID;
	}

	public Integer getWashPackageID() {
		return washPackageID;
	}

	public void setWashPackageID(Integer washPackageID) {
		this.washPackageID = washPackageID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getWashLocation() {
		return washLocation;
	}

	public void setWashLocation(String washLocation) {
		this.washLocation = washLocation;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", custID=" + custID + ", carID=" + carID + ", workStatus=" + workStatus
				+ ", washTypeID=" + washTypeID + ", washPackageID=" + washPackageID + ", orderDate=" + orderDate
				+ ", completionDate=" + completionDate + ", washLocation=" + washLocation + "]";
	}

}

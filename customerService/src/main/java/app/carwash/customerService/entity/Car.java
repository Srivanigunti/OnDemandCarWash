package app.carwash.customerService.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carDetails")
public class Car {
	@Transient
	public static final String SEQUENCE_NAME = "car_sequence";
	
	public long id;
	public String carName;
	public String carNumber;
	public String carImage;
	public String carColor;
	public String ownerName;
	public String carLocation;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(long id, String carName, String carNumber, String carImage, String carColor, String ownerName,
			String carLocation) {
		super();
		this.id = id;
		this.carName = carName;
		this.carNumber = carNumber;
		this.carImage = carImage;
		this.carColor = carColor;
		this.ownerName = ownerName;
		this.carLocation = carLocation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarImage() {
		return carImage;
	}

	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCarLocation() {
		return carLocation;
	}

	public void setCarLocation(String carLocation) {
		this.carLocation = carLocation;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carName=" + carName + ", carNumber=" + carNumber + ", carImage=" + carImage
				+ ", carColor=" + carColor + ", ownerName=" + ownerName + ", carLocation=" + carLocation + "]";
	}

	
}


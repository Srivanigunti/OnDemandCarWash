package app.carwash.customerService.entity;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "WashCar")
public class WashCar {
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	private Integer id;
	private String name;
	private Integer cost;
	private String type;
	
	
	public WashCar() {
		super();
	}

	public WashCar(Integer id, String name, Integer cost, String type) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "WashCar [id=" + id + ", name=" + name + ", cost=" + cost + ", type=" + type + "]";
	}

	
	
}

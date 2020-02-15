package code.java.manager.model;

public class Item {

	private int id;
	private String name;
	private String vehicleAply;
	private float pesoLiquido;
	private float pesoBruto;

	public Item() {

	}

	public Item(int id, String name, String vehicleAply, float pesoLiquido, float pesoBruto) {
		super();
		this.id = id;
		this.name = name;
		this.vehicleAply = vehicleAply;
		this.pesoLiquido = pesoLiquido;
		this.pesoBruto = pesoBruto;
	}

	public Item(String name, String vehicleAply, float pesoLiquido, float pesoBruto) {
		super();
		this.name = name;
		this.vehicleAply = vehicleAply;
		this.pesoLiquido = pesoLiquido;
		this.pesoBruto = pesoBruto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVehicleAply() {
		return vehicleAply;
	}

	public void setVehicleAply(String vehicleAply) {
		this.vehicleAply = vehicleAply;
	}

	public float getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(float pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public float getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(float pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

}

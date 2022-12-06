package programmersAliance.model;

import programmersAliance.conexion.BDConection;

public class MainModel {
	private personal personal;
	private Productos productos;
	private Ventas ventas;
	
	public MainModel(BDConection BD) {
		personal=new personal(BD);
		productos=new Productos(BD);
		ventas = new Ventas(BD);
	}

	public personal getPersonal() {
		return personal;
	}

	public void setPersonal(personal personal) {
		this.personal = personal;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Ventas getVentas() {
		return ventas;
	}

	public void setVentas(Ventas ventas) {
		this.ventas = ventas;
	}
	
	
}

package programmersAliance.controller;

import programmersAliance.view.*;

public class Controller {
	private static Menu m;
	private static VLogin login;
	private static Vpersonal modPersonal;
	private static VagregarEmp agregarPer;
	private static VEliDesEmp elides;
	private static VModEmp modEmp;
	private static Vproductos modProductos;
	private static VagregarProd agregarProd;
	private static VmodProducto actProducto;
	private static VdesEliProd eliProd;

	public Controller() {
		login = new VLogin();
		m = new Menu();
		modPersonal = new Vpersonal();
		agregarPer = new VagregarEmp();
		elides = new VEliDesEmp();
		modEmp = new VModEmp();
		modProductos = new Vproductos();
		agregarProd = new VagregarProd();
		actProducto = new VmodProducto();
		eliProd = new VdesEliProd();
	}
	public static void login(boolean seguir) {
		//Falta condiciones para login
		if(seguir){
			login.setVisible(false);
			m.setVisible(true);
		}
	}

	public static void PPersonal(boolean agregar, boolean vovler, boolean buscar, boolean modificar, boolean volver2, boolean eliminar, boolean descativar, boolean volver3){
		//Botón para agregar empleado
		if(agregar){

		}//Boton para buscar empleado para modificar
		if(buscar){

		}
		//Boton para modificar empelado
		if(modificar){

		}
		//Boton para eliminar empleado
		if(eliminar){

		}
		//Boton para desactivar empleado
		if(descativar){

		}
		//Botones de volver
		if(vovler){
			modEmp.setVisible(false);
			elides.setVisible(false);
			agregarPer.setVisible(false);
			modPersonal.setVisible(true);
		}if(volver2){
			modEmp.setVisible(false);
			elides.setVisible(false);
			agregarPer.setVisible(false);
			modPersonal.setVisible(true);
		}if(volver3){
			modEmp.setVisible(false);
			elides.setVisible(false);
			agregarPer.setVisible(false);
			modPersonal.setVisible(true);
		}
	}

	public static void PProductos(boolean agregar, boolean volver, boolean buscar, boolean modificar, boolean volver2, boolean eliminar, boolean descativar, boolean volver3){
		//Botón para agregar producto
		if(agregar){

		}//Boton para buscar producto para modificar
		if(buscar){

		}
		//Boton para modificar producto
		if(modificar){
		}
		//Boton para eliminar producto
		if(eliminar){

		}
		//Boton para desactivar producto
		if(descativar){

		}
		//Botones de volver
		if(volver){
			eliProd.setVisible(false);
			actProducto.setVisible(false);
			agregarProd.setVisible(false);
			modProductos.setVisible(true);
		}if(volver2){
			eliProd.setVisible(false);
			actProducto.setVisible(false);
			agregarProd.setVisible(false);
			modProductos.setVisible(true);
		}if(volver3){
			eliProd.setVisible(false);
			actProducto.setVisible(false);
			agregarProd.setVisible(false);
			modProductos.setVisible(true);
		}
	}

	//No hay botones que hagan funcionalidades
	public static void productos(boolean agregar, boolean mod, boolean eli, boolean volver){
		if(agregar){
			modProductos.setVisible(false);
			actProducto.setVisible(false);
			eliProd.setVisible(false);
			agregarProd.setVisible(true);
		}if(mod){
			modProductos.setVisible(false);
			actProducto.setVisible(true);
			eliProd.setVisible(false);
			agregarProd.setVisible(false);
		}if(eli){
			modProductos.setVisible(false);
			actProducto.setVisible(false);
			eliProd.setVisible(true);
			agregarProd.setVisible(false);
		}if(volver){
			actProducto.setVisible(false);
			eliProd.setVisible(false);
			agregarProd.setVisible(false);
			modProductos.setVisible(false);
			m.setVisible(true);
		}
	}//No hay botones que hagan funcionalidades
	public static void menu(boolean emp, boolean prod, boolean vent, boolean volver, boolean salir){
		if(volver){
			login.setVisible(true);
			m.setVisible(false);
		}if(emp){
			modPersonal.setVisible(true);
			m.setVisible(false);
		}if(prod){
			modProductos.setVisible(true);
			m.setVisible(false);
		}if(vent){
			modPersonal.setVisible(true);
			m.setVisible(false);
		}if(salir){
			System.exit(0);
		}
	}
	//No hay botones que hagan funcionalidades
	public static void personal(boolean agregar, boolean mod, boolean eli, boolean volver){
		if(agregar){
			modPersonal.setVisible(false);
			agregarPer.setVisible(true);
		}if(mod){
			modPersonal.setVisible(false);
			modEmp.setVisible(true);
		}if(eli){
			modPersonal.setVisible(false);
			elides.setVisible(true);
		}if(volver){
			modPersonal.setVisible(false);
			m.setVisible(true);
		}
	}
}





















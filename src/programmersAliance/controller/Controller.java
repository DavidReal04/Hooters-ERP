package programmersAliance.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import programmersAliance.conexion.BDConection;
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
	private static Vventas modVentas;
	private static BDConection conexion;
	private static programmersAliance.model.MainModel modelo;

	public Controller() {
		conexion = new BDConection();
		modelo=new programmersAliance.model.MainModel(conexion);
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
		modVentas = new Vventas();
		ArrayList<String> id = modelo.getVentas().idEmpleado();
		for(int i=0;i<id.size();i++) {
			modVentas.getIdEmpleado().addItem(id.get(i));
		}
		
		ArrayList<String> nombreP = modelo.getVentas().nProducto();
		for(int i=0;i<nombreP.size();i++) {
			modVentas.getProductoVentas().addItem(nombreP.get(i));
		}
		
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
			if(modelo.getPersonal().agregarPersonal(agregarPer.getArea()[0].getText(), agregarPer.getAgDoc().getSelectedItem().toString(), agregarPer.getArea()[1].getText(), agregarPer.getArea()[3].getText(), new SimpleDateFormat("yyyy-MM-dd").format(agregarPer.getFecha().getDate()), agregarPer.getEstadoCivil().getSelectedItem().toString(), agregarPer.getAgCargo().getSelectedItem().toString(), agregarPer.getArea()[2].getText())) {
				modVentas.getIdEmpleado().addItem(agregarPer.getArea()[0].getText());
				JOptionPane.showMessageDialog(null,"Se ha Guardado Exitosamente");
			}else {
				JOptionPane.showMessageDialog(null,"Error al Guardar");
			}
		}
		//Boton para buscar empleado para modificar
		if(buscar){
			Object[] empleado = modelo.getPersonal().buscarPersona(modEmp.getArea()[0].getText());
			
			if((empleado[0])!=null) {
				modEmp.setModelo((DefaultTableModel) modEmp.getTable().getModel());
				limpiarModPersonal();
				modEmp.getModelo().addRow(empleado);
				modEmp.getArea()[1].setText(empleado[0].toString());
				modEmp.getArea()[1].setEnabled(false);
				int doc = Integer.parseInt(empleado[1].toString().split("-")[0]);
				modEmp.getEditDoc().setSelectedIndex(doc);
				modEmp.getEditDoc().setEnabled(true);
				modEmp.getArea()[2].setText(empleado[2].toString());
				modEmp.getArea()[2].setEnabled(true);
				modEmp.getArea()[3].setText(empleado[3].toString());
				modEmp.getArea()[3].setEnabled(true);
				try {
					modEmp.getDateChooser().setDate(new SimpleDateFormat("yyyy-MM-dd").parse(empleado[4].toString()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				modEmp.getDateChooser().setEnabled(true);
				int eci = Integer.parseInt(empleado[5].toString().split("-")[0]);
				modEmp.getEdEstadoCivil().setSelectedIndex(eci);
				modEmp.getEdEstadoCivil().setEnabled(true);
				int eca = Integer.parseInt(empleado[7].toString().split("-")[0]);
				modEmp.getEdCargo().setSelectedIndex(eca);
				modEmp.getEdCargo().setEnabled(true);
				modEmp.getArea()[4].setText(empleado[6].toString());
				modEmp.getArea()[4].setEnabled(true);
				modEmp.getBotones()[1].setEnabled(true);
			}else {
				limpiarModPersonal();
				JOptionPane.showMessageDialog(null,"No se a encontrado");
			}
			
		}
		//Boton para modificar empelado
		if(modificar){
			if(modelo.getPersonal().actuaizarPersonal( modEmp.getArea()[1].getText(), modEmp.getEditDoc().getSelectedItem().toString(), modEmp.getArea()[2].getText(), modEmp.getArea()[3].getText(), new SimpleDateFormat("yyyy-MM-dd").format(modEmp.getDateChooser().getDate()), modEmp.getEdEstadoCivil().getSelectedItem().toString(), modEmp.getEdCargo().getSelectedItem().toString(), modEmp.getArea()[4].getText())) {
				JOptionPane.showMessageDialog(null,"Actualizado Exitosamente");
			}else {
				JOptionPane.showMessageDialog(null,"No se a Actualizado");
			}
		}
		//Boton para eliminar empleado
		if(eliminar){
			if(modelo.getPersonal().EliminarPersonal(elides.getArea()[0].getText())) {
				JOptionPane.showMessageDialog(null,"Eliminado Exitosamente");
			}else {
				JOptionPane.showMessageDialog(null,"Error al Eliminar");
			}
		}
		//Boton para desactivar empleado
		if(descativar){
			if(modelo.getPersonal().desActivarPersonal(elides.getArea()[0].getText())) {
				JOptionPane.showMessageDialog(null,"Desactivado Exitosamente");
			}else {
				JOptionPane.showMessageDialog(null,"Error al Desactivar");
			}
		}
		//Botones de volver
		if(vovler){
			actualizarTbl_E();
			
			agregarPer.getArea()[0].setText("");
			agregarPer.getAgDoc().setSelectedIndex(0);
			agregarPer.getArea()[1].setText("");
			agregarPer.getArea()[3].setText("");
			agregarPer.getEstadoCivil().setSelectedIndex(0);
			agregarPer.getAgCargo().setSelectedIndex(0);
			agregarPer.getArea()[2].setText("");
			
			modEmp.setVisible(false);
			elides.setVisible(false);
			agregarPer.setVisible(false);
			modPersonal.setVisible(true);
		}if(volver2){
			limpiarModPersonal();
			actualizarTbl_E();
			modEmp.setVisible(false);
			elides.setVisible(false);
			agregarPer.setVisible(false);
			modPersonal.setVisible(true);
		}if(volver3){
			actualizarTbl_E();
			
			elides.getArea()[0].setText("");
			modEmp.setVisible(false);
			elides.setVisible(false);
			agregarPer.setVisible(false);
			modPersonal.setVisible(true);
		}
	}

	public static void actualizarTbl_E() {
 		for(int i=0;i<modPersonal.getArea()[0].getRowCount();i++) {
		modPersonal.getModelo().removeRow(i);
		i=i-1;
		}
		modPersonal.setModelo((DefaultTableModel) modPersonal.getArea()[0].getModel());
		modPersonal.getArea()[0].setModel(modelo.getPersonal().listarPersona(modPersonal.getModelo()));
 	}
	
	public static void limpiarModPersonal() {
				
		for(int i=0;i<modEmp.getTable().getRowCount();i++) {
			modEmp.getModelo().removeRow(i);
			i=i-1;
		}
		modEmp.getArea()[0].setText("");
		modEmp.getArea()[1].setText("");
		modEmp.getArea()[1].setEnabled(false);
		modEmp.getEditDoc().setSelectedIndex(0);
		modEmp.getEditDoc().setEnabled(false);
		modEmp.getArea()[2].setText("");
		modEmp.getArea()[2].setEnabled(false);
		modEmp.getArea()[3].setText("");
		modEmp.getArea()[3].setEnabled(false);
		modEmp.getDateChooser().setEnabled(false);
		modEmp.getEdEstadoCivil().setSelectedIndex(0);
		modEmp.getEdEstadoCivil().setEnabled(false);
		modEmp.getEdCargo().setSelectedIndex(0);
		modEmp.getEdCargo().setEnabled(false);
		modEmp.getArea()[4].setText("");
		modEmp.getArea()[4].setEnabled(false);
		modEmp.getBotones()[1].setEnabled(false);
	}
	
 	public static void PProductos(boolean agregar, boolean volver, boolean buscar, boolean modificar, boolean volver2, boolean eliminar, boolean descativar, boolean volver3){
		//Botón para agregar producto
		if(agregar){
			if(modelo.getProductos().agregarProductos(agregarProd.getArea()[0].getText(),agregarProd.getArea()[1].getText() , agregarProd.getArea()[3].getText(),agregarProd.getArea()[2].getText())) {
				modVentas.getProductoVentas().addItem(agregarProd.getArea()[1].getText());
				JOptionPane.showMessageDialog(null,"Se ha Guardado Exitosamente");
			}else {
				JOptionPane.showMessageDialog(null,"Error al Guardar");
			}
		}//Boton para buscar producto para modificar
		if(buscar){
			Object[] empleado = modelo.getProductos().buscarProductos(actProducto.getArea()[0].getText());
			if(empleado[0]!=null) {
				
				actProducto.setModel((DefaultTableModel) actProducto.getTable().getModel());
				limpiarModProductosl();
				actProducto.getModel().addRow(empleado);
				actProducto.getArea()[1].setText(empleado[0].toString());
				actProducto.getArea()[1].setEnabled(false);
				actProducto.getArea()[2].setText(empleado[1].toString());
				actProducto.getArea()[2].setEnabled(true);
				actProducto.getArea()[3].setText(empleado[2].toString());
				actProducto.getArea()[3].setEnabled(true);
				actProducto.getArea()[4].setText(empleado[3].toString());
				actProducto.getArea()[4].setEnabled(true);
				actProducto.getBotones()[1].setEnabled(true);
			}else {
				JOptionPane.showMessageDialog(null,"No se ha encontrado");
				limpiarModProductosl();
			}
		}
		//Boton para modificar producto
		if(modificar){
			
			if(modelo.getProductos().actuaizarProductos( actProducto.getArea()[1].getText(), actProducto.getArea()[2].getText(), actProducto.getArea()[3].getText(), actProducto.getArea()[4].getText())) {
				JOptionPane.showMessageDialog(null,"Actualizado Exitosamente");
			}else {
				JOptionPane.showMessageDialog(null,"No se ha Actualizado");
			}
 		}
		//Boton para eliminar producto
		if(eliminar){
			if(modelo.getProductos().EliminarProductos(eliProd.getArea()[0].getText())) {
				JOptionPane.showMessageDialog(null,"Eliminado Exitosamente");
			}else {
				JOptionPane.showMessageDialog(null,"Error al Eliminar");
			}
		}
		//Boton para desactivar producto
		if(descativar){
			if(modelo.getProductos().desActivarProductos(eliProd.getArea()[0].getText())) {
				JOptionPane.showMessageDialog(null,"Desactivado Exitosamente");
			}else {
				JOptionPane.showMessageDialog(null,"Error al Desactivar");
			}
		}
		//Botones de volver
		if(volver){
			actualizarTbl_P();
			agregarProd.getArea()[0].setText("");
			agregarProd.getArea()[1].setText("");
			agregarProd.getArea()[3].setText("");
			agregarProd.getArea()[2].setText("");
			
			eliProd.setVisible(false);
			actProducto.setVisible(false);
			agregarProd.setVisible(false);
			modProductos.setVisible(true);
		}if(volver2){
			
			actualizarTbl_P();
			limpiarModProductosl();
			eliProd.setVisible(false);
			actProducto.setVisible(false);
			agregarProd.setVisible(false);
			modProductos.setVisible(true);
		}if(volver3){
			actualizarTbl_P();
			eliProd.getArea()[0].setText("");
			eliProd.setVisible(false);
			actProducto.setVisible(false);
			agregarProd.setVisible(false);
			modProductos.setVisible(true);
		}
	}

 	public static void actualizarTbl_P() {
 		for(int i=0;i<modProductos.getArea()[0].getRowCount();i++) {
 			modProductos.getModelo().removeRow(i);
		i=i-1;
		}
 		modProductos.setModelo((DefaultTableModel) modProductos.getArea()[0].getModel());
		modProductos.getArea()[0].setModel(modelo.getProductos().listarProductos(modProductos.getModelo()));
 	}
 	
 	public static void limpiarModProductosl() {
				
		for(int i=0;i<actProducto.getTable().getRowCount();i++) {
			actProducto.getModel().removeRow(i);
			i=i-1;
		}
		actProducto.getArea()[0].setText("");
		actProducto.getArea()[1].setText("");
		actProducto.getArea()[1].setEnabled(false);
		actProducto.getArea()[2].setText("");
		actProducto.getArea()[2].setEnabled(false);
		actProducto.getArea()[3].setText("");
		actProducto.getArea()[3].setEnabled(false);
		actProducto.getArea()[4].setText("");
		actProducto.getArea()[4].setEnabled(false);
		actProducto.getBotones()[1].setEnabled(false);
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
			actualizarTbl_E();
			modPersonal.setVisible(true);
			m.setVisible(false);
			
		}if(prod){
			actualizarTbl_P();
			modProductos.setVisible(true);
			m.setVisible(false);
		}if(vent){
			
			modVentas.setVisible(true);
			m.setVisible(false);
		}if(salir){
			System.exit(0);
		}
	}
	//No hay botones que hagan funcionalidades
	public static void personal(boolean agregar, boolean mod, boolean eli, boolean volver,boolean volver1){
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
		}if(volver1){
			for(int i=0;i<modVentas.getTable().getRowCount();i++) {
				modVentas.getModelo().removeRow(i);
				i=i-1;
			}
			modVentas.setVisible(false);
			modProductos.setVisible(false);
			modPersonal.setVisible(false);
			m.setVisible(true);
		}
	}
	
	public static void ventas(boolean agregar, boolean cobrar) {
		if(agregar) {
	 		modVentas.setModelo((DefaultTableModel) modVentas.getTable().getModel());
	 		Object[] empleado = modelo.getVentas().añadirProducto(modVentas.getProductoVentas().getSelectedItem().toString(),modVentas.getArea()[1].getText());
			if((empleado !=null)){
				modVentas.getModelo().addRow(empleado);
	 		}else {
	 			JOptionPane.showMessageDialog(null,"Error");
	 		}
		}
		if(cobrar) {
			if(modelo.getVentas().guardarFactura(modVentas.getIdEmpleado().getSelectedItem().toString())) {
				if(modelo.getVentas().guardarDetalle(modelo.getVentas().obtenerFactura())) {
					JOptionPane.showMessageDialog(null,"Subtotal : "+modelo.getVentas().getS()+"\nIva : "+modelo.getVentas().getI()+"\nTotal : "+modelo.getVentas().getT());
					modelo.getVentas().getId_cantidad_subtotal().clear();					
					modelo.getVentas().setS(0);
					modelo.getVentas().setT(0);
					for(int i=0;i<modVentas.getTable().getRowCount();i++) {
						modVentas.getModelo().removeRow(i);
						i=i-1;
					}					
				}else {
					JOptionPane.showMessageDialog(null,"Error al Detalle");
				}
			}else {
				JOptionPane.showMessageDialog(null,"Error al Facturar");
			}
		}
	}
}





















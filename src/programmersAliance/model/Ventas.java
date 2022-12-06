package programmersAliance.model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import programmersAliance.conexion.BDConection;

public class Ventas {

	private Connection con;
	private BDConection BD;
	private Statement st;
	private ResultSet rs;
	private ArrayList<String> id_cantidad_subtotal = new ArrayList<>();
	private int s;
	private double i;
	private int t;
	
	 public Ventas(BDConection BD) {
		this.BD=BD;
	}
	 
	 public ArrayList<String> idEmpleado(){
		 ArrayList<String> id = new ArrayList<>();
		 try {
			 String sql = "SELECT Identificacion FROM empleados;";
			 con=BD.getConnection();
			 st=con.createStatement();
	         rs=st.executeQuery(sql);
	         while(rs.next()) {
	        	 id.add(rs.getString("Identificacion"));
	         }
	         return id;
		 }catch(Exception e) {
			 return null;
		 }
	 }
	 
	 public ArrayList<String> nProducto(){
		 ArrayList<String> id = new ArrayList<>();
		 try {
			 String sql = "SELECT Nombre FROM productos;";
			 con=BD.getConnection();
			 st=con.createStatement();
	         rs=st.executeQuery(sql);
	         while(rs.next()) {
	        	 id.add(rs.getString("Nombre"));
	         }
	         return id;
		 }catch(Exception e) {
			 return null;
		 }
	 }
	 
	 public Object[] añadirProducto(String nombre,String cantidad) {
	     try {
	    	 int c=Integer.parseInt(cantidad);
	    	 String sql="select idProductos, Nombre,Precio from productos WHERE Nombre = '"+nombre+"';";
	    	 con=BD.getConnection();
	    	 st=con.createStatement();
	    	 rs=st.executeQuery(sql);
	    	 Object[]dpro= new Object[4];
	    	 String detalle="";
	    	 while(rs.next()) {
	    		 detalle=rs.getString("idProductos")+"/"+c+"/"+rs.getInt("Precio")*c;
	    		 dpro[0]=rs.getString("Nombre");
	    		 dpro[1]=rs.getInt("Precio");
	    		 dpro[2]=cantidad;
	    		 dpro[3]=rs.getInt("Precio")*c;
	    	 }
	    	 id_cantidad_subtotal.add(detalle);
	    	 return dpro;
	     }catch(Exception e) {
	    	 return null;
	     }
	 }
	 
	 public boolean guardarFactura(String idE) {
		 if(!idE.equals("Seleccione")) {
			 try {
				  s=0;
				 for(int i=0;i<id_cantidad_subtotal.size();i++) {
					 s=s+Integer.parseInt(id_cantidad_subtotal.get(i).split("/")[2]);
				 }
				  i = 0.19;
				  t = s+(int)(s*i);
				 String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				 String sql="INSERT INTO `facturas`(`Id_Empleado`,`Fecha_Fac`,`Subtotal`,`Iva`,`Total`)VALUES('"+idE+"','"+date+"',"+s+","+i+","+t+");";
				 con=BD.getConnection();
		         st=con.createStatement();
		         st.execute(sql);
		         return true;
			 }catch(Exception e) {
				 System.out.println(e);
				 return false;
			 }
		 }else {
			 return false;
		 }
		 
	 }
	 
	 public boolean guardarDetalle(int id) {
		 try {
			 for(int i =0;i<id_cantidad_subtotal.size();i++) {
				 String producto = id_cantidad_subtotal.get(i).split("/")[0];
				 String Cantidad = id_cantidad_subtotal.get(i).split("/")[1];
				 String subtotal = id_cantidad_subtotal.get(i).split("/")[2];
				 String sql = "INSERT INTO `detalle_factura`(`Id_Factura`,`idProductos`,`Cantidad`,`Subtotal`)VALUES("+id+",'"+producto+"',"+Cantidad+","+subtotal+");";
				 con=BD.getConnection();
		         st=con.createStatement();
		         st.execute(sql);
			 }
			 return true;
		 }catch(Exception e) {
			 System.out.println(e);
			 return false;
		 }
	 }
	 
	 public int obtenerFactura() {
		 int count=0;
		 try {
			 String sql="SELECT MAX(id_Factura)AS num FROM facturas;";
			 con=BD.getConnection();
	    	 st=con.createStatement();
	    	 rs=st.executeQuery(sql);
	    	 while(rs.next()) {
	    		 count = rs.getInt("num");
	    	 }
	    	 return count;
		 }catch(Exception e) {
			 return -1;
		 }
		 
	 }

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public BDConection getBD() {
		return BD;
	}

	public void setBD(BDConection bD) {
		BD = bD;
	}

	public Statement getSt() {
		return st;
	}

	public void setSt(Statement st) {
		this.st = st;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public ArrayList<String> getId_cantidad_subtotal() {
		return id_cantidad_subtotal;
	}

	public void setId_cantidad_subtotal(ArrayList<String> id_cantidad_subtotal) {
		this.id_cantidad_subtotal = id_cantidad_subtotal;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public double getI() {
		return i;
	}

	public void setI(double i) {
		this.i = i;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}
	 
}

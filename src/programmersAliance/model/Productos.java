package programmersAliance.model;

import programmersAliance.conexion.BDConection;
import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class Productos {

	private Connection con;
	private BDConection BD;
	private Statement st;
	private ResultSet rs;
	
	public Productos(BDConection BD) {
		this.BD=BD;
	}
	
	public boolean agregarProductos(String id,String Nombre,String Descripcion,String Precio) {
		boolean flag=false;
		try {
			int p = Integer.parseInt(Precio);
			if(id.equals("") ||  Nombre.equals("") || Descripcion.equals("") || Precio.equals("")) {
				flag=false;
			}else {
				String sql ="INSERT INTO `productos`(`idProductos`,`Nombre`,`Descripcion`,`Precio`,Estado)VALUES('"+id+"','"+Nombre+"','"+Descripcion+"',"+Precio+",'ACTIVO');";
				con=BD.getConnection();
				st=con.createStatement();
				st.execute(sql);
				flag=true;
			}
		}catch(Exception e) {
			flag=false;
		}
		
		return flag;
	}
	
	public Object[] buscarProductos(String id) {
		try {
			String sql="SELECT * FROM productos WHERE idProductos = '"+id+"';";
			con=BD.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(sql);
			Object[] empleado = new Object[5];
			while(rs.next()) {
				empleado[0]=rs.getString("idProductos");
				empleado[1]=rs.getString("Nombre");
				empleado[2]=rs.getString("Descripcion");
				empleado[3]=rs.getString("Precio");
				empleado[4]=rs.getString("Estado");
			}
			return empleado;
		}catch(Exception e) {
			return null;
		}	
	}
	
	public boolean actuaizarProductos(String id,String Nombre,String Descripcion,String Precio) {
		boolean flag=false;
		try {
			int p = Integer.parseInt(Precio);
			if(id.equals("") || Nombre.equals("") || Descripcion.equals("") || Precio.equals("")) {
				flag=false;
			}else {
				String sql ="UPDATE `productos` SET `idProductos` = '"+id+"', `Nombre` = '"+Nombre+"', `Descripcion` = '"+Descripcion+"',`Precio` = "+Precio+" WHERE `idProductos` = '"+id+"';";
				con=BD.getConnection();
				st=con.createStatement();
				st.execute(sql);
				flag=true;
			}
		}catch(Exception e) {
			flag=false;
		}
		
		return flag;
	}
	
	public boolean desActivarProductos(String id) {
		boolean flag=false;
		try {
			if(id.equals("")) {
				flag=false;
			}else {
				String sql ="UPDATE `productos` SET `Estado` = 'DESACTIVADO' WHERE `idProductos` = '"+id+"';";
				con=BD.getConnection();
				st=con.createStatement();
				st.execute(sql);
				flag=true;
			}
		}catch(Exception e) {
			flag=false;
		}
		
		return flag;
	}
	
	public boolean EliminarProductos(String id) {
		boolean flag=false;
		try {
			if(id.equals("")) {
				flag=false;
			}else {
				String sql ="DELETE FROM `productos` WHERE `idProductos` = '"+id+"';";
				con=BD.getConnection();
				st=con.createStatement();
				st.execute(sql);
				flag=true;
			}
		}catch(Exception e) {
			flag=false;
		}
		
		return flag;
	}
	
	public DefaultTableModel listarProductos(DefaultTableModel modelo) {
		try {
			String sql="SELECT * FROM productos;";
			con=BD.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(sql);
			Object[] empleado = new Object[5];
			while(rs.next()) {
				empleado[0]=rs.getString("idProductos");
				empleado[1]=rs.getString("Nombre");
				empleado[2]=rs.getString("Descripcion");
				empleado[3]=rs.getString("Precio");
				empleado[4]=rs.getString("Estado");
				modelo.addRow(empleado);
			}

			return modelo;
		}catch(Exception e) {
			return null;
		}	
	}
}

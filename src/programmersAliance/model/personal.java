package programmersAliance.model;

import programmersAliance.conexion.BDConection;
import java.sql.*;

import javax.swing.table.DefaultTableModel;

public class personal {
	
	private Connection con;
	private BDConection BD;
	private Statement st;
	private ResultSet rs;
	
	public personal(BDConection BD) {
		this.BD=BD;
	}
	
	public boolean agregarPersonal(String cedula, String tpo_doc,String Nombre,String Apellidos,String fecha, String Ecivil, String cargo,String Numero) {
		boolean flag=false;
		try {
			if(cedula.equals("") || tpo_doc.equals("Tipo documento") || Nombre.equals("") || Apellidos.equals("") || fecha.equals("") || Ecivil.equals("Estado civil") || cargo.equals("Cargo") || Numero.equals("")) {
				flag=false;
			}else {
				String sql ="INSERT INTO `empleados` (`Identificacion`,`Tpo_Doc`,`Nombres`,`Apellidos`,`Fecha_na`,`Estado_Civil`,`Telefono`,`Cargo`,`Estado`) VALUES ('"+cedula+"','"+tpo_doc+"','"+Nombre+"','"+Apellidos+"','"+fecha+"','"+Ecivil+"','"+Numero+"','"+cargo+"','ACTIVO');";
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
	
	public Object[] buscarPersona(String cedula) {
		try {
			String sql="SELECT * FROM empleados WHERE Identificacion = '"+cedula+"';";
			con=BD.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(sql);
			Object[] empleado = new Object[9];
			while(rs.next()) {
				empleado[0]=rs.getString("Identificacion");
				empleado[1]=rs.getString("Tpo_Doc");
				empleado[2]=rs.getString("Nombres");
				empleado[3]=rs.getString("Apellidos");
				empleado[4]=rs.getString("Fecha_na");
				empleado[5]=rs.getString("Estado_Civil");
				empleado[6]=rs.getString("Telefono");
				empleado[7]=rs.getString("Cargo");
				empleado[8]=rs.getString("Estado");
			}
			return empleado;
		}catch(Exception e) {
			return null;
		}	
	}
	
	public boolean actuaizarPersonal(String cedula, String tpo_doc,String Nombre,String Apellidos,String fecha, String Ecivil, String cargo,String Numero) {
		boolean flag=false;
		try {
			if(cedula.equals("") || tpo_doc.equals("Tipo documento") || Nombre.equals("") || Apellidos.equals("") || fecha.equals("") || Ecivil.equals("Estado civil") || cargo.equals("Cargo") || Numero.equals("")) {
				flag=false;
			}else {
				String sql ="UPDATE `empleados` SET `Identificacion` = '"+cedula+"',`Tpo_Doc` = '"+tpo_doc+"',`Nombres` = '"+Nombre+"',`Apellidos` = '"+Apellidos+"',`Fecha_na` = '"+fecha+"',`Estado_Civil` = '"+Ecivil+"',`Telefono` = '"+Numero+"',`Cargo` = '"+cargo+"' WHERE `Identificacion` = '"+cedula+"';";
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
	
	public boolean desActivarPersonal(String cedula) {
		boolean flag=false;
		try {
			if(cedula.equals("")) {
				flag=false;
			}else {
				String sql ="UPDATE `empleados` SET `Estado` = 'DESACTIVADO' WHERE `Identificacion` = '"+cedula+"';";
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
	
	public boolean EliminarPersonal(String cedula) {
		boolean flag=false;
		try {
			if(cedula.equals("")) {
				flag=false;
			}else {
				String sql ="DELETE FROM `empleados` WHERE `Identificacion` = '"+cedula+"';";
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
	
	public DefaultTableModel listarPersona(DefaultTableModel modelo) {
		try {
			String sql="SELECT * FROM empleados;";
			con=BD.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(sql);
			Object[] empleado = new Object[9];
			while(rs.next()) {
				empleado[0]=rs.getString("Identificacion");
				empleado[1]=rs.getString("Tpo_Doc");
				empleado[2]=rs.getString("Nombres");
				empleado[3]=rs.getString("Apellidos");
				empleado[4]=rs.getString("Fecha_na");
				empleado[5]=rs.getString("Estado_Civil");
				empleado[6]=rs.getString("Telefono");
				empleado[7]=rs.getString("Cargo");
				empleado[8]=rs.getString("Estado");
				modelo.addRow(empleado);
			}
			return modelo;
		}catch(Exception e) {
			return null;
		}	
	}
}

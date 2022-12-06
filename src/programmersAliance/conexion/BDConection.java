package programmersAliance.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConection {

	
	Connection connection = null;

	/** Constructor */
	public BDConection() {
		try {
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			// obtenemos la conexi�n
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hooters","root","0000");

			if (connection != null) {
				//System.out.println("Conexión a base de datos");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Permite retornar la conexión */
	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}
}

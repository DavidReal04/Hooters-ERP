package programmersAliance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import programmersAliance.conexion.BDConection;
import programmersAliance.view.VagregarProd;
import programmersAliance.view.VdesEliProd;
import programmersAliance.view.VmodProducto;
import programmersAliance.view.Vventas;

class VentasTest {

	private MainModel modelo;
	private Vventas modVentas; 	

	public VentasTest() {
		modelo = new MainModel(new BDConection());
		modVentas = new Vventas();
	}

	@Test
	void testAgregar() {		
		modelo.getVentas().añadirProducto("Ribs", "3");
		if(modelo.getVentas().guardarFactura("1")) {			
		assertEquals(true, modelo.getVentas().guardarDetalle(modelo.getVentas().obtenerFactura()));
		}

	}	

}

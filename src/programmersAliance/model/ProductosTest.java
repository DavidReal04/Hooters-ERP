package programmersAliance.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import programmersAliance.conexion.BDConection;
import programmersAliance.view.VagregarProd;
import programmersAliance.view.VdesEliProd;
import programmersAliance.view.VmodProducto;

class ProductosTest {
	
	private MainModel modelo;
	private VagregarProd agregarProd; 
	private VmodProducto actProducto;
	private VdesEliProd eliProd;

	public ProductosTest() {
		modelo = new MainModel(new BDConection());
		actProducto = new VmodProducto();
		agregarProd = new VagregarProd();
		eliProd = new VdesEliProd();
	}

	@Test
	void testAgregar() {		
		agregarProd.getArea()[0].setText("1");			
		agregarProd.getArea()[1].setText("Ribs");
		agregarProd.getArea()[3].setText("300g de costillas, marinadas, adobadas y ahumadas por 6 horas, para luego bañarse en la salsa de elección por el cliente.");									
		agregarProd.getArea()[2].setText("49900");
		Boolean resul = modelo.getProductos().agregarProductos(agregarProd.getArea()[0].getText(),agregarProd.getArea()[1].getText() , agregarProd.getArea()[3].getText(),agregarProd.getArea()[2].getText());
		assertEquals(true, resul);			
	}
	
	@Test
	void testModificar() {
		actProducto.getArea()[1].setText("1");
		actProducto.getArea()[2].setText("Ribs");
		actProducto.getArea()[3].setText("300g de costillas, marinadas, adobadas y ahumadas por 6 horas, para luego bañarse en la salsa de elección por el cliente.");
		actProducto.getArea()[4].setText("55900");
		Boolean resul = modelo.getProductos().actuaizarProductos( actProducto.getArea()[1].getText(), actProducto.getArea()[2].getText(), actProducto.getArea()[3].getText(), actProducto.getArea()[4].getText());
		assertEquals(true, resul);		
	}
	
	@Test
	void testEliminar() {		
		eliProd.getArea()[0].setText("1");
		boolean eliminado = modelo.getProductos().EliminarProductos(eliProd.getArea()[0].getText());
		assertEquals(true, eliminado);
	}

}

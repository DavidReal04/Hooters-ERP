package programmersAliance.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import programmersAliance.conexion.BDConection;
import programmersAliance.view.VModEmp;
import programmersAliance.view.VagregarEmp;

class personalTest {
		
	private MainModel modelo;
	private VagregarEmp agregarPer; 
	private VModEmp modEmp;
	private VModEmp elides;
		
	public personalTest() {
		modelo = new MainModel(new BDConection());
		modEmp = new VModEmp();
		agregarPer = new VagregarEmp();
		elides = new VModEmp();
	}

	@Test
	void testAgregar() {		
		try {
			agregarPer.getArea()[0].setText("1193374637");
			agregarPer.getAgDoc().setSelectedItem("2-CC");
			agregarPer.getArea()[1].setText("David");
			agregarPer.getArea()[3].setText("Real");
			agregarPer.getFecha().setDate((Date) new SimpleDateFormat("YYYY-mm-dd").parse("2022-12-06"));
			agregarPer.getEstadoCivil().setSelectedItem("1-Soltero");
			agregarPer.getAgCargo().setSelectedItem("3-Chef ejecutivo");
			agregarPer.getArea()[2].setText("3057116461");
			Boolean resul = modelo.getPersonal().agregarPersonal(agregarPer.getArea()[0].getText(), agregarPer.getAgDoc().getSelectedItem().toString(), agregarPer.getArea()[1].getText(), agregarPer.getArea()[3].getText(), new SimpleDateFormat("yyyy-MM-dd").format(agregarPer.getFecha().getDate()), agregarPer.getEstadoCivil().getSelectedItem().toString(), agregarPer.getAgCargo().getSelectedItem().toString(), agregarPer.getArea()[2].getText());
			assertEquals(true, resul);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Excepción generada");			
			
		}
		
	}
	
	@Test
	void testModificar() {
		try {
			modEmp.getArea()[1].setText("1193374637");
			modEmp.getEditDoc().setSelectedItem("2-CC");
			modEmp.getArea()[2].setText("David");
			modEmp.getArea()[4].setText("Real");
			modEmp.getDateChooser().setDate((Date) new SimpleDateFormat("YYYY-mm-dd").parse("2001-11-04"));
			modEmp.getEdEstadoCivil().setSelectedItem("1-Soltero");
			modEmp.getEdCargo().setSelectedItem("3-Chef ejecutivo");
			modEmp.getArea()[3].setText("3057116461");
			Boolean resul = modelo.getPersonal().actuaizarPersonal(modEmp.getArea()[1].getText(), modEmp.getEditDoc().getSelectedItem().toString(), modEmp.getArea()[2].getText(), modEmp.getArea()[3].getText(), new SimpleDateFormat("yyyy-MM-dd").format(modEmp.getDateChooser().getDate()), modEmp.getEdEstadoCivil().getSelectedItem().toString(), modEmp.getEdCargo().getSelectedItem().toString(), modEmp.getArea()[4].getText());
			assertEquals(true, resul);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Excepción generada");	
		}
	}
	
	@Test
	void testEliminar() {		
		elides.getArea()[0].setText("1193374637");
		boolean eliminado = modelo.getPersonal().EliminarPersonal(elides.getArea()[0].getText());
		assertEquals(true, eliminado);
	}

}

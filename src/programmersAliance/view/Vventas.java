package programmersAliance.view;

import programmersAliance.controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vventas  extends JFrame {
    private JButton[] botones = new JButton[3];
    private JTable table = new JTable();
    private JLabel[] texto = new JLabel[12];
    private JTextArea[] area = new JTextArea[4];
    private JTextField pane = new JTextField();
    private JComboBox<String> productoVentas = new JComboBox<String>();
    private JComboBox<String> IdEmpleado = new JComboBox<String>();
    private DefaultTableModel modelo;

    public Vventas() {
        setTitle("Modulo Ventas");
        setSize(500,800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    private void inicializarComponentes() {
        
        texto[1] = new JLabel("ID vendedor:");
        texto[1].setBounds(27, 83, 86, 21);
        getContentPane().add(texto[1]);
        
        IdEmpleado.setBounds(124, 80, 101, 27);
        IdEmpleado.addItem("Seleccione");
        getContentPane().add(IdEmpleado);

        texto[2] = new JLabel("Producto:");
        texto[2].setBounds(27, 136, 56, 21);
        getContentPane().add(texto[2]);
        productoVentas.setBounds(96, 134, 129, 27);
        productoVentas.addItem("Seleccione");
        getContentPane().add(productoVentas);

        texto[3] = new JLabel("Cantidad");
        texto[3].setBounds(27, 184, 88, 21);
        getContentPane().add(texto[3]);
        area[1] = new JTextArea("");
        area[1].setBounds(127, 183, 99, 27);
        getContentPane().add(area[1]);

        
        botones[0] = new JButton("Agregar");
        botones[0].setBounds(27,283,100,27);
        botones[0].addActionListener(evt -> Controller.ventas(true,false));
        getContentPane().add(botones[0]);

        botones[1] = new JButton("Cobrar");
        botones[1].setBounds(154,283,100,27);
        botones[1].addActionListener(evt -> Controller.ventas(false,true));
        getContentPane().add(botones[1]);

        pane = new JTextField("             #Factura");
        pane.setBounds(300,80,130,114);
        pane.setEditable(false);
        getContentPane().add(pane);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{},new String[]{"Producto","Precio Unitario","Cantidad","Importe"}));
        JScrollPane scrollpane2 = new JScrollPane(table);
        scrollpane2.setBounds(27, 332, 424, 305);
        scrollpane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scrollpane2);

        botones[2] = new JButton("Volver");
        botones[2].setBounds(27,684,100,27);
        botones[2].addActionListener(evt -> Controller.personal(false,false,false,false,true));
        getContentPane().add(botones[2]);

    }

	public JButton[] getBotones() {
		return botones;
	}

	public void setBotones(JButton[] botones) {
		this.botones = botones;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JLabel[] getTexto() {
		return texto;
	}

	public void setTexto(JLabel[] texto) {
		this.texto = texto;
	}

	public JTextArea[] getArea() {
		return area;
	}

	public void setArea(JTextArea[] area) {
		this.area = area;
	}

	public JTextField getPane() {
		return pane;
	}

	public void setPane(JTextField pane) {
		this.pane = pane;
	}

	public JComboBox<String> getProductoVentas() {
		return productoVentas;
	}

	public void setProductoVentas(JComboBox<String> productoVentas) {
		this.productoVentas = productoVentas;
	}

	public JComboBox<String> getIdEmpleado() {
		return IdEmpleado;
	}

	public void setIdEmpleado(JComboBox<String> idEmpleado) {
		IdEmpleado = idEmpleado;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}
	
    
}




















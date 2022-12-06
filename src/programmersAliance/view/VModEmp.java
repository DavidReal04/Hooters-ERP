package programmersAliance.view;

import com.toedter.calendar.JDateChooser;
import programmersAliance.controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VModEmp extends JFrame {
    private JButton[] botones = new JButton[8];
    private JTextArea[] area = new JTextArea[8];
    private JLabel[] texto = new JLabel[10];
    private JTable table = new JTable();
    private JComboBox<String> edEstadoCivil = new JComboBox<String>();
    private JComboBox<String> edCargo = new JComboBox<String>();
    private JComboBox<String> editDoc = new JComboBox<String>();
    private JDateChooser dateChooser = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
    private DefaultTableModel modelo;

    public VModEmp() {
        setTitle("Editar empleado");
        setSize(415,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    private void inicializarComponentes() {
        texto[0] = new JLabel("Busqueda por ID del empleado:");
        texto[0].setBounds(13, 25, 187, 21);
        getContentPane().add(texto[0]);
        area[0] = new JTextArea();
        area[0].setBounds(205, 22, 85, 27);
        getContentPane().add(area[0]);
        botones[0] = new JButton("Buscar");
        botones[0].setBounds(310, 22, 75, 27);
        botones[0].addActionListener(evt -> Controller.PPersonal(false, false,true,false,false,false,false,false));
        getContentPane().add(botones[0]);

        table = new JTable();
        table.setModel(new DefaultTableModel(
        new Object[][]{},new String[]{"ID","TipoDoc","Nombres","Apellidos","Edad","EstadoCivil","Cargo","NumeroTel"}));
        JScrollPane scrollpane2 = new JScrollPane(table);
        scrollpane2.setBounds(13, 62, 370, 45);
        scrollpane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scrollpane2);

        texto[1] = new JLabel("Edite el ID del empleado:");
        texto[1].setBounds(13,120,163,21);
        getContentPane().add(texto[1]);
        area[1] = new JTextArea();
        area[1].setBounds(186,120,194,27);
        area[1].setEnabled(false);
        getContentPane().add(area[1]);

        texto[2] = new JLabel("Edite el tipo documento:");
        texto[2].setBounds(13,160,157,21);
        getContentPane().add(texto[2]);
        editDoc.setBounds(186, 160, 194, 27);
        editDoc.addItem("Tipo documento");
        editDoc.addItem("1-NI");
        editDoc.addItem("2-CC");
        editDoc.addItem("3-PA");
        editDoc.addItem("4-CE");
        editDoc.setEnabled(false);
        getContentPane().add(editDoc);

        texto[3] = new JLabel("Edite los nombres del empleado:");
        texto[3].setBounds(14,200,200,21);
        getContentPane().add(texto[3]);
        area[2] = new JTextArea("");
        area[2].setBounds(216,200,164,27);
        area[2].setEnabled(false);
        getContentPane().add(area[2]);

        texto[4] = new JLabel("Edite los apellidos del empleado:");
        texto[4].setBounds(14,240,200,21);
        getContentPane().add(texto[4]);
        area[3] = new JTextArea("");
        area[3].setBounds(216,240,164,27);
        area[3].setEnabled(false);
        getContentPane().add(area[3]);

        texto[5] = new JLabel("Edite la fecha de nacimiento:");
        texto[5].setBounds(14,280,200,21);
        getContentPane().add(texto[5]);
        dateChooser.setBounds(216,280,164,27);
        dateChooser.setEnabled(false);
        getContentPane().add(dateChooser);

        texto[6] = new JLabel("Edite estado civil:");
        texto[6].setBounds(14,320,150,21);
        getContentPane().add(texto[6]);
        edEstadoCivil = new JComboBox<String>();
        edEstadoCivil.setBounds(139, 320, 241, 27);
        edEstadoCivil.addItem("Estado civil");
        edEstadoCivil.addItem("1-Soltero");
        edEstadoCivil.addItem("2-Casado");
        edEstadoCivil.setEnabled(false);
        getContentPane().add(edEstadoCivil);

        texto[7] = new JLabel("Edite el cargo:");
        texto[7].setBounds(14,360,99,21);
        getContentPane().add(texto[7]);
        edCargo = new JComboBox<String>();
        edCargo.setBounds(129, 360, 251, 27);
        edCargo.addItem("Cargo");
        edCargo.addItem("1-Gerente general");
        edCargo.addItem("2-Subgerente");
        edCargo.addItem("3-Chef ejecutivo");
        edCargo.addItem("4-Segundo chef");
        edCargo.addItem("5-Pastelero");
        edCargo.addItem("6-Gerente de alimentos y bebidas");
        edCargo.addItem("7-Servidor, mesero o camarero");
        edCargo.addItem("8-Barman o bartender");
        edCargo.addItem("9-Lavavajillas");
        edCargo.addItem("10-Cajero");
        edCargo.setEnabled(false);
        getContentPane().add(edCargo);

        texto[8] = new JLabel("Edite numero telefonico:");
        texto[8].setBounds(14,400,170,21);
        getContentPane().add(texto[8]);
        area[4] = new JTextArea("");
        area[4].setBounds(180,400,200,27);
        area[4].setEnabled(false);
        getContentPane().add(area[4]);

        botones[1] = new JButton("Generar cambios");
        botones[1].setBounds(135, 460, 140, 27);
        botones[1].addActionListener(evt -> Controller.PPersonal(false, false,false,true,false,false,false,false));
        botones[1].setEnabled(false);
        getContentPane().add(botones[1]);

        botones[2] = new JButton("Volver");
        botones[2].setBounds(168, 500, 90, 27);
        botones[2].addActionListener(evt -> Controller.PPersonal(false, false,false,false,true,false,false,false));
        getContentPane().add(botones[2]);
    }

    public JButton[] getBotones() {
        return botones;
    }

    public void setBotones(JButton[] botones) {
        this.botones = botones;
    }

    public JTextArea[] getArea() {
        return area;
    }

    public void setArea(JTextArea[] area) {
        this.area = area;
    }

    public JLabel[] getTexto() {
        return texto;
    }

    public void setTexto(JLabel[] texto) {
        this.texto = texto;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JComboBox<String> getEdEstadoCivil() {
        return edEstadoCivil;
    }

    public void setEdEstadoCivil(JComboBox<String> edEstadoCivil) {
        this.edEstadoCivil = edEstadoCivil;
    }

    public JComboBox<String> getEdCargo() {
        return edCargo;
    }

    public void setEdCargo(JComboBox<String> edCargo) {
        this.edCargo = edCargo;
    }

    public JComboBox<String> getEditDoc() {
        return editDoc;
    }

    public void setEditDoc(JComboBox<String> editDoc) {
        this.editDoc = editDoc;
    }


	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}
    
}

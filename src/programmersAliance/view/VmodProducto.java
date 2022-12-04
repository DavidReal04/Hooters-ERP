package programmersAliance.view;

import com.toedter.calendar.JDateChooser;
import programmersAliance.controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VmodProducto extends JFrame {
    private JButton[] botones = new JButton[4];
    private JTextArea[] area = new JTextArea[4];
    private JLabel[] texto = new JLabel[5];
    private JTable table = new JTable();

    public VmodProducto() {
        setTitle("Editar producto");
        setSize(415,450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    private void inicializarComponentes() {
        texto[0] = new JLabel("Busqueda por ID del producto:");
        texto[0].setBounds(13, 25, 187, 21);
        getContentPane().add(texto[0]);
        area[0] = new JTextArea();
        area[0].setBounds(205, 22, 85, 27);
        getContentPane().add(area[0]);
        botones[0] = new JButton("Buscar");
        botones[0].setBounds(310, 22, 75, 27);
        botones[0].addActionListener(evt -> Controller.PProductos(false, false,true,false,false,false,false,false));
        getContentPane().add(botones[0]);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{},new String[]{"ID","Nombre","Descripcion","Precio"}));
        JScrollPane scrollpane2 = new JScrollPane(table);
        scrollpane2.setBounds(13, 62, 370, 45);
        scrollpane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scrollpane2);

        texto[1] = new JLabel("Edite el ID del producto:");
        texto[1].setBounds(13, 130, 163, 21);
        getContentPane().add(texto[1]);
        area[1] = new JTextArea();
        area[1].setBounds(186, 130, 194, 27);
        getContentPane().add(area[1]);

        texto[2] = new JLabel("Edite el nombre del producto:");
        texto[2].setBounds(14, 170, 200, 21);
        getContentPane().add(texto[2]);
        area[2] = new JTextArea("");
        area[2].setBounds(216, 170, 164, 27);
        getContentPane().add(area[2]);

        texto[3] = new JLabel("Edite descripción del producto:");
        texto[3].setBounds(14, 210, 200, 21);
        getContentPane().add(texto[3]);
        area[3] = new JTextArea("");
        JScrollPane scrollpane = new JScrollPane(area[3]);
        scrollpane.setBounds(14, 230, 365, 50);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scrollpane);

        texto[4] = new JLabel("Edite precio del producto:");
        texto[4].setBounds(14, 300, 170, 21);
        getContentPane().add(texto[4]);
        area[3] = new JTextArea("");
        area[3].setBounds(180, 300, 200, 27);
        getContentPane().add(area[3]);

        botones[1] = new JButton("Modificar");
        botones[1].setBounds(252, 360, 101, 27);
        botones[1].addActionListener(evt -> Controller.PProductos(false, false,false,true,false,false,false,false));
        getContentPane().add(botones[1]);

        botones[3] = new JButton("Volver");
        botones[3].setBounds(80, 360, 80, 27);
        botones[3].addActionListener(evt -> Controller.PProductos(false, false,false,false,true,false,false,false));
        getContentPane().add(botones[3]);
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
}

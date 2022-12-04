package programmersAliance.view;

import programmersAliance.controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Vproductos extends JFrame {
    private JButton[] botones = new JButton[4];
    private JTable[] area = new JTable[1];
    private JLabel[] texto = new JLabel[1];

    public Vproductos() {
        setTitle("Modulo productos");
        setSize(650,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    private void inicializarComponentes() {
        texto[0] = new JLabel("Productos Disponibles");
        texto[0].setBounds(265, 10, 130, 27);
        getContentPane().add(texto[0]);

        area[0] = new JTable();
        area[0].setModel(new DefaultTableModel(new Object[][]{},new String[]{"ID","Nombre","Descripcion","Precio"}));
        JScrollPane scrollpane2 = new JScrollPane(area[0]);
        scrollpane2.setBounds(64, 36, 527, 396);
        scrollpane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scrollpane2);

        botones[0] = new JButton("Modificar producto");
        botones[0].setBounds(60, 457, 144, 27);
        botones[0].addActionListener(evt -> Controller.productos(false, true, false, false));
        getContentPane().add(botones[0]);

        botones[1] = new JButton("Agregar producto");
        botones[1].setBounds(218, 457, 140, 27);
        botones[1].addActionListener(evt -> Controller.productos(true, false, false, false));
        getContentPane().add(botones[1]);

        botones[2] = new JButton("Eliminar/desactivar producto");
        botones[2].setBounds(370, 457, 220, 27);
        botones[2].addActionListener(evt -> Controller.productos(false, false, true, false));
        getContentPane().add(botones[2]);

        botones[3] = new JButton("Volver");
        botones[3].setBounds(160, 508, 300, 27);
        botones[3].addActionListener(evt -> Controller.productos(false, false, false, true));
        getContentPane().add(botones[3]);
    }

    public JButton[] getBotones() {
        return botones;
    }

    public void setBotones(JButton[] botones) {
        this.botones = botones;
    }

    public JTable[] getArea() {
        return area;
    }

    public void setArea(JTable[] area) {
        this.area = area;
    }

    public JLabel[] getTexto() {
        return texto;
    }

    public void setTexto(JLabel[] texto) {
        this.texto = texto;
    }
}

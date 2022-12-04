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
    private JComboBox<String> sucursal = new JComboBox<String>();
    private JComboBox<String> productoVentas = new JComboBox<String>();

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
        texto[0] = new JLabel("Sucursal:");
        texto[0].setBounds(27, 28, 54, 21);
        getContentPane().add(texto[0]);
        JComboBox<String> sucursal = new JComboBox<String>();
        sucursal.setBounds(96, 27, 129, 27);
        sucursal.addItem("Seleccione");
        sucursal.addItem("1-Salitre");
        sucursal.addItem("2-Zona T");
        sucursal.addItem("3-Cali");
        sucursal.addItem("4-Medellin");
        getContentPane().add(sucursal);

        texto[1] = new JLabel("ID vendedor:");
        texto[1].setBounds(27, 83, 86, 21);
        getContentPane().add(texto[1]);
        area[0] = new JTextArea("");
        area[0].setBounds(124, 80, 101, 27);
        getContentPane().add(area[0]);

        texto[2] = new JLabel("Producto:");
        texto[2].setBounds(27, 136, 56, 21);
        getContentPane().add(texto[2]);
        JComboBox<String> productoVentas = new JComboBox<String>();
        productoVentas.setBounds(96, 134, 129, 27);
        productoVentas.addItem("Seleccione");
        productoVentas.addItem("1-Alitas");
        productoVentas.addItem("2-Cerveza");
        productoVentas.addItem("3-Arroz con pollo");
        productoVentas.addItem("4-Carne");
        getContentPane().add(productoVentas);

        texto[3] = new JLabel("Precio unitario:");
        texto[3].setBounds(27, 184, 88, 21);
        getContentPane().add(texto[3]);
        area[1] = new JTextArea("");
        area[1].setBounds(127, 183, 99, 27);
        getContentPane().add(area[1]);

        texto[4] = new JLabel("Cantidad:");
        texto[4].setBounds(27, 239, 56, 21);
        getContentPane().add(texto[4]);
        area[2] = new JTextArea("");
        area[2].setBounds(108, 236, 118, 27);
        getContentPane().add(area[2]);

        botones[0] = new JButton("Agregar");
        botones[0].setBounds(27,283,100,27);
        //botones[0].addActionListener(evt -> Controller.
        getContentPane().add(botones[0]);

        botones[1] = new JButton("Eliminar");
        botones[1].setBounds(154,283,100,27);
        //botones[1].addActionListener(evt -> Controller.
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

        texto[5] = new JLabel("Subtotal:");
        texto[5].setBounds(314, 653, 51, 21);
        getContentPane().add(texto[5]);
        texto[6] = new JLabel("0.0");
        texto[6].setBounds(382, 656, 18, 21);
        getContentPane().add(texto[6]);
        texto[7] = new JLabel("IVA:");
        texto[7].setBounds(328, 684, 22, 21);
        getContentPane().add(texto[7]);
        texto[8] = new JLabel("0.0");
        texto[8].setBounds(382, 684, 18, 21);
        getContentPane().add(texto[8]);
        texto[9] = new JLabel("Total:");
        texto[9].setBounds(324, 721, 31, 21);
        getContentPane().add(texto[9]);
        texto[10] = new JLabel("0.0");
        texto[10].setBounds(382, 721, 18, 21);
        getContentPane().add(texto[10]);

        botones[2] = new JButton("Volver");
        botones[2].setBounds(27,684,100,27);
        botones[2].addActionListener(evt -> Controller.personal(false,false,false,false,true));
        getContentPane().add(botones[2]);

    }
}




















package programmersAliance.view;

import com.toedter.calendar.JDateChooser;
import programmersAliance.controller.Controller;

import javax.swing.*;

public class VagregarProd extends JFrame {
    private JButton[] botones = new JButton[2];
    private JTextArea[] area = new JTextArea[5];
    private JLabel[] texto = new JLabel[8];

        public VagregarProd() {
        setTitle("Agregar producto");
        setSize(420, 340);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    private void inicializarComponentes () {
        texto[0] = new JLabel("Ingrese el ID del producto:");
        texto[0].setBounds(13, 25, 163, 21);
        getContentPane().add(texto[0]);
        area[0] = new JTextArea();
        area[0].setBounds(186, 22, 194, 27);
        getContentPane().add(area[0]);

        texto[2] = new JLabel("Ingrese el nombre del producto:");
        texto[2].setBounds(14, 65, 200, 21);
        getContentPane().add(texto[2]);
        area[1] = new JTextArea("");
        area[1].setBounds(216, 65, 164, 27);
        getContentPane().add(area[1]);

        texto[5] = new JLabel("Ingrese descripción del producto:");
        texto[5].setBounds(14, 105, 200, 21);
        getContentPane().add(texto[5]);
        area[3] = new JTextArea("");
        JScrollPane scrollpane2 = new JScrollPane(area[3]);
        scrollpane2.setBounds(14, 135, 365, 50);
        scrollpane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scrollpane2);

        texto[4] = new JLabel("Ingrese precio del producto:");
        texto[4].setBounds(14, 195, 170, 21);
        getContentPane().add(texto[4]);
        area[2] = new JTextArea("");
        area[2].setBounds(180, 195, 200, 27);
        getContentPane().add(area[2]);

        botones[0] = new JButton("Agregar");
        botones[0].setBounds(252, 250, 101, 27);
        botones[0].addActionListener(evt -> Controller.PProductos(true, false,false,false,false,false,false,false));
        getContentPane().add(botones[0]);

        botones[1] = new JButton("Volver");
        botones[1].setBounds(80, 250, 80, 27);
        botones[1].addActionListener(evt -> Controller.PProductos(false, true,false,false,false,false,false,false));
        getContentPane().add(botones[1]);
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
}

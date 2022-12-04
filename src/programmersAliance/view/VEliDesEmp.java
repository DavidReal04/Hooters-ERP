package programmersAliance.view;

import programmersAliance.controller.Controller;

import javax.swing.*;

public class VEliDesEmp extends JFrame {
    private JButton[] botones = new JButton[3];
    private JTextArea[] area = new JTextArea[1];
    private JLabel[] texto = new JLabel[1];

    public VEliDesEmp() {
        setTitle("Agregar empleado");
        setSize(450,180);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    private void inicializarComponentes() {
        texto[0] = new JLabel("Ingrese el documento del empleado a eliminar:");
        texto[0].setBounds(11,20,277,21);
        getContentPane().add(texto[0]);
        area[0] = new JTextArea();
        area[0].setBounds(304,17,112,27);
        getContentPane().add(area[0]);

        botones[0] = new JButton("Eliminar");
        botones[0].setBounds(90, 60, 100, 27);
        botones[0].addActionListener(evt -> Controller.PPersonal(false, false,false,false,false,true,false,false));
        getContentPane().add(botones[0]);

        botones[2] = new JButton("Desactivar");
        botones[2].setBounds(250, 60, 100, 27);
        botones[2].addActionListener(evt -> Controller.PPersonal(false, false,false,false,false,false,true,false));
        getContentPane().add(botones[2]);

        botones[1] = new JButton("Volver");
        botones[1].setBounds(180, 97, 80, 27);
        botones[1].addActionListener(evt -> Controller.PPersonal(false, false,false,false,false,false,false,true));
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

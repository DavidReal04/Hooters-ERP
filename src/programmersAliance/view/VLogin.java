package programmersAliance.view;

import programmersAliance.controller.Controller;

import javax.swing.*;

public class VLogin extends JFrame {

    private JLabel[] texto=new JLabel[2];
    private JTextField input1;
    private JPasswordField input2;
    private JButton[] boton=new JButton[1];

    public  VLogin(){
        setTitle("Login");
        setSize(354, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarComponentes() {
        texto[0] = new JLabel("Usuario:");
        texto[0].setBounds(52, 48, 49, 21);
        getContentPane().add(texto[0]);

        input1 = new JTextField();
        input1.setBounds(117, 45, 200, 27);
        getContentPane().add(input1);

        texto[1] = new JLabel("Contraseña:");
        texto[1].setBounds(36, 113, 72, 21);
        getContentPane().add(texto[1]);

        input2 = new JPasswordField();
        input2.setBounds(117, 110, 200, 27);
        getContentPane().add(input2);

        boton[0] = new JButton("INGRESAR");
        boton[0].setBounds(120, 166, 100, 27);
        boton[0].addActionListener(evt -> Controller.login(true));
        getContentPane().add(boton[0]);
    }
        public JLabel[] getTexto() {
            return texto;
    }
        public void setTexto(JLabel[] texto) {
            this.texto = texto;
    }
        public JButton[] getBoton() {
            return boton;
    }
        public void setBoton(JButton[] boton) {
            this.boton = boton;
    }
        public JTextField getInput1() {
            return input1;
    }
        public void setInput1(JTextField input1) {
            this.input1 = input1;
    }
        public JPasswordField getInput2() {
            return input2;
    }
        public void setInput2(JPasswordField input2) {
            this.input2 = input2;
    }
}

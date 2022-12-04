package programmersAliance.view;
import javax.swing.*;

import programmersAliance.controller.Controller;
/**
 * Clase Menu
 * Clase de la vista que cuenta con el método inicializarComponentes y el constructor.
 * @author Felipe Segura
 * @author Yilber Rojas
 * @author David Real
 */
public class Menu extends JFrame{
    /**
     * Objeto de tipo JButton
     */
    private JLabel text = new JLabel();
    private JButton[] botones = new JButton[5];

    /**
     * Método Constructor de la clase Menu
     */
    public Menu() {
        setTitle("MENU");
        setSize(380,315);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }
    /**
     * Método inicializarComponentes de la clase Menu.
     * permite iniciar los botones, darle dimensiones y tamaños.
     */
    public void inicializarComponentes() {
        text = new JLabel("Seleccione el módulo al cual desea ingresar-- >");
        text.setBounds(47, 16, 270, 21);
        getContentPane().add(text);
        botones[0] = new JButton("Modulo personal");
        botones[0].setBounds(120, 60, 140, 27);
        botones[0].addActionListener(evt -> Controller.menu(true, false, false, false, false));
        getContentPane().add(botones[0]);

        botones[1] = new JButton("Modulo productos");
        botones[1].setBounds(120, 115, 140, 27);
        botones[1].addActionListener(evt -> Controller.menu(false, true, false, false, false));
        getContentPane().add(botones[1]);

        botones[2] = new JButton("Modulo ventas");
        botones[2].setBounds(120, 175, 140, 27);
        botones[2].addActionListener(evt -> Controller.menu(false, false, true, false, false));
        getContentPane().add(botones[2]);

        botones[3] = new JButton("Salir");
        botones[3].setBounds(260, 232, 60, 27);
        botones[3].addActionListener(evt -> Controller.menu(false, false, false, false, true));
        getContentPane().add(botones[3]);

        botones[4] = new JButton("Volver");
        botones[4].setBounds(50, 232, 70, 27);
        botones[4].addActionListener(evt -> Controller.menu(false, false, false, true, false));
        getContentPane().add(botones[4]);
    }

    /**
     * Devuelve el JButton botones
     * @return botones
     */
    public JButton[] getBotones() {
        return botones;
    }

    /**
     * Ajusta el boton
     * @param botones
     */
    public void setBotones(JButton[] botones) {
        this.botones = botones;
    }

    public JLabel getText() {
        return text;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

}

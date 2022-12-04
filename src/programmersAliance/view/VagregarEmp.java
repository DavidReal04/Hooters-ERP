package programmersAliance.view;

import com.toedter.calendar.JDateChooser;
import programmersAliance.controller.Controller;

import javax.swing.*;

public class VagregarEmp extends JFrame {
        private JButton[] botones = new JButton[2];
        private JTextArea[] area = new JTextArea[7];
        private JLabel[] texto = new JLabel[9];
        private JDateChooser dateChooser = new JDateChooser();
        private JComboBox<String> agDoc = new JComboBox<String>();
        private JComboBox<String> estadoCivil = new JComboBox<String>();
        private JComboBox<String> agCargo = new JComboBox<String>();

        public VagregarEmp() {
            setTitle("Agregar empleado");
            setSize(420,450);
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            inicializarComponentes();
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(false);
        }

        private void inicializarComponentes() {
            texto[0] = new JLabel("Ingrese el ID del empleado:");
            texto[0].setBounds(13,25,163,21);
            getContentPane().add(texto[0]);
            area[0] = new JTextArea();
            area[0].setBounds(186,22,194,27);
            getContentPane().add(area[0]);

            texto[1] = new JLabel("Ingrese el tipo documento:");
            texto[1].setBounds(13,65,157,21);
            getContentPane().add(texto[1]);
            agDoc = new JComboBox<String>();
            agDoc.setBounds(186, 62, 194, 27);
            agDoc.addItem("Tipo documento");
            agDoc.addItem("1-NI");
            agDoc.addItem("2-CC");
            agDoc.addItem("3-PA");
            agDoc.addItem("4-CE");
            getContentPane().add(agDoc);

            texto[2] = new JLabel("Ingrese los nombres del empleado:");
            texto[2].setBounds(14,106,200,21);
            getContentPane().add(texto[2]);
            area[1] = new JTextArea("");
            area[1].setBounds(216,101,164,27);
            getContentPane().add(area[1]);

            texto[5] = new JLabel("Ingrese los apellidos del empleado:");
            texto[5].setBounds(14,146,200,21);
            getContentPane().add(texto[5]);
            area[3] = new JTextArea("");
            area[3].setBounds(216,146,164,27);
            getContentPane().add(area[3]);

            texto[6] = new JLabel("Ingrese la fecha de nacimiento:");
            texto[6].setBounds(14,186,200,21);
            getContentPane().add(texto[6]);
            JDateChooser dateChooser = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
            dateChooser.setBounds(216,186,164,27);
            getContentPane().add(dateChooser);

            texto[7] = new JLabel("Ingrese estado civil:");
            texto[7].setBounds(14,223,150,21);
            getContentPane().add(texto[7]);
            estadoCivil = new JComboBox<String>();
            estadoCivil.setBounds(139, 222, 241, 27);
            estadoCivil.addItem("Estado civil");
            estadoCivil.addItem("1-Soltero");
            estadoCivil.addItem("2-Casado");
            getContentPane().add(estadoCivil);

            texto[3] = new JLabel("Ingrese el cargo:");
            texto[3].setBounds(14,263,99,21);
            getContentPane().add(texto[3]);
            agCargo = new JComboBox<String>();
            agCargo.setBounds(129, 262, 251, 27);
            agCargo.addItem("Cargo");
            agCargo.addItem("1-Gerente general");
            agCargo.addItem("2-Subgerente");
            agCargo.addItem("3-Chef ejecutivo");
            agCargo.addItem("4-Segundo chef");
            agCargo.addItem("5-Pastelero");
            agCargo.addItem("6-Gerente de alimentos y bebidas");
            agCargo.addItem("7-Servidor, mesero o camarero");
            agCargo.addItem("8-Barman o bartender");
            agCargo.addItem("9-Lavavajillas");
            agCargo.addItem("10-Cajero");
            getContentPane().add(agCargo);

            texto[4] = new JLabel("Ingrese numero telefonico:");
            texto[4].setBounds(14,304,170,21);
            getContentPane().add(texto[4]);
            area[2] = new JTextArea("");
            area[2].setBounds(180,302,200,27);
            getContentPane().add(area[2]);

            botones[0] = new JButton("Agregar");
            botones[0].setBounds(252, 351, 101, 27);
            botones[0].addActionListener(evt -> Controller.PPersonal(true, false,false,false,false,false,false,false));
            getContentPane().add(botones[0]);

            botones[1] = new JButton("Volver");
            botones[1].setBounds(80, 351, 80, 27);
            botones[1].addActionListener(evt -> Controller.PPersonal(false, true,false,false,false,false,false,false));
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

    public JDateChooser getDateChooser() {
        return dateChooser;
    }

    public void setDateChooser(JDateChooser dateChooser) {
        this.dateChooser = dateChooser;
    }

    public JComboBox<String> getAgDoc() {
        return agDoc;
    }

    public void setAgDoc(JComboBox<String> agDoc) {
        this.agDoc = agDoc;
    }

    public JComboBox<String> getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(JComboBox<String> estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public JComboBox<String> getAgCargo() {
        return agCargo;
    }

    public void setAgCargo(JComboBox<String> agCargo) {
        this.agCargo = agCargo;
    }
}

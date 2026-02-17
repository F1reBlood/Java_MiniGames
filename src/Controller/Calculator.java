package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

    private JFrame frame;
    private JTextField txtAffichage;

    private double premierNombre;
    private String operateur;


    public Calculator() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setBounds(100, 100, 350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        txtAffichage = new JTextField();
        txtAffichage.setFont(new Font("Arial", Font.BOLD, 24));
        txtAffichage.setBounds(10, 10, 314, 50);
        txtAffichage.setHorizontalAlignment(JTextField.RIGHT);
        txtAffichage.setEditable(false);
        frame.getContentPane().add(txtAffichage);
        txtAffichage.setColumns(10);

        // Boutons chiffres
        JButton btn1 = new JButton("1");
        btn1.setBounds(10, 80, 70, 50);
        frame.getContentPane().add(btn1);

        JButton btn2 = new JButton("2");
        btn2.setBounds(90, 80, 70, 50);
        frame.getContentPane().add(btn2);

        JButton btn3 = new JButton("3");
        btn3.setBounds(170, 80, 70, 50);
        frame.getContentPane().add(btn3);

        JButton btn4 = new JButton("4");
        btn4.setBounds(10, 140, 70, 50);
        frame.getContentPane().add(btn4);

        JButton btn5 = new JButton("5");
        btn5.setBounds(90, 140, 70, 50);
        frame.getContentPane().add(btn5);

        JButton btn6 = new JButton("6");
        btn6.setBounds(170, 140, 70, 50);
        frame.getContentPane().add(btn6);

        JButton btn7 = new JButton("7");
        btn7.setBounds(10, 200, 70, 50);
        frame.getContentPane().add(btn7);

        JButton btn8 = new JButton("8");
        btn8.setBounds(90, 200, 70, 50);
        frame.getContentPane().add(btn8);

        JButton btn9 = new JButton("9");
        btn9.setBounds(170, 200, 70, 50);
        frame.getContentPane().add(btn9);

        JButton btn0 = new JButton("0");
        btn0.setBounds(90, 260, 70, 50);
        frame.getContentPane().add(btn0);

        // Boutons opérations
        JButton btnPlus = new JButton("+");
        btnPlus.setBounds(250, 80, 70, 50);
        frame.getContentPane().add(btnPlus);

        JButton btnMoins = new JButton("-");
        btnMoins.setBounds(250, 140, 70, 50);
        frame.getContentPane().add(btnMoins);

        JButton btnMult = new JButton("×");
        btnMult.setBounds(250, 200, 70, 50);
        frame.getContentPane().add(btnMult);

        JButton btnDiv = new JButton("÷");
        btnDiv.setBounds(250, 260, 70, 50);
        frame.getContentPane().add(btnDiv);

        JButton btnEgal = new JButton("=");
        btnEgal.setBounds(170, 260, 70, 50);
        frame.getContentPane().add(btnEgal);

        JButton btnClear = new JButton("C");
        btnClear.setBounds(10, 260, 70, 50);
        frame.getContentPane().add(btnClear);

        // Action chiffres
        ActionListener chiffreListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                txtAffichage.setText(txtAffichage.getText() + btn.getText());
            }
        };

        btn0.addActionListener(chiffreListener);
        btn1.addActionListener(chiffreListener);
        btn2.addActionListener(chiffreListener);
        btn3.addActionListener(chiffreListener);
        btn4.addActionListener(chiffreListener);
        btn5.addActionListener(chiffreListener);
        btn6.addActionListener(chiffreListener);
        btn7.addActionListener(chiffreListener);
        btn8.addActionListener(chiffreListener);
        btn9.addActionListener(chiffreListener);

        // Action opérations
        ActionListener operateurListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                premierNombre = Double.parseDouble(txtAffichage.getText());
                operateur = btn.getText();
                txtAffichage.setText("");
            }
        };

        btnPlus.addActionListener(operateurListener);
        btnMoins.addActionListener(operateurListener);
        btnMult.addActionListener(operateurListener);
        btnDiv.addActionListener(operateurListener);

        // Egal
        btnEgal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double secondNombre = Double.parseDouble(txtAffichage.getText());
                double resultat = 0;

                switch (operateur) {
                    case "+":
                        resultat = premierNombre + secondNombre;
                        break;
                    case "-":
                        resultat = premierNombre - secondNombre;
                        break;
                    case "×":
                        resultat = premierNombre * secondNombre;
                        break;
                    case "÷":
                        resultat = premierNombre / secondNombre;
                        break;
                }

                txtAffichage.setText(String.valueOf(resultat));
            }
        });

        // Clear
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAffichage.setText("");
                premierNombre = 0;
                operateur = "";
            }
        });
    }
}
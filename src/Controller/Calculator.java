package Controller;

import Model.StyleModel;
import View.MainMenu;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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

        // --- Bouton Retour ---
        JButton btnRetour = new JButton("Retour");
        btnRetour.setFont(new Font("Arial", Font.BOLD, 12));
        btnRetour.setBounds(90, 350, 150, 40);
        frame.getContentPane().add(btnRetour);

        btnRetour.addActionListener(e -> {
           frame.dispose();
           new MainMenuController(new MainMenu());
        });

        Color retourColorRetour = new Color(70, 70, 70);
        Color textColorRetour = Color.WHITE;

        btnRetour.setForeground(textColorRetour);
        btnRetour.setBackground(retourColorRetour);
        btnRetour.setFocusPainted(false);
        btnRetour.setContentAreaFilled(false);
        btnRetour.setOpaque(false);
        btnRetour.setBorder(new StyleModel.RoundedBorder(20));
        btnRetour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRetour.setFont(new Font("Arial", Font.BOLD, 14));

        // Hover / Press
        Color normalRetour = retourColorRetour;
        Color hoverRetour = new Color(120, 120, 120, 120);
        Color pressedRetour = new Color(50, 50, 50, 150);

        btnRetour.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) { btnRetour.setBackground(hoverRetour); btnRetour.repaint(); }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) { btnRetour.setBackground(normalRetour); btnRetour.repaint(); }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) { btnRetour.setBackground(pressedRetour); btnRetour.repaint(); }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) { btnRetour.setBackground(hoverRetour); btnRetour.repaint(); }
        });

        // UI personnalisé
        btnRetour.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(btnRetour.getBackground());
                g2.fillRoundRect(0, 0, btnRetour.getWidth(), btnRetour.getHeight(), 20, 20);
                g2.dispose();
                super.paint(g, c);
            }
        });

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

        // Couleurs
        Color chiffreColor = new Color(50, 50, 50);        // gris foncé
        Color operateurColor = new Color(255, 140, 0);     // orange
        Color egalColor = new Color(255, 165, 0);          // orange vif
        Color clearColor = new Color(220, 20, 60);         // rouge
        Color textColor = Color.WHITE;

        // Style boutons chiffres
        JButton[] chiffres = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        for (JButton btn : chiffres) {
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setForeground(textColor);
            btn.setBackground(chiffreColor);
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
            btn.setOpaque(false);
            btn.setBorder(new StyleModel.RoundedBorder(20));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Hover / Press effet semi-transparent
            Color normal = chiffreColor;
            Color hover = new Color(100, 100, 100, 100);
            Color pressed = new Color(0, 0, 0, 100);

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) { btn.setBackground(hover); btn.repaint(); }
                @Override
                public void mouseExited(java.awt.event.MouseEvent e) { btn.setBackground(normal); btn.repaint(); }
                @Override
                public void mousePressed(java.awt.event.MouseEvent e) { btn.setBackground(pressed); btn.repaint(); }
                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) { btn.setBackground(hover); btn.repaint(); }
            });

            btn.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
                @Override
                public void paint(Graphics g, JComponent c) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(btn.getBackground());
                    g2.fillRoundRect(0, 0, btn.getWidth(), btn.getHeight(), 20, 20);
                    g2.dispose();
                    super.paint(g, c);
                }
            });
        }

        // Style boutons opérations
        JButton[] operateurs = {btnPlus, btnMoins, btnMult, btnDiv};
        for (JButton btn : operateurs) {
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setForeground(textColor);
            btn.setBackground(operateurColor);
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
            btn.setOpaque(false);
            btn.setBorder(new StyleModel.RoundedBorder(20));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Hover / Press
            Color normal = operateurColor;
            Color hover = new Color(255, 180, 0, 150);
            Color pressed = new Color(255, 140, 0, 150);

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) { btn.setBackground(hover); btn.repaint(); }
                @Override
                public void mouseExited(java.awt.event.MouseEvent e) { btn.setBackground(normal); btn.repaint(); }
                @Override
                public void mousePressed(java.awt.event.MouseEvent e) { btn.setBackground(pressed); btn.repaint(); }
                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) { btn.setBackground(hover); btn.repaint(); }
            });

            btn.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
                @Override
                public void paint(Graphics g, JComponent c) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(btn.getBackground());
                    g2.fillRoundRect(0, 0, btn.getWidth(), btn.getHeight(), 20, 20);
                    g2.dispose();
                    super.paint(g, c);
                }
            });
        }

        // Bouton "=" orange vif
        btnEgal.setFont(new Font("Arial", Font.BOLD, 18));
        btnEgal.setForeground(textColor);
        btnEgal.setBackground(egalColor);
        btnEgal.setFocusPainted(false);
        btnEgal.setContentAreaFilled(false);
        btnEgal.setOpaque(false);
        btnEgal.setBorder(new StyleModel.RoundedBorder(20));
        btnEgal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEgal.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) { btnEgal.setBackground(new Color(255, 200, 0, 150)); btnEgal.repaint(); }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) { btnEgal.setBackground(egalColor); btnEgal.repaint(); }
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) { btnEgal.setBackground(new Color(255, 165, 0, 150)); btnEgal.repaint(); }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) { btnEgal.setBackground(new Color(255, 200, 0, 150)); btnEgal.repaint(); }
        });
        btnEgal.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(btnEgal.getBackground());
                g2.fillRoundRect(0, 0, btnEgal.getWidth(), btnEgal.getHeight(), 20, 20);
                g2.dispose();
                super.paint(g, c);
            }
        });

        // Bouton "C" rouge
        btnClear.setFont(new Font("Arial", Font.BOLD, 18));
        btnClear.setForeground(textColor);
        btnClear.setBackground(clearColor);
        btnClear.setFocusPainted(false);
        btnClear.setContentAreaFilled(false);
        btnClear.setOpaque(false);
        btnClear.setBorder(new StyleModel.RoundedBorder(20));
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) { btnClear.setBackground(new Color(255, 60, 100, 150)); btnClear.repaint(); }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) { btnClear.setBackground(clearColor); btnClear.repaint(); }
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) { btnClear.setBackground(new Color(220, 20, 60, 150)); btnClear.repaint(); }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) { btnClear.setBackground(new Color(255, 60, 100, 150)); btnClear.repaint(); }
        });
        btnClear.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(btnClear.getBackground());
                g2.fillRoundRect(0, 0, btnClear.getWidth(), btnClear.getHeight(), 20, 20);
                g2.dispose();
                super.paint(g, c);
            }
        });

        // Style du champ d’affichage
        txtAffichage.setBackground(new Color(30, 30, 30));
        txtAffichage.setForeground(Color.WHITE);
        txtAffichage.setBorder(new StyleModel.RoundedBorder(15));
        txtAffichage.setOpaque(false);


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
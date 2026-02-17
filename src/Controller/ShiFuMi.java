package Controller;

import Model.StyleModel;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShiFuMi {

    private JFrame frame;
    private int botPts = 0;
    private int userPts = 0;
    private int maxTours = 3;
    private String botChoicetext = "";

    private JLabel lblResult;
    private JLabel lblScore;
    private JLabel lblchoixordinateur;

    public ShiFuMi() {

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        Color pierreColor = new Color(93, 173, 226);
        Color feuilleColor = new Color(88, 214, 141);
        Color ciseauxColor = new Color(249, 231, 159);
        Color labelColor = new Color(44, 62, 80); // gris foncé
        Color hover = new Color(200, 200, 200, 120); // hover léger semi-transparent

        JLabel lblTours = new JLabel("Nombre de points gagants :");
        lblTours.setBounds(30, 20, 165, 20);
        frame.getContentPane().add(lblTours);

        JComboBox comboTours = new JComboBox();
        comboTours.addItem("3");
        comboTours.addItem("5");
        comboTours.addItem("10");
        comboTours.setBounds(203, 19, 60, 22);
        frame.getContentPane().add(comboTours);

        lblResult = new JLabel("Résultat : ");
        lblResult.setBounds(30, 200, 350, 20);
        StyleModel.addShiFuMiStyleToLabel(lblResult);
        frame.getContentPane().add(lblResult);

        lblScore = new JLabel("Score : 0 - 0");
        lblScore.setBounds(30, 230, 200, 20);
        StyleModel.addShiFuMiStyleToLabel(lblScore);
        frame.getContentPane().add(lblScore);

        JButton btnPierre = new JButton("Pierre");
        btnPierre.setBounds(30, 80, 100, 30);
        StyleModel.addShiFuMiStyleToButton(btnPierre, pierreColor);
        frame.getContentPane().add(btnPierre);

        JButton btnFeuille = new JButton("Feuille");
        btnFeuille.setBounds(160, 80, 100, 30);
        StyleModel.addShiFuMiStyleToButton(btnFeuille, feuilleColor);
        frame.getContentPane().add(btnFeuille);

        JButton btnCiseaux = new JButton("Ciseaux");
        btnCiseaux.setBounds(290, 80, 100, 30);
        StyleModel.addShiFuMiStyleToButton(btnCiseaux, ciseauxColor);
        frame.getContentPane().add(btnCiseaux);

        lblchoixordinateur = new JLabel("Choix de l'ordinateur :");
        lblchoixordinateur.setBounds(28, 177, 273, 14);
        StyleModel.addShiFuMiStyleToLabel(lblchoixordinateur);
        frame.getContentPane().add(lblchoixordinateur);


        // Action boutons
        btnPierre.addActionListener(e -> jouer(1));
        btnFeuille.addActionListener(e -> jouer(2));
        btnCiseaux.addActionListener(e -> jouer(3));

        comboTours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                maxTours = Integer.parseInt((String) comboTours.getSelectedItem());
                resetGame();
            }
        });
    }

    private void jouer(int userChoice) {

        if (botPts >= maxTours || userPts >= maxTours) {
            lblResult.setText("Partie terminée ! Changez le nombre de tours pour recommencer.");
            return;
        }

        int botChoice = (int) (Math.random() * 3) + 1;
        if (botChoice == 1) {
            botChoicetext = "pierre";
        }else if (botChoice == 2) {
            botChoicetext = "feuille";
        }else {
            botChoicetext = "ciseaux";
        }

        if (botChoice == userChoice) {

            lblchoixordinateur.setText("L'oridanteur a choisi : "+botChoicetext);
            lblResult.setText("Égalité !");
        } else if ((userChoice == 1 && botChoice == 3) ||
                (userChoice == 2 && botChoice == 1) ||
                (userChoice == 3 && botChoice == 2)) {
            lblchoixordinateur.setText("L'oridanteur a choisi : "+botChoicetext);
            userPts++;
            lblResult.setText("Vous gagnez la manche !");
        } else {
            botPts++;
            lblchoixordinateur.setText("L'oridanteur a choisi : "+botChoicetext);
            lblResult.setText("L'ordinateur gagne la manche !");
        }

        lblScore.setText("Score : " + userPts + " - " + botPts);

        if (userPts == maxTours) {
            lblResult.setText("🎉 Vous avez gagné la partie !");
        } else if (botPts == maxTours) {
            lblResult.setText("💻 L'ordinateur a gagné la partie !");
        }
    }

    private void resetGame() {
        botPts = 0;
        userPts = 0;
        lblScore.setText("Score : 0 - 0");
        lblResult.setText("Nouvelle partie !");
    }
}
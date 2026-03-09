package Controller;

import View.MainMenu;

import javax.swing.*;
import java.awt.*;

public class GuessTheNumber {

    private JFrame frame;
    private JTextField nbJoueurField;
    public int nbTry = 0;
    public int nbRandom = (int) (Math.random()*(100)+1);

    public GuessTheNumber() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel devineLabel = new JLabel("Devine le nombre :");
        devineLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        devineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        devineLabel.setBounds(10, 49, 125, 26);
        frame.getContentPane().add(devineLabel);

        nbJoueurField = new JTextField();
        nbJoueurField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nbJoueurField.setHorizontalAlignment(SwingConstants.CENTER);
        nbJoueurField.setBounds(145, 49, 86, 26);
        frame.getContentPane().add(nbJoueurField);
        nbJoueurField.setColumns(10);

        JLabel ttvlabel = new JLabel("Nombre de tentatives :");
        ttvlabel.setBounds(241, 86, 136, 33);
        frame.getContentPane().add(ttvlabel);

        JLabel nbtryLabel = new JLabel("0");
        nbtryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nbtryLabel.setBounds(359, 86, 52, 33);
        frame.getContentPane().add(nbtryLabel);

        JLabel plusgrandLabel = new JLabel("Raté : le nombre à deviner est plus grand !");
        plusgrandLabel.setHorizontalAlignment(SwingConstants.CENTER);
        plusgrandLabel.setBounds(68, 188, 257, 22);
        frame.getContentPane().add(plusgrandLabel);

        JLabel pluspetitLabel = new JLabel("Raté : le nombre à deviner est plus petit !");
        pluspetitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pluspetitLabel.setBounds(68, 188, 257, 22);
        frame.getContentPane().add(pluspetitLabel);

        JLabel winLabel = new JLabel("Bien joué, vous avez gagné !");
        winLabel.setHorizontalAlignment(SwingConstants.CENTER);
        winLabel.setBounds(68, 188, 257, 22);
        frame.getContentPane().add(winLabel);

        pluspetitLabel.setVisible(false);
        plusgrandLabel.setVisible(false);
        winLabel.setVisible(false);

        JButton pressButton = new JButton("?");
        pressButton.addActionListener(e -> {
                int nbJoueur = Integer.parseInt(nbJoueurField.getText());
                nbTry++;
                if(nbJoueur>nbRandom) {
                    pluspetitLabel.setVisible(true);
                    plusgrandLabel.setVisible(false);
                    winLabel.setVisible(false);
                    nbtryLabel.setText(String.valueOf(nbTry));
                }
                else if(nbJoueur<nbRandom) {
                    pluspetitLabel.setVisible(false);
                    plusgrandLabel.setVisible(true);
                    winLabel.setVisible(false);
                    nbtryLabel.setText(String.valueOf(nbTry));
                }
                else {
                    pluspetitLabel.setVisible(false);
                    plusgrandLabel.setVisible(false);
                    winLabel.setVisible(true);
                    nbtryLabel.setText(String.valueOf(nbTry));
                }
        });
        pressButton.setFont(new Font("Tahoma", Font.PLAIN, 90));
        pressButton.setBounds(142, 86, 89, 91);
        frame.getContentPane().add(pressButton);

        JButton replayButton = new JButton("Rejouer");
        replayButton.addActionListener(e -> {
                pluspetitLabel.setVisible(false);
                plusgrandLabel.setVisible(false);
                winLabel.setVisible(false);
                nbRandom = (int) (Math.random()*(100)+1);
                nbTry = 0;
                nbtryLabel.setText(String.valueOf(nbTry));
                nbJoueurField.setText("");
        });
        replayButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        replayButton.setBounds(139, 217, 103, 33);
        frame.getContentPane().add(replayButton);

        JButton returnButton = new JButton("Retour");
        returnButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        returnButton.setBounds(349, 220, 80, 26);
        frame.getContentPane().add(returnButton);
        returnButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuController(new MainMenu());
        });

    }
}

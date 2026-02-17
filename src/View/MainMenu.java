package View;

import Model.GradientPanel;
import Model.StyleModel;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    private JFrame frame = new JFrame("Java MiniGames");
    private JPanel mainPanel = new GradientPanel();
    private JPanel centerPanel = new GradientPanel();
    private JButton navalButton;
    private JButton shifumiButton;
    private JButton guessButton;
    private JButton calculatorButton;
    private JLabel menuLabel;

    public MainMenu() {
        mainPanel.setLayout(new BorderLayout());
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // centre la fenêtre
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 600));

        centerPanel.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        menuLabel = new JLabel("Select a game");
        navalButton = new JButton("Naval Battle");
        shifumiButton = new JButton("ShiFuMi");
        guessButton = new JButton("Guess the number");
        calculatorButton = new JButton("Calculator");

        mainPanel.add(menuLabel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(navalButton);

        StyleModel.addMainMenuStyleToLabel(menuLabel);
        StyleModel.addMainMenuStyleToButton(navalButton);
        StyleModel.addMainMenuStyleToButton(shifumiButton);
        StyleModel.addMainMenuStyleToButton(guessButton);
        StyleModel.addMainMenuStyleToButton(calculatorButton);


    }

}

package View;

import Model.GradientPanel;
import Model.StyleModel;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    private JFrame frame = new JFrame("Java MiniGames");
    private JPanel mainPanel = new GradientPanel();
    private JPanel topPanel;
    private JPanel centerPanel;
    private JButton navalButton;
    private JButton shifumiButton;
    private JButton guessButton;
    private JButton calculatorButton;
    private JLabel menuLabel;

    public MainMenu() {
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // centre la fenêtre
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 600));

        StyleModel.addMainMenuStyleToLabel(menuLabel);
        StyleModel.addMainMenuStyleToButton(navalButton);
        StyleModel.addMainMenuStyleToButton(shifumiButton);
        StyleModel.addMainMenuStyleToButton(guessButton);
        StyleModel.addMainMenuStyleToButton(calculatorButton);
    }

}

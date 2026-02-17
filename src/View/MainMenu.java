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
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 600));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        menuLabel = new JLabel("Select a game");
        navalButton = new JButton("Naval Battle");
        shifumiButton = new JButton("ShiFuMi");
        guessButton = new JButton("Guess the number");
        calculatorButton = new JButton("Calculator");

        mainPanel.add(menuLabel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(guessButton);
        centerPanel.add(shifumiButton);
        centerPanel.add(navalButton);
        centerPanel.add(calculatorButton);

        StyleModel.addMainMenuStyleToLabel(menuLabel);
        StyleModel.addMainMenuStyleToButton(navalButton);
        StyleModel.addMainMenuStyleToButton(shifumiButton);
        StyleModel.addMainMenuStyleToButton(guessButton);
        StyleModel.addMainMenuStyleToButton(calculatorButton);

        centerPanel.add(Box.createVerticalGlue()); // espace flexible avant

        navalButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        shifumiButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        guessButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculatorButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(guessButton);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // espace entre boutons
        centerPanel.add(shifumiButton);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(navalButton);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(calculatorButton);

        centerPanel.add(Box.createVerticalGlue()); // espace flexible après

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(JPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public JButton getNavalButton() {
        return navalButton;
    }

    public void setNavalButton(JButton navalButton) {
        this.navalButton = navalButton;
    }

    public JButton getShifumiButton() {
        return shifumiButton;
    }

    public void setShifumiButton(JButton shifumiButton) {
        this.shifumiButton = shifumiButton;
    }

    public JButton getGuessButton() {
        return guessButton;
    }

    public void setGuessButton(JButton guessButton) {
        this.guessButton = guessButton;
    }

    public JButton getCalculatorButton() {
        return calculatorButton;
    }

    public void setCalculatorButton(JButton calculatorButton) {
        this.calculatorButton = calculatorButton;
    }

    public JLabel getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(JLabel menuLabel) {
        this.menuLabel = menuLabel;
    }
}

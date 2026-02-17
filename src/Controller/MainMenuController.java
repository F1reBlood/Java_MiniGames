package Controller;

import View.MainMenu;

public class MainMenuController {
    public MainMenuController(MainMenu view) {
        view.getCalculatorButton().addActionListener(e -> {
            view.getFrame().dispose();
            new Calculator();
        });
    }
}

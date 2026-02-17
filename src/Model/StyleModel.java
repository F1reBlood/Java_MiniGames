package Model;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;



public class StyleModel {

    // =========================
    // BORDURE ARRONDIE
    // =========================

    static class RoundedBorder extends AbstractBorder {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(138, 43, 226));
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(10, 20, 10, 20);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = 20;
            insets.top = insets.bottom = 10;
            return insets;
        }
    }


    // =========================
    // 🎯 MAIN MENU STYLE
    // =========================

    public static void addMainMenuStyleToLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(new Color(255, 255, 255));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static void addMainMenuStyleToButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(72, 61, 139));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setBorder(new RoundedBorder(30));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // =========================
    // 🚢 BATAILLE NAVALE STYLE
    // =========================

    public static void addBatailleNavaleStyleToLabel(JLabel label) {
        label.setFont(new Font("Verdana", Font.BOLD, 24));
        label.setForeground(new Color(173, 216, 230));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static void addBatailleNavaleStyleToButton(JButton button) {
        button.setFont(new Font("Verdana", Font.BOLD, 16));
        button.setBackground(new Color(0, 105, 148));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(0, 191, 255), 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // =========================
    // ✊ SHI FU MI STYLE
    // =========================

    public static void addShiFuMiStyleToLabel(JLabel label) {
        label.setFont(new Font("Serif", Font.BOLD, 26));
        label.setForeground(new Color(139, 0, 0));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static void addShiFuMiStyleToButton(JButton button) {
        button.setFont(new Font("Serif", Font.BOLD, 18));
        button.setBackground(new Color(245, 222, 179));
        button.setForeground(new Color(139, 0, 0));
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(178, 34, 34), 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // =========================
    // 🔢 DEVINE LE NOMBRE STYLE
    // =========================

    public static void addDevineNombreStyleToLabel(JLabel label) {
        label.setFont(new Font("Consolas", Font.BOLD, 28));
        label.setForeground(new Color(57, 255, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static void addDevineNombreStyleToButton(JButton button) {
        button.setFont(new Font("Consolas", Font.BOLD, 16));
        button.setBackground(Color.BLACK);
        button.setForeground(new Color(57, 255, 20));
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(57, 255, 20), 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // =========================
    // 🧮 CALCULATRICE STYLE
    // =========================

    public static void addCalculatriceStyleToLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 22));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    public static void addCalculatriceStyleToButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(50, 50, 50));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(100, 100, 100), 1));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

}

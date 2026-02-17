package Controller;

import View.MainMenu;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.Random;

public class NavalBattle extends JFrame {

    private final int TAILLE = 6;
    private final int NB_BATEAUX = 5;

    private JButton[][] grilleJoueur = new JButton[TAILLE][TAILLE];
    private JButton[][] grilleBot = new JButton[TAILLE][TAILLE];

    private boolean[][] bateauxJoueur = new boolean[TAILLE][TAILLE];
    private boolean[][] bateauxBot = new boolean[TAILLE][TAILLE];

    private int bateauxPlaces = 0;
    private int bateauxRestantsJoueur;
    private int bateauxRestantsBot;

    private boolean phasePlacement = true;
    private boolean tourJoueur = false;

    private JLabel statut;
    private JButton boutonStart;

    private Random rand = new Random();

    // 🎨 couleurs
    private final Color EAU = new Color(30, 144, 255);
    private final Color BATEAU = Color.DARK_GRAY;
    private final Color TOUCHE = Color.RED;
    private final Color RATE = Color.LIGHT_GRAY;

    public NavalBattle() {
        setTitle("🚢 Bataille Navale");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel centre = new JPanel(new GridLayout(1, 2, 20, 0));
        centre.setBorder(new EmptyBorder(10, 10, 10, 10));

        centre.add(creerPanelJoueur());
        centre.add(creerPanelBot());

        // ===== bouton retour =====
        JButton boutonRetour = new JButton("← Retour");
        boutonRetour.addActionListener(e -> {
            dispose();
            new MainMenuController(new MainMenu());
        });

        statut = new JLabel("Place tes bateaux (" + NB_BATEAUX + ")");
        boutonStart = new JButton("Démarrer");
        boutonStart.setEnabled(false);
        boutonStart.addActionListener(e -> demarrerPartie());

        JPanel bas = new JPanel();
        bas.add(boutonRetour); // ✅ ajouté ici
        bas.add(statut);
        bas.add(boutonStart);

        add(centre, BorderLayout.CENTER);
        add(bas, BorderLayout.SOUTH);


        placerBateaux(bateauxBot);
        bateauxRestantsBot = NB_BATEAUX;
        bateauxRestantsJoueur = NB_BATEAUX;

        setVisible(true);
    }

    // ===== panneau joueur =====
    private JPanel creerPanelJoueur() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("TA GRILLE"));

        JPanel grille = new JPanel(new GridLayout(TAILLE, TAILLE, 2, 2));

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {

                JButton btn = new JButton();
                btn.setBackground(EAU);

                int x = i, y = j;
                btn.addActionListener(e -> clicJoueur(x, y));

                grilleJoueur[i][j] = btn;
                grille.add(btn);
            }
        }

        panel.add(grille);
        return panel;
    }

    // ===== panneau bot =====
    private JPanel creerPanelBot() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new TitledBorder("GRILLE ENNEMIE"));

        JPanel grille = new JPanel(new GridLayout(TAILLE, TAILLE, 2, 2));

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {

                JButton btn = new JButton();
                btn.setBackground(EAU);

                int x = i, y = j;
                btn.addActionListener(e -> tirJoueur(x, y));

                grilleBot[i][j] = btn;
                grille.add(btn);
            }
        }

        panel.add(grille);
        return panel;
    }

    // ===== clic sur ta grille =====
    private void clicJoueur(int x, int y) {
        if (bateauxPlaces >= NB_BATEAUX) return;

        if (!bateauxJoueur[x][y]) {
            bateauxJoueur[x][y] = true;
            grilleJoueur[x][y].setBackground(BATEAU);
            bateauxPlaces++;

            statut.setText("Bateaux placés: " + bateauxPlaces + "/" + NB_BATEAUX);
        }

        if (bateauxPlaces == NB_BATEAUX) {
            boutonStart.setEnabled(true);
            statut.setText("Clique sur Démarrer !");
        }
    }

    // ===== démarrer =====
    private void demarrerPartie() {
        phasePlacement = false;
        tourJoueur = true;
        statut.setText("Ton tour !");
    }

    // ===== tir joueur =====
    private void tirJoueur(int x, int y) {
        if (phasePlacement || !tourJoueur) return;

        JButton btn = grilleBot[x][y];
        if (!btn.isEnabled()) return;

        tourJoueur = false;

        if (bateauxBot[x][y]) {
            btn.setBackground(TOUCHE);
            btn.setText("X");
            bateauxRestantsBot--;
            statut.setText("Touché !");
        } else {
            btn.setBackground(RATE);
            btn.setText("O");
            statut.setText("Raté… le bot joue");
        }

        btn.setEnabled(false);

        if (bateauxRestantsBot == 0) {
            JOptionPane.showMessageDialog(this, "🎉 Tu as gagné !");
            return;
        }

        Timer timer = new Timer(1000, e -> tourBot());
        timer.setRepeats(false);
        timer.start();
    }

    // ===== tour bot =====
    private void tourBot() {
        int x, y;

        do {
            x = rand.nextInt(TAILLE);
            y = rand.nextInt(TAILLE);
        } while (!grilleJoueur[x][y].isEnabled());

        JButton btn = grilleJoueur[x][y];

        if (bateauxJoueur[x][y]) {
            btn.setBackground(TOUCHE);
            btn.setText("X");
            bateauxRestantsJoueur--;
            statut.setText("💥 Le bot t'a touché !");
        } else {
            btn.setBackground(RATE);
            btn.setText("O");
            statut.setText("Ton tour !");
        }

        btn.setEnabled(false);

        if (bateauxRestantsJoueur == 0) {
            JOptionPane.showMessageDialog(this, "🤖 Le bot a gagné !");
            return;
        }

        tourJoueur = true;
    }

    // ===== placement bot =====
    private void placerBateaux(boolean[][] grille) {
        for (int i = 0; i < NB_BATEAUX; i++) {
            int x, y;
            do {
                x = rand.nextInt(TAILLE);
                y = rand.nextInt(TAILLE);
            } while (grille[x][y]);

            grille[x][y] = true;
        }
    }

}

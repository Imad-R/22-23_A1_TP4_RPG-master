import com.isep.rpg.Game;
import com.isep.rpg.Scene;

import javax.swing.JFrame;

public class Main {

    public static Scene scene;

    public static void main(String[] args) {
        // Il faudra initialiser un "InputParser"...
        Game game = new Game(null);
        game.start();

        JFrame fenetre = new JFrame("RPG : The Hobbit");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700,360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setAlwaysOnTop(true);

        scene = new Scene();
        fenetre.setContentPane(scene);
        fenetre.setVisible(true);
    }

}
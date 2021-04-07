package DataStructure_Algorithms.Project_PingPong;
import java.awt.*;
import javax.swing.*;
public class GameJFrame extends JFrame {
    GamePanel panel;
    GameJFrame(){
         panel = new GamePanel();
         this.add(panel);
         this.setTitle("Game - Pong");
         this.setResizable(false);
         this.setBackground(Color.darkGray);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.pack(); // this will auto adjust
         this.setVisible(true);
         this.setLocationRelativeTo(null);//it will show on middle of the screen
    }
}

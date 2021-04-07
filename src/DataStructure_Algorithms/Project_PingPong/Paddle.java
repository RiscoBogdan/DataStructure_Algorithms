package DataStructure_Algorithms.Project_PingPong;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{
    int id; // 1 for player 1, 2 for player 2
    int yVelocity; // how fast is moving when we press the button (sus-jos) pe axa y
    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
       super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
       this.id = id;
    }
    public void keyPressed(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){

    }
    public void setYDirection(int yDirection){

    }
    public void move(){

    }
    public void draw(Graphics g){
        if(id==1){
            g.setColor(Color.CYAN);
        }
        else
            g.setColor(Color.orange);
        g.fillRect(x,y,width,height);
    }
}

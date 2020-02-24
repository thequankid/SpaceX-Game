import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class SpaceX extends JPanel {
    int GRAVITY = -2;
    int rocketX = 200;
    int rocketY = 10;
    int rocketW = 10;
    int rocketH = 50;
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //Antialiasing makes the figure smoother
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Stats
        g2d.drawString("Height: " + rocketY, 10, 50);


        g2d.drawRect(rocketX, rocketY, rocketW, rocketH);
        rocketY-=GRAVITY;
        while(rocketY > 300){
            rocketY-=GRAVITY;
            if (rocketY + rocketH > 300){
                GRAVITY = 0;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame("SpaceX");
    SpaceX spacex = new SpaceX();
    frame.add(spacex);
    frame.setSize(500, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    while (true) {
        spacex.repaint();
        Thread.sleep(10);
    }
}
}
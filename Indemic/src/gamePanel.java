import java.awt.*;
import javax.swing.*;

public class gamePanel extends JPanel {
    private Boss boss;

    public gamePanel(Boss boss) {
        this.boss = boss;
        setPreferredSize(new Dimension(500, 500));
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.RED);
        g.fillRect(50, 50, boss.getHealth(), 20);
    }
}

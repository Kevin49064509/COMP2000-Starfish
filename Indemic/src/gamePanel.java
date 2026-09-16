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
        
        //background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        //health bar
        //health bar dimensions
        int barWidth = 200;
        int barHeight = 20;
        int x = 50;
        int y = 50;

        //Health bar outline
        g.setColor(Color.BLACK);
        g.drawRect(x, y, barWidth, barHeight);

        //adjust bar fill
        g.setColor(Color.WHITE);
        g.fillRect(x, y, barWidth, barHeight);

        //Health bar fill
        double healthPercentage = (double) boss.getHealth() / boss.getMaxHealth();
        int fillWidth = (int) (barWidth * healthPercentage);

        g.setColor(Color.RED);
        g.fillRect(x, y, fillWidth, barHeight);
    }
}

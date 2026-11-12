import java.awt.*;
import java.util.List;
import javax.swing.*;

public class gamePanel extends JPanel implements bossListener{
    private Boss boss;
    private int dps;
    private final List<Cell> cells;
    int x;
    int y;

    public gamePanel(Boss boss, List<Cell> cells) {
        this.boss = boss;
        this.cells = cells;
        setPreferredSize(new Dimension(500, 500));
    }

    @Override
    public void bossChange(Boss boss) {
        repaint();
    }
    
    //show dps
    public void setDps(int dps) {
        this.dps = dps;
    }

    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        //health bar - right now just repainting on the same timer as when the boss takes damage but can be made to an observer pattern later
        //health bar dimensions
        int barWidth = 200;
        int barHeight = 20;

        //Health bar outline
        g.setColor(Color.BLACK);
        g.drawRect(x + 25, y + 25, barWidth, barHeight);

        //adjust bar fill
        g.setColor(Color.WHITE);
        g.fillRect(x + 25, y + 25, barWidth, barHeight);

        //Health bar fill
        double healthPercentage = (double) boss.getHealth() / boss.getMaxHealth();
        int fillWidth = (int) (barWidth * healthPercentage);

        g.setColor(Color.RED);
        g.fillRect(x + 25, y + 25, fillWidth, barHeight);

        //dps show
        g.setColor(Color.BLACK);
        g.drawString("DPS: " + dps, x + 25, y + barHeight + 50);

        //boss
        int cx = 250, cy = 250;

        //cells
        int n = cells.size();
        for (int i = 0; i < n; i++) {
            double angle = 2 * Math.PI * i / n;
            int x = cx + (int) (130 * Math.cos(angle)) - 10;
            int y = cy + (int) (130 * Math.cos(angle)) - 10;
            g.setColor(cells.get(i).getColor());
            g.fillOval(x, y, 20, 20);
        }

    }
}

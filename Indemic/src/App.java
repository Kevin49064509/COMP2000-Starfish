import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("test");

        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        gamePanel panel = new gamePanel(new Boss(100));
        frame.add(panel);
        
        frame.setVisible(true);

        Boss boss = new Boss(100);

        //variables, move to a class later for cleaner code
        int resources = 20;

        List<Cell> cells = new ArrayList<Cell>();

        try {
            Cell baseCell = new baseCell(5, 10);
            if (resources < baseCell.getCost()) {
                throw new poorException("insufficient tbd");
            }
            resources -= baseCell.getCost();
            cells.add(baseCell);
        } catch (poorException e) {
            System.out.println(e.getMessage());
        }
        
        Timer timer = new Timer(500, e -> {
            if (!boss.isDead()) {
                for (Cell cell : cells) {
                    cell.applyDamage(boss);
                }
                panel.repaint();
            }
        });
        timer.start();
    }

    /*
    add method to buy cells

    public static void buyCell(Cell cell, int cost, int resources, List<Cell> cells) throws Exception{
        if (resources < cell.getCost()) {
            throw new poorException("insufficient tbd");
        }
        cells.add(cell);
    }
        */
}

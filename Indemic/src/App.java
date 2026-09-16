import java.util.*;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("test");

        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel panel = new gamePanel(new Boss(100));
        frame.add(panel);

        Boss boss = new Boss(100);

        //variables, move to a class later for cleaner code
        int resources = 5;

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
        
        while (!boss.isDead()) {
            for (Cell cell : cells) {
                cell.applyDamage(boss);
            }
            System.out.println("Boss health: " + boss.getHealth());
        }
        System.out.println("Boss dead");
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

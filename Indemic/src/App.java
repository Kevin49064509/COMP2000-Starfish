import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("test");

        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        Boss boss = new Boss(100);

        gamePanel gamePanel = new gamePanel(boss);
        frame.add(gamePanel);

        frame.setVisible(true);

        //variables, move to a class later for cleaner code
        int resources = 20;

        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new attackCell(10, 99, 0.2)); //testing crit delete later

        //TESTING DELETE THIS
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
                System.out.println("Boss health: " + boss.getHealth());
                gamePanel.repaint();
            }
        });
        timer.start();
    }

    //OVERLOAD METHOD HERE INTO BUY still need to finish logic
    //buy one
    public static int buyCell(Cell cell, int resources, List<Cell> cells) throws poorException{
        if (resources < cell.getCost()) {
            throw new poorException("insufficient tbd");
        }
        resources -= cell.getCost();
        cells.add(cell);
        return resources;
    }
    
    //buy multiple
    public static int buyCell(Cell cell, int resources, List<Cell> cells, int quantity) throws poorException{
        int totalCost = cell.getCost() * quantity;
        if (resources < totalCost) {
            throw new poorException("insufficient tbd");
        }
        resources -= totalCost;
        for (int i = 0; i < quantity; i++) {
            cells.add(cell);
        }
        return resources;
    }
}

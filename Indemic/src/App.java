import java.util.*;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("test");

        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new attackCell(10));
        cells.add(new baseCell(5));

        Boss boss = new Boss(100);
        

        while (!boss.isDead()) {
            for (Cell cell : cells) {
                cell.applyDamage(boss);
            }
            System.out.println("Boss health: " + boss.getHealth());
        }
        System.out.println("Boss dead");
    }
}

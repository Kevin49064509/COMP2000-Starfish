import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("test");

        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Boss boss = new Boss(100);
        Cell cell = new Cell(10);

        while (!boss.isDead()) {
            cell.applyDamage(boss);
            System.out.println("Boss health: " + boss.getHealth());
        }
        System.out.println("Boss dead");
    }
}

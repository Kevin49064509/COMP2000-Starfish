public class Cell {
    private int damage;

    public Cell(int damage) {
        this.damage = damage;
    }

    public void applyDamage(Boss boss) {
        boss.takeDamage(damage);
    }
}

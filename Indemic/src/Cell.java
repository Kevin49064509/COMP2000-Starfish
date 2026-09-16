public abstract class Cell {
    private int damage;
    private int cost;

    public Cell(int damage, int cost) {
        this.damage = damage;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public void applyDamage(Boss boss) {
        boss.takeDamage(damage);
    }
}

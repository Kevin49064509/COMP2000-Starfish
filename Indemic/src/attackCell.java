public class attackCell extends Cell {
    // still unsure if to have all cell subtypes buyable from the start like classes or have them unlockable like through certain upgrades which fit them like this one would be unlocked through attack based upgrades.
    private double critChance;
    private static final double critMult = 2.0;
    
    public attackCell(int damage, int cost, double critChance) {
        super(damage, cost);
        this.critChance = critChance;
    }

    @Override 
    public void applyDamage(Boss boss) {
        if (Math.random() < critChance) {
            boss.takeDamage((int)(getDamage() * critMult));
            System.out.println("Critical");
        } else {
            boss.takeDamage(getDamage());
        }
    }
}
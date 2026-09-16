public class Boss {
    private int health;
    private int maxHealth;

    // also add attack later

    public Boss(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isDead() {
        return health == 0;
    }
}

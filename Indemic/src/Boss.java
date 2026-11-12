import java.util.ArrayList;
import java.util.List;

public class Boss {
    private int health;
    private int maxHealth;
    private final List<bossListener> listeners = new ArrayList<>();

    // also add attack later

    public Boss(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void addListener(bossListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners() {
        for (bossListener listener : listeners) {
            listener.bossChange(this);
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        notifyListeners();
    }

    public boolean isDead() {
        return health == 0;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}

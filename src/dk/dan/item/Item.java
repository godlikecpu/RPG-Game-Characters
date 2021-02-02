package dk.dan.item;

import dk.dan.Level;
import dk.dan.Stats;

public abstract class Item {

    private String name;
    private Level level = new Level();
    private Stats stats;
    private ItemSlot itemSlot;

    public Item(String name, ItemSlot itemSlot) {
        this.name = name;
        this.itemSlot = itemSlot;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public ItemSlot getItemSlot() {
        return itemSlot;
    }

    public abstract void gainXP(int xp);

    public abstract Stats getBonusStats(Stats heroStats);

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", stats=" + stats +
                ", itemSlot=" + itemSlot +
                '}';
    }
}
package dk.dan.hero;

import dk.dan.Stats;
import dk.dan.item.Item;
import dk.dan.item.ItemSlot;
import dk.dan.Level;

import java.util.HashMap;

public class Hero {
    private Level level = new Level();
    private HeroClass heroClass;
    private Stats stats;
    private Stats pureStats;
    private HashMap<ItemSlot, Item> inventory = new HashMap<>();

    public Hero(HeroClass heroClass) {
        this.heroClass = heroClass;
        this.stats = heroClass.getBaseStats();
    }

    public Stats addStatsFromLevel(Stats currentStats, Stats statsOnLevel) {
        currentStats.addStats(statsOnLevel);
        return currentStats;
    }

    public void gainXP(int xp) {
        int levelBeforeXP = level.getLvl();
        level.gainXP(xp);
        int levelAfterXP = level.getLvl();
        for (int i = levelBeforeXP; i < levelAfterXP; i++) {
            addStatsFromLevel(getStats(), heroClass.getStatsOnLevel());
        }
        pureStats = stats.cloneStats(stats);
    }

    public Level getLevel() {
        return this.level;
    }

    public void attack() {
        Item weapon = inventory.get(ItemSlot.WEAPON);
        if (weapon != null) {
            System.out.println(heroClass.getName() + " attacks with " + weapon.getName() + " for " + stats.getDamage() + " damage");
        } else {
            System.out.println("You don't have a weapon equipped");
        }

    }

    public void display() {
        System.out.println("###########");
        System.out.println(heroClass.getName() + " details:");
        System.out.println("DMG: " + getStats().getDamage());
        System.out.println("HP: " + getStats().getHp());
        System.out.println("Str: " + getStats().getStrength());
        System.out.println("Dex: " + getStats().getDexterity());
        System.out.println("Int: " + getStats().getIntelligence());
        System.out.println("Level: " + getLevel().getLvl());
        System.out.println("XP: " + getLevel().getXp());
        System.out.println("XP to next lvl: " + getLevel().getRequiredXp(getLevel().getLvl(), getLevel().getXp()));
        System.out.println("###########");
    }

    public void equipItem(Item item) {
        if (item.getLevel().getLvl() <= this.getLevel().getLvl()) {
            inventory.put(item.getItemSlot(), item);
        } else {
            System.out.println("Your level (" + getLevel() + ") is lower than the items (" + item.getLevel() + ")");
        }
        calculateItemBonus();
    }

    private void calculateItemBonus() {
        Stats itemStats = new Stats(0, 0, 0, 0, 0);
        itemStats.addStats(pureStats);
        inventory.forEach((itemSlot, item) -> {
            itemStats.addStats(item.getBonusStats(pureStats));
        });
        setStats(itemStats);
    }


    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}

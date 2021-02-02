package dk.dan.hero;

import dk.dan.Stats;
import dk.dan.item.Item;
import dk.dan.item.ItemSlot;
import dk.dan.Level;

import java.util.HashMap;

public class Hero {

    /**
     * This class contains the base of functionality for heroes.
     */

    private Level level = new Level();
    private HeroClass heroClass;
    private Stats stats;
    private Stats pureStats;
    private HashMap<ItemSlot, Item> inventory = new HashMap<>();

    public Hero(HeroClass heroClass) {
        this.heroClass = heroClass;
        this.stats = heroClass.getBaseStats();
    }

    /**
     * Adds the Stats that the Hero gains per level
     *
     * @param currentStats the current Stats for the Hero
     * @param statsOnLevel the Stats to add to the Hero
     * @return current Stats after addition
     */

    public Stats addStatsFromLevel(Stats currentStats, Stats statsOnLevel) {
        currentStats.addStats(statsOnLevel);
        return currentStats;
    }

    /**
     * Wrapper method for gaining XP on the Hero.
     *
     * @param xp the amount of XP
     */

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

    /**
     * This methods represents attacking with a weapon.
     * Checks if you have a weapon equipped first.
     */

    public void attack() {
        Item weapon = inventory.get(ItemSlot.WEAPON);
        if (weapon != null) {
            System.out.println(heroClass.getName() + " attacks with " + weapon.getName() + " for " + stats.getDamage() + " damage");
        } else {
            System.out.println("You don't have a weapon equipped");
        }
    }

    /**
     * This method displays a hero to the console, with all relevant information
     */

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

    /**
     * This method puts an Item to the Hero's inventory
     * Checks if the hero is high enough level first.
     *
     * @param item the item to put in to inventory
     */

    public void equipItem(Item item) {
        if (item.getLevel().getLvl() <= this.getLevel().getLvl()) {
            inventory.put(item.getItemSlot(), item);
            calculateItemBonus();
        } else {
            System.out.println("Your level (" + getLevel() + ") is lower than the items (" + item.getLevel() + ")");
        }
    }

    /**
     * Calculates item bonuses from items and sets the stats to the Hero
     */

    private void calculateItemBonus() {
        // create new stats
        Stats itemStats = new Stats(0, 0, 0, 0, 0);
        // adds the Hero stats (without items)
        itemStats.addStats(pureStats);
        // for each slot except weapon, it will add to the new stats
        inventory.forEach((itemSlot, item) -> {
            if (itemSlot != ItemSlot.WEAPON) {
                itemStats.addStats(item.getBonusStats(pureStats));
            }
        });
        // at last, calculate the weapon stats so we get the bonus str/dex/int for damage
        if (inventory.get(ItemSlot.WEAPON) != null) {
            itemStats.addStats(inventory.get(ItemSlot.WEAPON).getBonusStats(itemStats));
        }
        // update the hero's stats
        setStats(itemStats);
    }


    public Stats getStats() {
        return this.stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}

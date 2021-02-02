package dk.dan.item;

import dk.dan.Stats;
import dk.dan.item.itemtype.ItemType;

public class Armor extends Item {

    /**
     * Instantiatable class for armor items.
     */

    ItemType itemType;

    public Armor(String name, ItemType itemType, ItemSlot itemSlot) {
        super(name, itemSlot);
        this.itemType = itemType;
        this.setStats(itemType.getBaseStats());
    }

    /**
     * Adds the Stats that the item gains per level
     *
     * @param currentStats the current Stats for the Item
     * @param statsOnLevel the Stats to add to the item
     * @return current Stats after addition
     */

    public Stats addStatsFromLevel(Stats currentStats, Stats statsOnLevel) {
        currentStats.addStats(statsOnLevel);
        return currentStats;
    }

    /**
     * Wrapper method for gaining XP on the item.
     *
     * @param xp the amount of XP
     */

    public void gainXP(int xp) {
        int levelBeforeXP = this.getLevel().getLvl();
        this.getLevel().gainXP(xp);
        int levelAfterXP = this.getLevel().getLvl();
        for (int i = levelBeforeXP; i < levelAfterXP; i++) {
            addStatsFromLevel(this.getStats(), itemType.getStatsOnLevel());
        }
    }

    @Override
    public Stats getBonusStats(Stats heroStats) {
        return itemType.getScaledStats(heroStats, this.getStats(), this.getItemSlot());
    }


}

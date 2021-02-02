package dk.dan.item;

import dk.dan.Stats;

public class Weapon extends Item {
    ItemType itemType;

    public Weapon(String name, ItemType itemType) {
        super(name, ItemSlot.WEAPON);
        this.itemType = itemType;
        this.setStats(itemType.getBaseStats());
    }

    public Stats addStatsFromLevel(Stats currentStats, Stats statsOnLevel) {
        currentStats.addStats(statsOnLevel);
        return currentStats;
    }

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
        return itemType.getScaledStats(heroStats, this.getStats());
    }


}

package dk.dan.hero;

import dk.dan.Stats;

public class Mage implements HeroClass {

    private final String NAME = "Mage";
    private final Stats BASE_STATS = new Stats(100, 2, 3, 10, 0);
    private final Stats STATS_ON_LEVEL = new Stats(15, 1, 2, 5, 0);


    @Override
    public void calculateBonusStats() {

    }

    @Override
    public Stats getStatsOnLevel() {
        return this.STATS_ON_LEVEL;
    }


    public Stats getBaseStats() {
        return this.BASE_STATS;
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

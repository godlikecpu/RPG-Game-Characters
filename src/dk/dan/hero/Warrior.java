package dk.dan.hero;

import dk.dan.Stats;

public class Warrior implements HeroClass {

    private final String NAME = "Warrior";
    private final Stats BASE_STATS = new Stats(150, 10, 3, 1, 0);
    private final Stats STATS_ON_LEVEL = new Stats(30, 5, 2, 1, 0);

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

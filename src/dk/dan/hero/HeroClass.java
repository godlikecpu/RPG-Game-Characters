package dk.dan.hero;

import dk.dan.Stats;

public interface HeroClass {

    public void calculateBonusStats();

    public Stats getStatsOnLevel();

    public Stats getBaseStats();

    public String getName();

}

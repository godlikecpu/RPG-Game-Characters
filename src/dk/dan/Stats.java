package dk.dan;

public class Stats {

    /**
     * This class represents the stats of a character or item.
     * Provides functionality to alter stats as well
     */

    private int hp;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int damage;


    public Stats(int hp, int strength, int dexterity, int intelligence, int damage) {
        this.hp = hp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.damage = damage;
    }

    /**
     * Adds two stats objects to each other.
     *
     * @param bonusStats the stats you want to add
     * @return the concatenated stats
     */

    public Stats addStats(Stats bonusStats) {
        this.setHp(this.getHp() + bonusStats.getHp());
        this.setDamage(this.getDamage() + bonusStats.getDamage());
        this.setStrength(this.getStrength() + bonusStats.getStrength());
        this.setDexterity(this.getDexterity() + bonusStats.getDexterity());
        this.setIntelligence(this.getIntelligence() + bonusStats.getIntelligence());
        return this;
    }

    /**
     * Scales stats by the given double
     *
     * @param scale the given double
     * @return the scaled stats
     */

    public Stats scaleStats(double scale) {
        this.setHp((int) Math.floor(this.getHp() * scale));
        this.setDamage((int) Math.floor(this.getDamage() * scale));
        this.setStrength((int) Math.floor(this.getStrength() * scale));
        this.setDexterity((int) Math.floor(this.getDexterity() * scale));
        this.setIntelligence((int) Math.floor(this.getIntelligence() * scale));
        return this;
    }

    /**
     * Clones a Stats object
     *
     * @param statsToClone the stats to clone
     * @return a clone
     */

    public Stats cloneStats(Stats statsToClone) {
        Stats clone = new Stats(0, 0, 0, 0, 0);
        clone.setHp(statsToClone.getHp());
        clone.setStrength(statsToClone.getStrength());
        clone.setDexterity(statsToClone.getDexterity());
        clone.setIntelligence(statsToClone.getIntelligence());
        clone.setDamage(statsToClone.getDamage());
        return clone;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Stats:" +
                "hp=" + hp +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", damage=" + damage;

    }
}

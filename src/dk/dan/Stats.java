package dk.dan;

public class Stats {

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


    public Stats addStats(Stats bonusStats) {
        this.setHp(this.getHp() + bonusStats.getHp());
        this.setDamage(this.getDamage() + bonusStats.getDamage());
        this.setStrength(this.getStrength() + bonusStats.getStrength());
        this.setDexterity(this.getDexterity() + bonusStats.getDexterity());
        this.setIntelligence(this.getIntelligence() + bonusStats.getIntelligence());
        return this;
    }

    public Stats subtractStats(Stats bonusStats) {
        this.setHp(this.getHp() - bonusStats.getHp());
        this.setDamage(this.getDamage() - bonusStats.getDamage());
        this.setStrength(this.getStrength() - bonusStats.getStrength());
        this.setDexterity(this.getDexterity() - bonusStats.getDexterity());
        this.setIntelligence(this.getIntelligence() - bonusStats.getIntelligence());
        return this;
    }

    public Stats cloneStats(Stats statsToClone) {
        Stats clone = new Stats(0, 0, 0, 0, 0);
        clone.setHp(statsToClone.getHp());
        clone.setStrength(statsToClone.getStrength());
        clone.setDamage(statsToClone.getDexterity());
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

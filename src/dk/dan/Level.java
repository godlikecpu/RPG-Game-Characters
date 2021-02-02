package dk.dan;

public class Level {

    /**
     * This class represents the level of heroes and items.
     * Provides functionality to gain X
     */

    private int lvl = 1;
    private int xp = 0;

    /**
     * This method empties the given amount of XP and converts it to levels
     *
     * @param xp amount of XP
     */

    public void gainXP(int xp) {
        while (xp != 0) {
            int xpRequired = getRequiredXp(this.getLvl(), this.getXp());
            if (xpRequired > xp) {
                this.setXp(this.getXp() + xp);
                xp = 0;
            } else {
                this.setLvl(this.getLvl() + 1);
                xp = xp - xpRequired;
            }
        }
    }

    /**
     * Finds out how much XP is needed to a certain level
     *
     * @param level     the level
     * @param currentXp current amount of XP
     * @return the amount of xp required to the next level
     */

    public int getRequiredXp(int level, int currentXp) {
        int xpRequired = 100;
        for (int i = 1; i < level; i++) {
            xpRequired = (int) Math.floor(xpRequired * 1.1);
        }
        return xpRequired - currentXp;
    }


    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getXp() {
        return xp;
    }

    private void setXp(int xp) {
        this.xp = xp;
    }


}

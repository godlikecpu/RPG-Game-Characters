package dk.dan;

public class Level {
    private int lvl = 1;
    private int xp = 0;

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

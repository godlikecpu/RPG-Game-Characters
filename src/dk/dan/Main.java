package dk.dan;

import dk.dan.hero.*;
import dk.dan.item.*;

public class Main {

    public static void main(String[] args) {
        Hero hero = new Hero(new Warrior());
        Weapon weapon = new Weapon("Smasher", new Melee());
        Weapon weapon1 = new Weapon("Smasher Two: Electric Boogaloo", new Melee());
        Armor armor = new Armor("Robe", new Cloth(), ItemSlot.CHEST);
        hero.gainXP(1500);
        weapon.gainXP(1400);
        weapon1.gainXP(1200);

        hero.equipItem(armor);
        hero.equipItem(weapon);
        hero.display();

        hero.equipItem(weapon1);


        hero.display();
    }
}

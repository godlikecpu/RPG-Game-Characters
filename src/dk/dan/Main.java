package dk.dan;


import dk.dan.hero.*;
import dk.dan.item.*;
import dk.dan.item.itemtype.*;

public class Main {

    /**
     * Creating a hero some weapons and armor, leveling it up, equipping it and attacking
     */

    public static void main(String[] args) {
        Hero hero = new Hero(new Warrior());
        Weapon weapon = new Weapon("Smasher", new Melee());
        Weapon weapon1 = new Weapon("Smasher Two: Electric Boogaloo", new Melee());
        Armor armor = new Armor("Big Armor", new Plate(), ItemSlot.CHEST);
        hero.gainXP(1500);
        weapon.gainXP(1400);
        weapon1.gainXP(1200);
        armor.gainXP(1000);
        hero.equipItem(weapon);
        hero.display();
        hero.equipItem(armor);
        hero.equipItem(weapon1);
        hero.display();
        hero.attack();
    }
}

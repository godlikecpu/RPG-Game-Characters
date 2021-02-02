package dk.dan.item.itemtype;

import dk.dan.Stats;
import dk.dan.item.ItemSlot;

/**
 * Interface for Strategy implementation of item types
 */
public interface ItemType {

    /**
     * This method will return the scaled Stats given a heroes Stats, an items Stats and the item slot
     *
     * @param heroStats the heroes Stats
     * @param itemStats the items Stats
     * @param itemSlot  the item slot
     * @return scaled stats
     */

    Stats getScaledStats(Stats heroStats, Stats itemStats, ItemSlot itemSlot);

    /**
     * This method returns a Stats object defined in the instantiable item.
     *
     * @return Stats object representing how much the item gains per level
     */

    Stats getStatsOnLevel();

    /**
     * This method returns the starting stats for an Item
     *
     * @return the base stats
     */

    Stats getBaseStats();
}

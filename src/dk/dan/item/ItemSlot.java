package dk.dan.item;

public enum ItemSlot {

    /**
     * Ties to an Item and is used to describe which slot the Item can fit on a Hero, along with the scaling based on slot
     */

    CHEST {
        public double scaling() {
            return 1.0;
        }
    },

    HEAD {
        public double scaling() {
            return 0.8;
        }
    },
    LEGS {
        public double scaling() {
            return 0.6;
        }
    },
    WEAPON {
        public double scaling() {
            return 1.0;
        }
    };

    public abstract double scaling();
}

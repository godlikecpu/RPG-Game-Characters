package dk.dan.item;

public enum ItemSlot {
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
}

package com.buildingManager;

public enum Appliances {
    STOVE, FRIDGE, FREEZER;

    public String toString() {
        switch (this) {
            case STOVE:
                return "Stove";
            case FRIDGE:
                return "Fridge";
            case FREEZER:
                return "Freezer";
            default:
                return "No appliances registered";
        }
    }
}

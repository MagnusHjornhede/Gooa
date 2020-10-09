package com.buildingManager;

public enum FloorType {
    TILES, MAT, WOOD;

    public String toString() {
        switch (this) {
            case TILES:
                return "Tiles";
            case MAT:
                return "Mat";
            case WOOD:
                return "Wood";
            default:
                return "No floor type registered";
        }
    }
}

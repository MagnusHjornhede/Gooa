package com.buildingManager;

import java.util.LinkedList;
import java.util.List;

public enum Building {
    HALL, KITCHEN, BATHROOM, ROOM1, ROOM2, ROOM3, ROOM4, TOILET;

    public String toString() {
        switch (this) {
            case HALL:
                return "Hall";
            case KITCHEN:
                return "Kitchen";
            case BATHROOM:
                return "Bathroom";
            case ROOM1:
                return "Room 1";
            case ROOM2:
                return "Room 2";
            case ROOM3:
                return "Room 3";
            case ROOM4:
                return "Room 4";
            case TOILET:
                return "Toilet";
            default:
                return "No rooms registered";
        }
    }
}

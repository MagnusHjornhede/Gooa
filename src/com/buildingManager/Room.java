package com.buildingManager;


/**
 * Class for defining a room, it contains no setters and the objects
 * are only created by constructors. RoomType and FloorType are enums.
 */
public class Room {
private int size; // Square meters
private RoomBuilder roomDetails;
private int yearRenovated;
    public Room(int size, RoomBuilder roomDetails) {
        this.size = size;
        this.roomDetails = roomDetails;
    }

    public Room(int size, RoomBuilder roomDetails, int yearRenovated) {
        this.size = size;
        this.roomDetails = roomDetails;
        this.yearRenovated=yearRenovated;
    }

    public int getSize() {
        return size;
    }

    public int getYearRenovated(){
        return yearRenovated;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public RoomBuilder getRoomDetails() {
        return roomDetails;
    }
}

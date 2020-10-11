package com.buildingManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;



public class Apartment {
    private String roomNumber;
    private List roomsInApartment; // Rooms stored as list

    public Apartment() {
        roomsInApartment = new LinkedList();
    }

    public void addRoom(int size, RoomBuilder spec) {
        Room room = new Room(size, spec);
        roomsInApartment.add(room);
    }

    // rework this one
    public Room getSize(int size) {
        for (Iterator i = getRoomsInApartment().iterator(); i.hasNext(); ) {
            Room room = (Room) i.next();
            if (room.getSize() == size) {
                return room;
            }
        }
        return null;
    }

    // This method returns a list containing all matching objects


    public List searchData(RoomBuilder searchSpec) {
        List matchingRooms = new LinkedList();
        String searcher;
        for (Iterator i = getRoomsInApartment().iterator(); i.hasNext(); ) {// If theres something in the list

            Room room = (Room) i.next();  // Casting out a room object from the iterator squence
            if (room.getRoomDetails().matches(searchSpec)||room.getRoomDetails().matches(searchSpec)
            ) // Check if it matches requirements or not
            {
                matchingRooms.add(room);// add matching object to list
            }
        }

        return matchingRooms;// return the list result
    }

    public List getRoomsInApartment() {
        return roomsInApartment;
    }

    public void setRoomsInApartment(List roomsInApartment) {
        this.roomsInApartment = roomsInApartment;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "roomNumber='" + roomNumber + '\'' +
                ", RoomsInApartment=" + roomsInApartment +
                '}';
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getApartmentSize() {
        int aptSize = 0;
        for (Iterator i = getRoomsInApartment().iterator(); i.hasNext(); ) {// If theres something in the list
            Room room = (Room) i.next();
            // if (room.getRoomDetails().matches(searchSpec)) ;// Check if it matches requirements or not
            //matchingRooms.add(room);// add matching object to list
        }
        return aptSize;
    }
}

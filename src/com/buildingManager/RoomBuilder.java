package com.buildingManager;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

/**
 * Class takes properties via the constructor to create
 */
public class RoomBuilder {

    private Map room;  // room types stored in Map

    public RoomBuilder(Map properties) {  // Constructor
        if (properties == null) { // no existing hashmap create a new none
            this.room = new HashMap();
        } else { // or use other one
            this.room = new HashMap(properties);
        }
    }

    // Getting specific object based on a string name
    public Object getProperty(String propertyName) {
        return room.get(propertyName);    // Looking for specific property
    }

    public Map getProperties() {
        return room;  // Return the properties
    }

    // Looking after specific attributes in map
    public boolean matches(RoomBuilder otherSpec) {

        for (Iterator i = otherSpec.getProperties().keySet().iterator();
             i.hasNext(); ) {
            String propertyName = (String) i.next();

            if (!room.get(propertyName).equals(otherSpec.getProperty(propertyName))||
                    !room.get(propertyName).equals(otherSpec.getProperty(propertyName).toString() )) {
                {
                    System.out.println(room.get(propertyName).toString()+"\n");
                return false;
            }}
        }
        return true;
    }

    @Override
    public String toString() {
        return "RoomBuilder{" +
                "room=" + room +
                '}';
    }
}


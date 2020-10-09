package com.buildingManager;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Initializing class, the apartment class contains
        // a string for apartment number and most importantly
        // a list for the rooms.
        // Building building1= new Building();
        Apartment apartment = new Apartment();

        // We have no rooms to begin with so
        // these need to be created
        createComplex(apartment);
        // building1.addApartment("Lunden1", apartment);

        // As this is not a complete program we hard code the operations
        // Create search criteria with starting with map
        Map properties = new HashMap<String, Object>();
        //properties.put("room", RoomType.BATHROOM);
        //properties.put("room", RoomType.HALL);
        /*
        properties.put("floor", FloorType.WOOD);
        properties.put("room", RoomType.HALL);
        properties.put("appliances", Appliances.FREEZER);
        properties.put("roomNr", "25");
        apartment.addRoom(10, new RoomBuilder(properties));

        properties.put("floor", FloorType.WOOD+ " year:2003");
        properties.put("Room", RoomType.ROOM1);
        properties.put("wall", "year:2015");
        properties.put("roomNr","1002" );
        apartment.addRoom(11,new RoomBuilder(properties));*/

       //properties.put("appliances", "test");
        properties.put("floor", FloorType.WOOD+" year:2003");
        //apartment.addRoom(12,new RoomBuilder(properties));
        //apartment.addRoom(13,new RoomBuilder(properties));
        // Creating instance with constructor of RoomBuilder (immutability)
        RoomBuilder roomToFind = new RoomBuilder(properties);

        // With the newly created instance of roomToFInd put it in search method of Apartment
        // and this going to return a list of possible matches.

        //System.out.println("Total size"+ apartment.getApartmentSize());

        List matchingResults = apartment.searchData(roomToFind);
        List dumpData = apartment.getRoomsInApartment();


        //getApartmentSize(apartment);
       // printingApartment(dumpData);
        System.out.println("----------DATA DUMP COMPLETE----------");
        printingApartment(matchingResults);


       menuSystem(dumpData);


        //printingApartment( apartment.searchData(roomToFind));
    }

    private static void menuSystem(List list) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        int numbers = 0;
        boolean again = true;

        while (again) {
            try {

                do {
                    System.out.println("Choose your destiny!");
                    System.out.println("1. Show all data");
                    numbers = keyboard.nextInt();
                    switch (numbers) {
                        case 1: {
                            printingApartment(list);
                            break;
                        }
                        case 2: {
                            System.out.println("556");
                            break;
                        }
                    }
                   // System.in.read();
                } while (numbers != 3);

                if (numbers < 1)
                    throw new NegativeNumberException();
                again = false;
            } catch (InputMismatchException e) {
                System.out.println("You entered a non-numeric value which is not allowed.");
                System.out.print("Please enter the number again. ");
                keyboard.nextLine(); // clearing buffer

            } catch (NegativeNumberException e) {
                System.out.println("Numbers must be greater then 0.");
                keyboard.nextLine();
            }
        }





/*
        double sum = 0;

        for (int i = 0; i < numbers; i++) {
            again = true;
            while (again) {
                try {
                    System.out.println("Enter number " + (i + 1));
                    sum += keyboard.nextInt();
                    again = false; // value ok, get next one
                } catch (InputMismatchException e) {
                    System.out.println("You entered a non-numeric value which is not allowed.");
                    System.out.print("Please enter the number again. ");
                    keyboard.nextLine(); // clearing buffer
                }
            }
        }*/

    }

    private static void getApartmentSize(List object) {
        int counter = 0;
        for (Iterator iterator = object.iterator(); iterator.hasNext(); ) {
            Room room = (Room) iterator.next();
            counter += room.getSize();
        }
        System.out.println("The total size is " + counter);
    }

    private static void printingApartment(List matchingRooms) {
        if (!matchingRooms.isEmpty()) {
            for (Iterator i = matchingRooms.iterator(); i.hasNext(); ) {
                Room room = (Room) i.next();
                RoomBuilder spec = room.getRoomDetails();
                System.out.println(spec.getProperty("room") +
                        " with the following history:");

                // Iterating the properties of the rooms
                for (Iterator j = spec.getProperties().keySet().iterator();
                     j.hasNext(); ) {
                    String propertyName = (String) j.next();
                    if (propertyName.equals("room")) // skip line
                        continue;
                    System.out.println("    " + propertyName + ": " +
                            spec.getProperty(propertyName));

                }
                System.out.println("    " + "size: " + room.getSize() + " sqm");

            }
        } else {
            System.out.println("Empty list");
        }
    }

    private static void createComplex(Apartment apartment) {

        // Creating Rooms
        // Building up the properties for the room and put that in a map
        Map properties = new HashMap();
        properties.put("floor", FloorType.WOOD);
        properties.put("room", RoomType.HALL);
        properties.put("appliances", Appliances.FREEZER);
        properties.put("roomNr", "25");
        // properties are set, now time to use those when when creating
        // a new room to the apartment.
        apartment.addRoom(10, new RoomBuilder(properties));
        // Same as above

        properties.put("floor", FloorType.WOOD+ " year:2003");
        properties.put("Room", RoomType.ROOM1);
        properties.put("wall", "year:2015");
        properties.put("appliances", "test");
        properties.put("roomNr","1002" );
        apartment.addRoom(11,new RoomBuilder(properties));

        properties.put("floor", FloorType.TILES);
        properties.put("room", RoomType.BATHROOM);
        properties.put("aptNumber","1003" );
        apartment.addRoom(12,new RoomBuilder(properties));
/*
        properties.put("floor", FloorType.MAT+ " year:2002");
        properties.put("room", RoomType.ROOM2);
        properties.put("aptNumber","1004" );
        apartment.addRoom(13,new RoomBuilder(properties));

        properties.put("room", RoomType.KITCHEN);
        properties.put("floor", FloorType.TILES + " year:2015");
        properties.put("appliances", Appliances.FRIDGE);

        properties.put("aptNumber","1005" );
        properties.put("adress","Göteborgsvägen 12");
        properties.put("test", FloorType.MAT);
        apartment.addRoom(14,new RoomBuilder(properties));
        */

        // RoomBuilder roomToFind = new RoomBuilder(properties);
        // List matchingRooms = apartment.search(roomToFind);
    }

    private static class NegativeNumberException extends Throwable {

    }
}

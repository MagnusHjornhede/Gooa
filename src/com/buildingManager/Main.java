package com.buildingManager;

import java.io.IOException;
import java.util.*;

public class Main extends Engine {

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
        properties.put("aptNr", 25);
        //apartment.addRoom(12,new RoomBuilder(properties));
        //apartment.addRoom(13,new RoomBuilder(properties));
        // Creating instance with constructor of RoomBuilder (immutability)
        RoomBuilder roomToFind = new RoomBuilder(properties);

        // With the newly created instance of roomToFInd put it in search method of Apartment
        // and this going to return a list of possible matches.


        List dumpData = apartment.getRoomsInApartment();

        System.out.println("----------DATA DUMP COMPLETE----------");
        List matchingResults = apartment.searchData(roomToFind);
        printingApartment(matchingResults);


        menuSystem(dumpData, apartment); // main menu


        //printingApartment( apartment.searchData(roomToFind));
    }

    private static void menuSystem(List list, Apartment apartment) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        int numbers = 0;

        boolean again = true;

        while (again) {
            try {

                do {
                    System.out.println("Admin options");
                    System.out.println("1. Show all data");
                    System.out.println("2. Search rooms with apartment number");
                    System.out.println("3. Search rooms on address");
                    System.out.println("4. Search for room type");
                    System.out.println("5. Search for floor type");

                    numbers = keyboard.nextInt();
                    switch (numbers) {
                        case 1: {
                            printingApartment(list);
                            break;
                        }
                        case 2: {
                            List matchingResults = apartment.searchData(apartmentSearch());
                            printingApartment(matchingResults);
                            break;
                        }
                        case 3: {
                            List matchingResults = apartment.searchData(streetSearch());
                            printingApartment(matchingResults);
                        }
                        case 4: {
                            List matchingResults = apartment.searchData(roomTypeSearch());
                            printingApartment(matchingResults);
                        }
                        case 5: {
                            List matchingResults = apartment.searchData(streetSearch());
                            printingApartment(matchingResults);
                        }
                    }

                } while (numbers != 10);

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
    }

    private static RoomBuilder apartmentSearch() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter apt number:\n");
        String userInput = user.nextLine();
        Map properties = new HashMap<String, Object>();

        properties.put("aptNr", userInput);

        RoomBuilder roomToFind = new RoomBuilder(properties);
        return roomToFind;
    }

    private static RoomBuilder streetSearch() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter address:\n");
        String userInput = user.nextLine();
        Map properties = new HashMap<String, Object>();

        properties.put("address", userInput);

        RoomBuilder roomToFind = new RoomBuilder(properties);
        return roomToFind;
    }

    private static RoomBuilder roomTypeSearch() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter room type:\n");
        String userInput = user.nextLine();
        Map properties = new HashMap<String, Object>();

        properties.put("room", userInput);
        System.out.println(userInput);

        RoomBuilder roomToFind = new RoomBuilder(properties);
        return roomToFind;
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
                System.out.println("Apartment " + spec.getProperty("aptNr") + " @ " + spec.getProperty("address"));
                System.out.println(spec.getProperty("room") +
                        " with the following data:");

                // Iterating the properties of the rooms
                for (Iterator j = spec.getProperties().keySet().iterator();
                     j.hasNext(); ) {
                    String propertyName = (String) j.next();
                    if (propertyName.equals("room") || propertyName.equals("address") ||
                            propertyName.equals("aptNr")) // skip line
                        continue;
                    System.out.println("    " + propertyName + ": " +
                            spec.getProperty(propertyName));

                }
                System.out.println("    " + "size: " + room.getSize() + " sqm");
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("Empty list");
        }
    }

    private static void createComplex(Apartment apartment) {

        // Creating Rooms
        // Building up the properties for the room and put that in a map
        Map properties = new HashMap();
        //TODO USE SQL SERVER
        //TODO FIX SAVE TO FILE

//--------------------aptNr 25----------------------------------------
        properties.put("address", "Haga nygata 14");
        properties.put("aptNr", "25");
        properties.put("room", RoomType.ROOM1);
        properties.put("floor", FloorType.WOOD + " year:2003");// use regex to get the floor type or year
        properties.put("wall", "year:2015");
        properties.put("appliances", "none");

        apartment.addRoom(25, new RoomBuilder(properties));

        properties.put("address", "Haga nygata 14");
        properties.put("aptNr", "25");
        properties.put("room", RoomType.ROOM2);
        properties.put("floor", FloorType.WOOD + " year:2003");// use regex to get the floor type or year
        properties.put("wall", "year:2015");
        properties.put("appliances", "none");
        apartment.addRoom(15, new RoomBuilder(properties));

        properties.put("address", "Haga nygata 14");
        properties.put("aptNr", "25");
        properties.put("room", RoomType.KITCHEN);
        properties.put("floor", FloorType.WOOD + " year:2003");// use regex to get the floor type or year
        properties.put("wall", "year:2015");
        properties.put("appliances", Appliances.FRIDGE + " " + Appliances.STOVE);
        apartment.addRoom(15, new RoomBuilder(properties));

        properties.put("address", "Haga nygata 14");
        properties.put("aptNr", "25");
        properties.put("room", RoomType.BATHROOM);
        properties.put("floor", FloorType.TILES + " year:2003");// use regex to get the floor type or year
        properties.put("wall", "year:2015");
        properties.put("appliances", "none");
        apartment.addRoom(10, new RoomBuilder(properties));
//--------------------aptNr 26----------------------------------------
        properties.put("address", "Haga nygata 12");
        properties.put("aptNr", "28");
        properties.put("room", RoomType.ROOM1);
        properties.put("floor", FloorType.WOOD + " year:2003");// use regex to get the floor type or year
        properties.put("wall", "year:2015");
        properties.put("appliances", "none");

        apartment.addRoom(20, new RoomBuilder(properties));

        properties.put("address", "Haga nygata 12");
        properties.put("aptNr", "28");
        properties.put("room", RoomType.ROOM2);
        properties.put("floor", FloorType.WOOD + " year:2003");// use regex to get the floor type or year
        properties.put("wall", "year:2015");
        properties.put("appliances", "none");
        apartment.addRoom(14, new RoomBuilder(properties));

        properties.put("address", "Haga nygata 12");
        properties.put("aptNr", "28");
        properties.put("room", RoomType.KITCHEN);
        properties.put("floor", FloorType.WOOD + " year:2003");// use regex to get the floor type or year
        properties.put("wall", "year:2015");
        properties.put("appliances", Appliances.FRIDGE + " " + Appliances.STOVE);
        apartment.addRoom(12, new RoomBuilder(properties));

        properties.put("address", "Haga nygata 12");
        properties.put("aptNr", "28");
        properties.put("room", RoomType.BATHROOM);
        properties.put("floor", FloorType.TILES + " year:2003");//TODO use regex to get the floor type or year
        properties.put("wall", "year:2015");
        properties.put("appliances", "none");
        apartment.addRoom(11, new RoomBuilder(properties));

        // RoomBuilder roomToFind = new RoomBuilder(properties);
        // List matchingRooms = apartment.search(roomToFind);
    }

    private static class NegativeNumberException extends Throwable {

    }
}

package com.ag.controller;

import com.ag.dto.Guest;
import com.ag.dto.Hotel;
import com.ag.dto.Room;

import java.util.Scanner;

public class HotelClient {
    Guest[] guests = new Guest[20];
    Room[] rooms = new Room[8];
    Hotel[] hotel = new Hotel[5];

    int guests_count = 0;
    int rooms_count = 0;
    int hotel_count = 0;

    public Guest findGuestCheckedInRoom(int roomId) {

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomId) {
                if (room.getCheckedIn() != null) {
                    return room.getCheckedIn();
                }
            }
        }
        return null;
    }
    public int guestsCount() {
        int length = 0;
        for (Guest guest : guests) {
            if (guest != null) {
                length++;
            }
        }
        return length;
    }
    // add prices of rooms where guest is staying
    public double earningToday() {
        double totalEarnings = 0;
        for (Room room : rooms) {
            if (room.getCheckedIn() != null) {
                totalEarnings += room.getPricePerDay();
            }
        }
        return totalEarnings;
    }
    public Guest[] findAllGuests() {
        return guests;
    }

    public Room[] findAllRooms() {
        return rooms;
    }

    public void addGuests(Guest guest) {
        guests[guests_count] = guest;
        System.out.println("Guest added successfully");
        guests_count++;
    }

    public void addRooms(Room room) {
        rooms[rooms_count] = room;
        System.out.println("Room details added successfully");
        rooms_count++;
    }
    public Guest getGuestById(long gid) {
        for (Guest guest : guests) {
            if (guest != null) {
                if (guest.getGid() == gid) {
                    return guest;
                }
            }
        }
        return null;
    }

    public void updateRoomCheckedIn(int roomId, long gid) {
        Guest guest = getGuestById(gid);
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomId && guest != null) {
                if (room.getCheckedIn() == null) {
                    System.out.println("Before guest not alloted to room");
                    System.out.println(room);
                    room.setCheckedIn(guest);
                    System.out.println("After guest alloted room");
                    System.out.println(room);
                }
            }
        }
    }
    public static void main(String[] args) {

        HotelClient hotelClient = new HotelClient();
        Scanner sc = new Scanner(System.in);

        int option = 0;

        while (option != 8) {
            System.out.println("1) findGuestCheckedInRoom\n"
                    + "2) guestsCount\n"
                    + "3) earningToday\n"
                    + "4) findAllGuests\n"
                    + "5) addGuests\n"
                    + "6) addRooms\n"
                    + "7) updateRoomCheckedIn\n"
                    + "8) Exit\n");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter room id to check which guest is staying");
                    int roomId = sc.nextInt();

                    Guest findGuestCheckedInRoom = hotelClient.findGuestCheckedInRoom(roomId);
                    if (findGuestCheckedInRoom != null) {
                        System.out.println(findGuestCheckedInRoom);
                    } else {
                        System.out.println("In the given room id no one is staying present");
                    }
                    break;

                case 2:
                    int guestsCount = hotelClient.guestsCount();
                    System.out.println("present guests in the hotel are: " + guestsCount);
                    break;

                case 3:
                    double earningToday = hotelClient.earningToday();
                    System.out.println("Total ernings today: " + earningToday);
                    break;

                case 4:
                    Guest[] findAllGuests = hotelClient.findAllGuests();
                    boolean flag = true;
                    for (Guest guest : findAllGuests) {
                        if (guest != null) {
                            System.out.println(guest);
                            flag = false;
                        }
                    }
                    if (flag) {
                        System.out.println("Present no guest are there in the hotel");
                    }
                    break;

                case 5:
                    System.out.println("Enter guest id");
                    long gid = sc.nextLong();
                    System.out.println("Enter guest first name");
                    String gfirstname = sc.next();
                    System.out.println("Enter guest last name");
                    String glastname = sc.next();
                    System.out.println("Enter guest email id");
                    String gemailId = sc.next();

                    Guest guest = new Guest();
                    guest.setGid(gid);
                    guest.setGfirstName(gfirstname);
                    guest.setGlastName(glastname);
                    guest.setGemailId(gemailId);

                    hotelClient.addGuests(guest);
                    break;

                case 6:
                    System.out.println("Enter room number");
                    roomId = sc.nextInt();
                    System.out.println("Enter floor number");
                    int floorId = sc.nextInt();
                    System.out.println("Enter room type deluxe or normar");
                    String roomtype = sc.next();
                    System.out.println("Enter price per day for that room");
                    double pricePerDay = sc.nextDouble();

                    Room room = new Room();
                    room.setRoomNumber(roomId);
                    room.setFloor(floorId);
                    room.setRoomType(roomtype);
                    room.setPricePerDay(pricePerDay);
                    room.setCheckedIn(null);

                    hotelClient.addRooms(room);
                    break;

                case 7:
                    System.out.println("Enter guest id for alloting room");
                    gid = sc.nextLong();
                    System.out.println("Enter room id to allote which room");
                    roomId = sc.nextInt();

                    hotelClient.updateRoomCheckedIn(roomId, gid);
                    break;
            }
        }
        sc.close();
        System.out.println("Thank you");


    }
}

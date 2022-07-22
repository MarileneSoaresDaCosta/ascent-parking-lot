package com.galvanize;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.util.UUID.randomUUID;

public class ParkingLot {

    public int dailyFee = 3;
    private int maxSpaces;
    private int hourFee = 5;
    private HashMap<String, ArrayList<String>> tickets = new HashMap<>();
    private int[] spaces;
    // array of spaces - 0: empty , 1:busy
    // hashmap
    // key: ticketNum
    // value: [ spaceNum, allocation, time_entered, license, color]


    public ParkingLot(int n) {
        maxSpaces = n;
        spaces = new int[maxSpaces];
        System.out.println(Arrays.toString(spaces));
    }

    public int getMaxSpaces() {
        return this.spaces.length;
    }

    public int getCharge(int hours) {
        if (hours > 23) {
            return this.dailyFee * hours;
        }
        return this.hourFee * hours;
    }

    public int checkSpace(){
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i] == 0){
                spaces[i] = 1;
                return i + 1;
            }
        }
        return 0;
    }

    public void issueTicket( String license ,String color){
        ArrayList<String> ticket = new ArrayList<>();
        int space = checkSpace();
        if(space == 0){
            System.out.println("Parking full");
        }
        String ticketNum = String.valueOf(randomUUID());
        // check if ticketNum already exists
        ticket.add(String.valueOf(space));
        ticket.add(String.valueOf(LocalDateTime.now()));
        ticket.add(license);
        ticket.add(color);
        this.tickets.put(ticketNum, ticket);

    }

    public HashMap<String, ArrayList<String>> getTickets(){
        System.out.println("tickets: " + tickets);
        System.out.println("spaces: " + Arrays.toString(spaces));
        return tickets;
    }

     public void carExits(String ticketNumber, LocalDateTime exitTime) {
        //    lookup hash - retrieve info, and save to temp var, delete in hash
         // car info
         ArrayList<String> carInfo = tickets.get(ticketNumber);
         System.out.println(carInfo);
         // delete pair from HashMap
         tickets.remove(ticketNumber);
         // mark space as empty
         // space to empty:
         String spaceToEmpty= carInfo.get(0);
         this.spaces[Integer.valueOf(spaceToEmpty)] = 0;

         // calculate hours
         String timeOfEntryString = carInfo.get(1);
         LocalDateTime timeOfEntry = LocalDateTime.parse(timeOfEntryString);
         Duration duration = Duration.between(timeOfEntry, exitTime);
         System.out.println("duration: " + duration.toMinutes());
         long minutes = duration.toMinutes(); // 121
         int hours;
//         double hours = (Math.toIntExact(minutes));
        if(minutes % 60 == 0 ) {
            hours = (int) (minutes / 60);
        } else {
            hours = (int) (minutes / 60) + 1;
        }

         System.out.println("whole hours: " + hours);
         System.out.println("charge total: " + getCharge(hours));
}



}

// a new customer comes in: >> ticket:
// check if space is available: { 0, 1...]
// issueTicket(all...)
// "ticketNum, allocation, time_entered, license, color"
package com.galvanize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ParkingLot {
    // if num of hours > 12, dailyfee
    public int dailyFee = 3;
    private int maxSpaces;
    private int hourFee = 5;
    private HashMap<Integer, ArrayList<String>> tickets = new HashMap<>();
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

    // issueTicket(ticketNum, allocation, time_entered, license, color){
    // check if space exists
    // if so, changes avail
    // store ticket info -

    // if no space, return 'full'


    // carExits() {
//    lookup hash - retrieve info, mark space as empty
//}



}

// a new customer comes in: >> ticket:
// check if space is available: { 0, 1...]
// issueTicket(all...)
// "ticketNum, allocation, time_entered, license, color"
package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParkingLotTest {
    private ParkingLot parkingLot;

    @BeforeEach
    public void setUp() {
        this.parkingLot = new ParkingLot(8);
    }

    @Test
    public void shouldReturnMaxSpacesInParkingLot() {
        int expect = 8;
        int actual = parkingLot.getMaxSpaces();
        assertEquals(expect, actual);
    }

    @Test
    public void shouldReturnChargeZeroForLessThanOneHour() {
        int expect = 0;
        int actual = parkingLot.getCharge(0);
        assertEquals(expect, actual);
    }

    @Test
    public void shouldIssueATicketAndReturnTickets() {
        // issue ticket ("BA235X", "red")
        parkingLot.issueTicket("BA235X", "red");
        parkingLot.getTickets();
    }

    @Test
    public void shouldReturnMessageFullAfter9thCarEnters() {
        // issue ticket ("BA235X", "red")
        for (int i = 0; i < 9; i++) {
            parkingLot.issueTicket("BA235X", "red");
        }
        parkingLot.getTickets();  // shows full lot
    }

    @Test
    public void shouldUpdateHistoryAndPlacesWhenCarExits() {
        // cars enter
        for (int i = 0; i < 8; i++) {
            parkingLot.issueTicket("BA235X", "red");
        }
        // pick first ticket number
        Set<String> currentTicketsSet = parkingLot.getTickets().keySet();
        String[] currentTicketsArray = currentTicketsSet.toArray(new String[currentTicketsSet.size()]);
        System.out.println("first ticket car leaving " + currentTicketsArray[0]);
        // exitTime
        LocalDateTime exitTime = LocalDateTime.now().plusHours(2).plusMinutes(1);
        String carExitTicket = currentTicketsArray[0];
        parkingLot.carExits(carExitTicket, exitTime);
        boolean expect = false;
        boolean actual = parkingLot.getTickets().containsKey(carExitTicket);
        assertEquals(expect, actual);
    }

//     @Test
//     public void shouldReturnDailyFeeBasedOnHoursPassed() {
//         int expect = 72;
//         int actual = parkingLot.getCharge(24);
//         assertEquals(expect, actual);
//     }
}
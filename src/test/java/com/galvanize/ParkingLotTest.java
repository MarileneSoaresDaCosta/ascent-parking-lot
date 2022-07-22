package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


//}    @Test
//     public void shouldReturnDailyFeeBasedOnHoursPassed() {
//         int expect = 72;
//         int actual = parkingLot.getCharge(24);
//         assertEquals(expect, actual);
//     }
}
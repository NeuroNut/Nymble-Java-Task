package com.travel.travel.domain;

import com.travel.travel.enums.PassengerType;

public class PassengerFactory {
    public static Passenger createPassenger(PassengerType passengerType) {
        switch (passengerType) {
            case GOLD:
                return new GoldPassenger();
            case PREMIUM:
                return new PremiumPassenger();
            case STANDARD:
                return new StandardPassenger();
            default:
                throw new IllegalArgumentException("Invalid passenger type: " + passengerType);
        }
    }
}
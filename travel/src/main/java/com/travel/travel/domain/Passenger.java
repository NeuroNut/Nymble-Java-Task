package com.travel.travel.domain;

import com.travel.travel.enums.PassengerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a passenger in a travel package, containing information about their name,
 * passenger number, and a list of activities they are signed up for.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Passenger {
    /**
     * The name of the passenger.
     */
    private String name;

    /**
     * The balance of the passenger.
     */
    private Double passengerBalance;

    /**
     * The unique passenger number of the passenger.
     */
    private int passengerNumber;

    /**
     * The list of activities the passenger is signed up for.
     */
    private List<Activity> activities = new ArrayList<>();

    /**
     * Type of the passenger.
     */
    private PassengerType passengerType;

    /**
     * Constructor.
     *
     * @param name            name.
     * @param passengerNumber passengerNumber.
     */
    public Passenger(final String name, final int passengerNumber) {
        this.name = name;
        this.activities = new ArrayList<>();
        this.passengerNumber = passengerNumber;
    }

    public abstract void signUpForActivity(Activity activity);

    public abstract boolean canSignUpForActivity(Activity activity);

    public abstract void printPassengerDetails();
}

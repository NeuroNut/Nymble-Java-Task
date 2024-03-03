package com.travel.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an activity available at a destination in a travel package.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    /**
     * The name of the activity.
     */
    private String name;

    /**
     * The cost of participating in the activity.
     */
    private Double cost;

    /**
     * The maximum capacity of participants for the activity.
     */
    private Integer capacity;

    /**
     * A description of the activity.
     */
    private String description;

    /**
     * The number of available spaces for the activity.
     */
    private Integer availableSpaces;

    /**
     * Destination of the activity.
     */
    private String destination;

    /**
     * Constructor.
     *
     * @param name        activity name.
     * @param description activity description.
     * @param cost        activity cost.
     * @param capacity    activity capacity.
     */
    public Activity(String name, String description, Double cost, Integer capacity, String destination) {
        this.name = name;
        this.cost = cost;
        this.capacity = capacity;
        this.description = description;
        this.availableSpaces = capacity;
        this.destination = destination;
    }

    public void validateActivityInitialisation(Double cost, Integer capacity) {
        if (capacity == null) {
            throw new IllegalArgumentException("Activity capacity can not be null");
        }
        if (cost == null) {
            throw new IllegalArgumentException("Activity cost can not be null");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Activity capacity can not be less than 0");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Activity cost can not be less than 0");
        }
    }

    /**
     * Check if this activity can be signed up by some user.
     *
     * @return true/false
     */
    public boolean isActivityAvailableForSignUp() {
        return availableSpaces > 0;
    }

    /**
     * Sign up for the activity.
     */
    public void signUpForActivity() {
        availableSpaces--;
    }
}



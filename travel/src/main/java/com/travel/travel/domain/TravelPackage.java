package com.travel.travel.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.travel.travel.domain.Activity;
import com.travel.travel.domain.Destination;
import com.travel.travel.domain.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a travel package containing information about its name, passenger capacity,
 * list of passengers, and list of destinations.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelPackage {
    /**
     * The name of the travel package.
     */
    private String name;

    /**
     * The capacity of passengers the travel package can accommodate.
     */
    private Integer passengerCapacity;

    /**
     * The list of passengers enrolled in the travel package.
     */
    private List<Passenger> passengerList;

    /**
     * The list of destinations included in the travel package itinerary.
     */
    private List<Destination> destinationList;

    /**
     * Constructor for initialisation of travel package.
     *
     * @param name              name of the travel package.
     * @param passengerCapacity passenger capacity of the travel package.
     */
    public TravelPackage(final String name, final int passengerCapacity) {
        validateTravelPackageInitialisation(passengerCapacity);
        this.name = name;
        this.passengerList = new ArrayList<>();
        this.destinationList = new ArrayList<>();
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * This validates the initialisation of travel package.
     *
     * @param passengerCapacity passenger capacity of the travel package.
     */
    public void validateTravelPackageInitialisation(final int passengerCapacity) {
        if (passengerCapacity < 0) {
            throw new IllegalArgumentException("Failed to initialise TravelPackage. Field passengerCapacity can not be less than 0.");
        }
    }

    /**
     * Add the destination to the travel package.
     *
     * @param destination destination.
     */
    public void addDestination(final Destination destination) {
        if (Objects.isNull(destination)) {
            throw new IllegalArgumentException("destination of travel package can not be null");
        }
        this.destinationList.add(destination);
    }

    /**
     * Add a passenger to the travel package.
     *
     * @param passenger passenger.
     */
    public void addPassenger(final Passenger passenger) {
        if (Objects.isNull(passenger)) {
            throw new IllegalArgumentException("passenger of travel package can not be null");
        }
        if (passengerList.size() < passengerCapacity) {
            passengerList.add(passenger);
        } else {
            throw new RuntimeException("Can not add passenger. The travel package is already at full capacity.");
        }
    }

    /**
     * Remove a destination from the travel package.
     *
     * @param destination destination.
     */
    public void removeDestination(final Destination destination) {
        if (Objects.isNull(destination)) {
            throw new IllegalArgumentException("destination can not be null");
        }
        destinationList.remove(destination);
    }

    /**
     * Remove a passenger from the travel package.
     *
     * @param passenger passenger.
     */
    public void removePassenger(final Passenger passenger) {
        if (Objects.isNull(passenger)) {
            throw new IllegalArgumentException("passenger can not be null");
        }
        passengerList.remove(passenger);
    }

    /**
     * Print Itinerary of travel package.
     */
    public void printItinerary() {
        System.out.println("Travel Package name: " + name);
        for (Destination destination : destinationList) {
            System.out.println("Destination name: " + destination.getName());
            destination.printActivities();
            System.out.println("------- destination details done ---------");
        }
    }

    /**
     * Print passenger list of the travel package.
     */
    public void printPassengerList() {
        System.out.println("Travel Package name: " + name + ", passengerCapacity: " + passengerCapacity + ", current passenger count: " + passengerList.size());
        for (Passenger passenger : passengerList) {
            System.out.println("Passenger name: " + passenger.getName() + ", number: " + passenger.getPassengerNumber());
        }
    }

    /**
     * This function prints all the activities inside the travel package which have spaces left.
     */
    public void printActivitiesWithAvailableSpaces() {
        for (Destination destination : destinationList) {
            for (Activity activity : destination.getActivityList()) {
                if (!Objects.isNull(activity.getAvailableSpaces()) && activity.getAvailableSpaces() > 0) {
                    System.out.println("Activity name: " + activity.getName() + ", spaces available: " + activity.getAvailableSpaces());
                }
            }
        }
    }
}


package com.travel.travel;

import com.travel.travel.domain.*;

import java.util.Arrays;
import java.util.List;

import static com.travel.travel.enums.PassengerType.*;

public class TravelDriver {
    public static void main(String args[]) {
        // Initialising Activities.
        Activity activity1 = new Activity("Hiking", "Explore nature trails", 10.0, 2, "Shimla");
        Activity activity2 = new Activity("Sightseeing Tour", "Guided tour of historical landmarks", 10.0, 2, "Shimla");
        Activity activity3 = new Activity("Scuba Diving", "Dive into coral reefs", 10.0, 2, "Jammu");
        Activity activity4 = new Activity("Camping", "Camp under the stars", 10.0, 2, "Jammu");
        Activity activity5 = new Activity("Cooking Class", "Learn to cook local cuisine", 10.0, 2, "Manali");
        Activity activity6 = new Activity("Photography Workshop", "Capture stunning landscapes", 10.0, 2, "Manali");

        List<Activity> activityList1 = Arrays.asList(activity1, activity2);
        List<Activity> activityList2 = Arrays.asList(activity3, activity4);
        List<Activity> activityList3 = Arrays.asList(activity5, activity6);

        // Initialising Destinations.
        Destination destination1 = new Destination("Shimla", activityList1);
        Destination destination2 = new Destination("Jammu", activityList2);
        Destination destination3 = new Destination("Manali", activityList3);

        // Initialising Passengers.
        Passenger passenger1 = PassengerFactory.createPassenger(STANDARD);
        Passenger passenger2 = PassengerFactory.createPassenger(GOLD);
        Passenger passenger3 = PassengerFactory.createPassenger(PREMIUM);
        passenger1.setName("p1");
        passenger2.setName("p2");
        passenger3.setName("p3");
        passenger1.setPassengerBalance(100D);
        passenger2.setPassengerBalance(100D);
        passenger3.setPassengerBalance(100D);
        passenger1.setPassengerNumber(1);
        passenger2.setPassengerNumber(2);
        passenger3.setPassengerNumber(3);
        passenger1.signUpForActivity(activity1);
        passenger1.signUpForActivity(activity2);
        passenger2.signUpForActivity(activity3);
        passenger2.signUpForActivity(activity4);
        passenger3.signUpForActivity(activity5);
        passenger3.signUpForActivity(activity6);
        List<Passenger> passengerList = Arrays.asList(passenger1, passenger2, passenger3);

        // Initialising TravelPackage.
        TravelPackage travelPackage = new TravelPackage("India travel package", 10);
        travelPackage.setDestinationList(Arrays.asList(destination1, destination2, destination3));
        travelPackage.setPassengerList(passengerList);

        System.out.println("--- Travel itinerary --- ");

        // 1st requirement.
        travelPackage.printItinerary();

        System.out.println("--- Passenger list --- ");

        // 2nd requirement.
        travelPackage.printPassengerList();

        System.out.println("--- Passenger details --- ");

        // 3rd requirement.
        for (Passenger passenger : travelPackage.getPassengerList()) {
            passenger.printPassengerDetails();
        }

        System.out.println("--- Activity with available spaces printing --- ");

        // 4th requirement.
        travelPackage.printActivitiesWithAvailableSpaces();
    }
}

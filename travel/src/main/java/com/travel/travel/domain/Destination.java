package com.travel.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a destination in a travel package, containing information about its name
 * and a list of activities available at that destination.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
    /**
     * The name of the destination.
     */
    private String name;

    /**
     * The list of activities available at this destination.
     */
    private List<Activity> activityList;

    /**
     * Constructs a new Destination with the given name and an empty list of activities.
     *
     * @param name The name of the destination.
     */
    public Destination(String name) {
        this.name = name;
        this.activityList = new ArrayList<>();
    }

    /**
     * Adds an activity to the list of activities available at this destination.
     *
     * @param activity The activity to add.
     */
    public void addActivity(Activity activity) {
        activity.setDestination(this.name);
        activityList.add(activity);
    }

    /**
     * Prints the list of activities available at this destination.
     */
    public void printActivities() {
        for (Activity activity : activityList) {
            System.out.println("Activity name: " + activity.getName());
            System.out.println("Capacity: " + activity.getCapacity());
            System.out.println("Activity cost: " + activity.getCost());
            System.out.println("Description: " + activity.getDescription());
            System.out.println("Destination: " + activity.getDestination());
        }
    }
}

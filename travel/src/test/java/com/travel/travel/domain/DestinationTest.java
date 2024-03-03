package com.travel.travel.domain;

import com.travel.travel.ConsoleOutputCapture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DestinationTest {

    private Destination destination;

    @BeforeEach
    public void setUp() {
        destination = new Destination("Test Destination");
    }

    @Test
    public void testAddActivity() {
        // Arrange
        Activity activity = new Activity("Test Activity", "Description", 50.0, 10, "destination");

        // Act
        destination.addActivity(activity);

        // Assert
        List<Activity> activityList = destination.getActivityList();
        assertEquals(1, activityList.size());
        assertEquals("Test Activity", activityList.get(0).getName());
        assertEquals("Description", activityList.get(0).getDescription());
        assertEquals(50.0, activityList.get(0).getCost());
        assertEquals(10, (int) activityList.get(0).getCapacity());
        assertEquals("Test Destination", activityList.get(0).getDestination());
    }

    @Test
    public void testPrintActivities() {
        // Arrange
        Activity activity1 = new Activity("Activity 1", "Description 1", 50.0, 10, "destination");
        Activity activity2 = new Activity("Activity 2", "Description 2", 60.0, 15, "destination");
        destination.addActivity(activity1);
        destination.addActivity(activity2);

        // Act (Capturing console output for assertion)
        ConsoleOutputCapture outputCapture = new ConsoleOutputCapture();
        outputCapture.startCapture();
        destination.printActivities();
        outputCapture.stopCapture();

        // Assert
        String[] lines = outputCapture.getCapturedOutput().split(System.lineSeparator());
        assertEquals(10, lines.length);
        assertEquals("Activity name: Activity 1", lines[0]);
        assertEquals("Capacity: 10", lines[1]);
        assertEquals("Activity cost: 50.0", lines[2]);
        assertEquals("Description: Description 1", lines[3]);
        assertEquals("Destination: Test Destination", lines[4]);
        assertEquals("Activity name: Activity 2", lines[5]);
        assertEquals("Capacity: 15", lines[6]);
        assertEquals("Activity cost: 60.0", lines[7]);
        assertEquals("Description: Description 2", lines[8]);
        assertEquals("Destination: Test Destination", lines[9]);
    }
}

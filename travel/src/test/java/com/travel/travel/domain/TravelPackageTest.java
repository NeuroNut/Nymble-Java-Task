package com.travel.travel.domain;

import com.travel.travel.ConsoleOutputCapture;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.travel.travel.enums.PassengerType.GOLD;
import static com.travel.travel.enums.PassengerType.PREMIUM;
import static org.junit.jupiter.api.Assertions.*;

public class TravelPackageTest {

    @Test
    public void testConstructor_InitializesFieldsCorrectly() {
        // Arrange
        String name = "Test Package";
        int passengerCapacity = 10;

        // Act
        TravelPackage travelPackage = new TravelPackage(name, passengerCapacity);

        // Assert
        assertEquals(name, travelPackage.getName());
        assertEquals(passengerCapacity, travelPackage.getPassengerCapacity());
        assertNotNull(travelPackage.getPassengerList());
        assertNotNull(travelPackage.getDestinationList());
        assertEquals(0, travelPackage.getPassengerList().size());
        assertEquals(0, travelPackage.getDestinationList().size());
    }

    @Test
    public void testAddDestination_AddsDestinationToList() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Test Destination");

        // Act
        travelPackage.addDestination(destination);

        // Assert
        assertEquals(1, travelPackage.getDestinationList().size());
        assertTrue(travelPackage.getDestinationList().contains(destination));
    }

    @Test
    public void testAddDestination_NullDestination_ThrowsIllegalArgumentException() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> travelPackage.addDestination(null));
    }

    @Test
    public void testAddPassenger_AddsPassengerToList() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 1);
        Passenger passenger = PassengerFactory.createPassenger(GOLD);

        // Act
        travelPackage.addPassenger(passenger);

        // Assert
        assertEquals(1, travelPackage.getPassengerList().size());
        assertTrue(travelPackage.getPassengerList().contains(passenger));
    }

    @Test
    public void testAddPassenger_NullPassenger_ThrowsIllegalArgumentException() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> travelPackage.addPassenger(null));
    }

    @Test
    public void testAddPassenger_AtCapacity_ThrowsRuntimeException() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 1);
        Passenger passenger1 = PassengerFactory.createPassenger(GOLD);
        Passenger passenger2 = PassengerFactory.createPassenger(PREMIUM);
        travelPackage.addPassenger(passenger1);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> travelPackage.addPassenger(passenger2));
    }

    @Test
    public void testRemoveDestination_RemovesDestinationFromList() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Test Destination");
        travelPackage.addDestination(destination);

        // Act
        travelPackage.removeDestination(destination);

        // Assert
        assertEquals(0, travelPackage.getDestinationList().size());
        assertFalse(travelPackage.getDestinationList().contains(destination));
    }

    @Test
    public void testRemoveDestination_NullDestination_ThrowsIllegalArgumentException() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> travelPackage.removeDestination(null));
    }

    @Test
    public void testRemovePassenger_RemovesPassengerFromList() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Passenger passenger = PassengerFactory.createPassenger(PREMIUM);
        travelPackage.addPassenger(passenger);

        // Act
        travelPackage.removePassenger(passenger);

        // Assert
        assertEquals(0, travelPackage.getPassengerList().size());
        assertFalse(travelPackage.getPassengerList().contains(passenger));
    }

    @Test
    public void testRemovePassenger_NullPassenger_ThrowsIllegalArgumentException() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> travelPackage.removePassenger(null));
    }

    @Test
    public void testPrintItinerary_PrintsItineraryCorrectly() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination1 = new Destination("Destination 1");
        Destination destination2 = new Destination("Destination 2");
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        // Act
        // Redirect console output for testing
        ConsoleOutputCapture consoleOutputCapture = new ConsoleOutputCapture();
        consoleOutputCapture.captureConsoleOutput(() -> travelPackage.printItinerary());

        // Assert
        String expectedOutput = "Travel Package name: Test Package\n" +
                "Destination name: Destination 1\n" +
                "------- destination details done ---------\n" +
                "Destination name: Destination 2\n" +
                "------- destination details done ---------";
        assertEquals(expectedOutput, consoleOutputCapture.getCapturedOutput());
    }

    @Test
    public void testPrintPassengerList_PrintsPassengerListCorrectly() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Passenger passenger1 = PassengerFactory.createPassenger(PREMIUM);
        passenger1.setPassengerNumber(1);
        passenger1.setName("Passenger 1");
        Passenger passenger2 = PassengerFactory.createPassenger(PREMIUM);
        passenger2.setPassengerNumber(2);
        passenger2.setName("Passenger 2");
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        // Act
        // Redirect console output for testing
        ConsoleOutputCapture consoleOutputCapture = new ConsoleOutputCapture();
        consoleOutputCapture.captureConsoleOutput(() -> travelPackage.printPassengerList());

        // Assert
        String expectedOutput = "Travel Package name: Test Package, passengerCapacity: 10, current passenger count: 2\n" +
                "Passenger name: Passenger 1, number: 1\n" +
                "Passenger name: Passenger 2, number: 2";
        assertEquals(expectedOutput, consoleOutputCapture.getCapturedOutput());
    }

    @Test
    public void testPrintActivitiesWithAvailableSpaces_PrintsActivitiesCorrectly() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Destination");
        Activity activity1 = new Activity("Activity 1", "Description 1", 50.0, 5, "Destination");
        Activity activity2 = new Activity("Activity 2", "Description 2", 60.0, 0, "Destination");
        destination.addActivity(activity1);
        destination.addActivity(activity2);
        travelPackage.addDestination(destination);

        // Act
        // Redirect console output for testing
        ConsoleOutputCapture consoleOutputCapture = new ConsoleOutputCapture();
        consoleOutputCapture.captureConsoleOutput(() -> travelPackage.printActivitiesWithAvailableSpaces());

        // Assert
        String expectedOutput = "Activity name: Activity 1, spaces available: 5";
        assertEquals(expectedOutput, consoleOutputCapture.getCapturedOutput());
    }

    @Test
    public void testValidateTravelPackageInitialisation_ValidCapacity() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage();

        // Act & Assert
        assertDoesNotThrow(() -> travelPackage.validateTravelPackageInitialisation(10));
    }

    @Test
    public void testValidateTravelPackageInitialisation_NegativeCapacity_ThrowsIllegalArgumentException() {
        // Arrange
        TravelPackage travelPackage = new TravelPackage();

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> travelPackage.validateTravelPackageInitialisation(-5));
        assertEquals("Failed to initialise TravelPackage. Field passengerCapacity can not be less than 0.",
                exception.getMessage());
    }
}

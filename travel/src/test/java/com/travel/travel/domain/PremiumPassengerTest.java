package com.travel.travel.domain;

import com.travel.travel.ConsoleOutputCapture;
import org.junit.jupiter.api.Test;

import static com.travel.travel.enums.PassengerType.PREMIUM;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PremiumPassengerTest {

    @Test
    public void testSignUpForActivity_SuccessfulSignUp() {
        // Arrange
        Passenger passenger = PassengerFactory.createPassenger(PREMIUM);
        passenger.setPassengerBalance(50D);
        Activity activity = mock(Activity.class);
        when(activity.isActivityAvailableForSignUp()).thenReturn(true);
        when(activity.getCost()).thenReturn(50.0);

        // Act
        passenger.signUpForActivity(activity);

        // Assert
        assertEquals(1, passenger.getActivities().size());
    }

    @Test
    public void testSignUpForActivity_ThrowsExceptionWhenNoSpacesAvailable() {
        // Arrange
        Passenger passenger = PassengerFactory.createPassenger(PREMIUM);
        Activity activity = mock(Activity.class);
        when(activity.isActivityAvailableForSignUp()).thenReturn(false);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> passenger.signUpForActivity(activity));
    }

    @Test
    public void testCanSignUpForActivity_ReturnsTrueWhenSufficientBalance() {
        // Arrange
        Passenger passenger = PassengerFactory.createPassenger(PREMIUM);
        passenger.setPassengerBalance(45D);
        Activity activity = mock(Activity.class);
        when(activity.getCost()).thenReturn(50.0);

        // Act & Assert
        assertTrue(passenger.canSignUpForActivity(activity));
    }

    @Test
    public void testPrintPassengerDetails_PrintsCorrectDetails() {
        // Arrange
        Passenger passenger = PassengerFactory.createPassenger(PREMIUM);
        passenger.setName("John Doe");
        passenger.setPassengerNumber(123);
        passenger.setPassengerBalance(500.0);

        Activity activity1 = mock(Activity.class);
        when(activity1.getName()).thenReturn("Activity 1");
        when(activity1.getDestination()).thenReturn("Destination 1");
        when(activity1.getCost()).thenReturn(50.0);

        Activity activity2 = mock(Activity.class);
        when(activity2.getName()).thenReturn("Activity 2");
        when(activity2.getDestination()).thenReturn("Destination 2");
        when(activity2.getCost()).thenReturn(60.0);

        passenger.getActivities().add(activity1);
        passenger.getActivities().add(activity2);

        // Act
        ConsoleOutputCapture consoleOutputCapture = new ConsoleOutputCapture();
        consoleOutputCapture.captureConsoleOutput(() -> passenger.printPassengerDetails());
        String consoleOutput = consoleOutputCapture.getCapturedOutput();

        // Assert
        assertTrue(consoleOutput.contains("Passenger name: John Doe"));
        assertTrue(consoleOutput.contains("number: 123"));
        assertTrue(consoleOutput.contains("Activity name: Activity 1"));
        assertTrue(consoleOutput.contains("Activity destination: Destination 1"));
        assertTrue(consoleOutput.contains("Cost paid by the customer = 0"));
        assertTrue(consoleOutput.contains("Activity name: Activity 2"));
        assertTrue(consoleOutput.contains("Activity destination: Destination 2"));
        assertTrue(consoleOutput.contains("Cost paid by the customer = 0"));
    }
}



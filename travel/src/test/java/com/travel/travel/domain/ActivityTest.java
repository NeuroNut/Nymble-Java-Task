package com.travel.travel.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {
    @Test
    public void testIsActivityAvailableForSignUp_TrueWhenAvailableSpacesGreaterThanZero() {
        // Arrange
        Activity activity = new Activity();
        activity.setAvailableSpaces(5);

        // Act
        boolean result = activity.isActivityAvailableForSignUp();

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsActivityAvailableForSignUp_FalseWhenAvailableSpacesEqualToZero() {
        // Arrange
        Activity activity = new Activity();
        activity.setAvailableSpaces(0);

        // Act
        boolean result = activity.isActivityAvailableForSignUp();

        // Assert
        assertFalse(result);
    }

    @Test
    public void testSignUpForActivity_DecrementsAvailableSpacesByOne() {
        // Arrange
        Activity activity = new Activity();
        activity.setAvailableSpaces(5);

        // Act
        activity.signUpForActivity();

        // Assert
        assertEquals(4, (int) activity.getAvailableSpaces());
    }

    @Test
    public void testValidateActivityInitialisation_ThrowsExceptionWhenCapacityIsNull() {
        // Arrange
        Activity activity = new Activity();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            activity.validateActivityInitialisation(100.0, null);
        });
    }

    @Test
    public void testValidateActivityInitialisation_ThrowsExceptionWhenCostIsNull() {
        // Arrange
        Activity activity = new Activity();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            activity.validateActivityInitialisation(null, 10);
        });
    }

    @Test
    public void testValidateActivityInitialisation_ThrowsExceptionWhenCapacityIsNegative() {
        // Arrange
        Activity activity = new Activity();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            activity.validateActivityInitialisation(100.0, -5);
        });
    }

    @Test
    public void testValidateActivityInitialisation_ThrowsExceptionWhenCostIsNegative() {
        // Arrange
        Activity activity = new Activity();

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            activity.validateActivityInitialisation(-50.0, 10);
        });
    }
}

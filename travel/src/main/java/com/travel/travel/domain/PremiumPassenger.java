package com.travel.travel.domain;

import static com.travel.travel.enums.PassengerType.*;

public class PremiumPassenger extends Passenger {
    public PremiumPassenger() {
        setPassengerType(PREMIUM);
    }

    @Override
    public void signUpForActivity(Activity activity) {
        if (activity.isActivityAvailableForSignUp() && canSignUpForActivity(activity)) {
            activity.signUpForActivity();
            getActivities().add(activity);
        } else {
            throw new RuntimeException("Cannot sign up for activity. No spaces available inside activity or insufficient user balance");
        }
    }

    @Override
    public boolean canSignUpForActivity(Activity activity) {
        return true;
    }

    @Override
    public void printPassengerDetails() {
        System.out.println("Passenger name: " + getName() + ", number: " + getPassengerNumber());
        for (Activity activity : getActivities()) {
            System.out.println("Activity name: " + activity.getName());
            System.out.println("Activity destination: " + activity.getDestination());
            System.out.println("Cost paid by the customer = " + 0);
        }
    }
}

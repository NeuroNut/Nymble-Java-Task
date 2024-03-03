package com.travel.travel.domain;

import static com.travel.travel.enums.PassengerType.GOLD;

public class GoldPassenger extends Passenger {

    public GoldPassenger() {
        setPassengerType(GOLD);
    }

    @Override
    public void signUpForActivity(Activity activity) {
        if (activity.isActivityAvailableForSignUp() && canSignUpForActivity(activity)) {
            activity.signUpForActivity();
            getActivities().add(activity);
            setPassengerBalance(getPassengerBalance() - (activity.getCost() * 0.9));
        } else {
            throw new RuntimeException("Cannot sign up for activity. No spaces available inside activity or insufficient user balance");
        }
    }

    @Override
    public boolean canSignUpForActivity(Activity activity) {
        return activity.getCost() <= 0 || activity.getCost() * 0.9 <= getPassengerBalance();
    }

    @Override
    public void printPassengerDetails() {
        System.out.println("Passenger name: " + getName() + ", number: " + getPassengerNumber() + ", passengerBalance: " + getPassengerBalance());
        for (Activity activity : getActivities()) {
            System.out.println("Activity name: " + activity.getName());
            System.out.println("Activity destination: " + activity.getDestination());
            System.out.println("Cost paid by the customer = " + activity.getCost() * 0.9);
        }
    }
}

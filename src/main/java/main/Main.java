package main;

import main.metrics.Acceleration;
import main.metrics.Distance;
import main.metrics.Duration;

public class Main {

    public static void main(String[] args) {
        SpaceMathService spaceMathService = new SpaceMathService();

        // What? The Expanse mentions longer trips, but it seems they are wrong?
        // MARS
        Duration tripToMarsLowSpeed = spaceMathService.calculateTripDuration(Acceleration.G(0.33), Distance.AU(0.33));
        System.out.println("A trip to Mars at 0.33G takes: " + tripToMarsLowSpeed.toString());

        Duration tripToMarsRegularSpeed = spaceMathService.calculateTripDuration(Acceleration.G(1), Distance.AU(0.33));
        System.out.println("A trip to Mars at 1G takes: " + tripToMarsRegularSpeed.toString());

        // JUPITER
        Duration tripToJupiterLowSpeed = spaceMathService.calculateTripDuration(Acceleration.G(0.33), Distance.AU(10));
        System.out.println("A trip to Jupiter at 0.33G takes: " + tripToJupiterLowSpeed.toString());

        Duration tripToJupiterHighSpeed = spaceMathService.calculateTripDuration(Acceleration.G(1), Distance.AU(10));
        System.out.println("A trip to Jupiter at 1G takes: " + tripToJupiterHighSpeed.toString());

        // PLUTO
        Duration tripToPlutoLowSpeed = spaceMathService.calculateTripDuration(Acceleration.G(0.33), Distance.AU(40));
        System.out.println("A trip to Pluto at 0.33G takes: " + tripToPlutoLowSpeed.toString());

        Duration tripToPlutoHighSpeed = spaceMathService.calculateTripDuration(Acceleration.G(1), Distance.AU(40));
        System.out.println("A trip to Pluto at 1G takes: " + tripToPlutoHighSpeed.toString());

        // BELANGRIJK:
        //        https://en.wikipedia.org/wiki/Lorentz_transformation
        //        v2/c2
        //https://en.wikipedia.org/wiki/Lorentz_factor
    }
}


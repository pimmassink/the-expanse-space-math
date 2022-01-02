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


        Duration tripToPlutoLowSpeed2 = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.Mss(3), Distance.AU(40));
        System.out.println("A SINGLE trip to Pluto at 3MSS takes: " + tripToPlutoLowSpeed2.toString());

        Duration tripToPlutoHighSpeed2 = spaceMathService.calculateTripDurationWithoutBreaking(Acceleration.Mss(10), Distance.AU(40));
        System.out.println("A SINGLE trip to Pluto at 10MSS takes: " + tripToPlutoHighSpeed2.toString());


        Duration t1 = spaceMathService.calculateTripDuration(Acceleration.Mss(10), Distance.Meters(125));
        System.out.println("A trip at 3MSS takes: " + t1.toString());

        Duration t2 = spaceMathService.calculateTripDuration(Acceleration.Mss(30), Distance.Meters(125));
        System.out.println("A trip at 10MSS takes: " + t2.toString());

        Distance d1 = spaceMathService.distanceTravelled(Acceleration.Mss(10), Duration.Weeks(2));
        Distance d2 = spaceMathService.distanceTravelled(Acceleration.Mss(30), Duration.Weeks(2));

        System.out.println("d1: " + d1);
        System.out.println("d2: " + d2);


        // BELANGRIJK:
        //        https://en.wikipedia.org/wiki/Lorentz_transformation
        //        v2/c2
        //https://en.wikipedia.org/wiki/Lorentz_factor
    }
}


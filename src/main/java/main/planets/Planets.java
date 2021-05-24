package main.java.com.company.planets;

public class Planets {

    public static class Earth implements Planet {
        public static double getDistance() {
            return 1;
        }
    }

    public static class Mars implements Planet {
        public static double getDistance() {
            return 1.524;
        }
    }

}

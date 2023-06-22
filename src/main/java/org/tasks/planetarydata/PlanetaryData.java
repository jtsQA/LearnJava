package org.tasks.planetarydata;

import java.util.List;
import java.util.Set;

public class PlanetaryData {
    public static void main(String[] args) {
        SolarSystem solarSystem = new SolarSystem();

        System.out.println("\nUsing Streams:");
        // Retrieve count of moons of all planets having rings using streams
        int moonCountA = solarSystem.getCountOfMoonsWithRingsA();
        System.out.println("Count of moons of all planets having rings: " + moonCountA);

        // Retrieve the gas that is found on maximum planets using streams
        List<String> gasWithMaximumPlanetsA = solarSystem.getGasWithMaximumPlanetsA();
        System.out.println("Gas found on maximum planets: " + gasWithMaximumPlanetsA);

        System.out.println("\nUsing Loops:");
        // Retrieve count of moons of all planets having rings
        int moonCountB = solarSystem.getCountOfMoonsWithRingsB();
        System.out.println("Count of moons of all planets having rings: " + moonCountB);

        // Retrieve the gas that is found on maximum planets
        Set<String> gasWithMaximumPlanetsB = solarSystem.getGasWithMaximumPlanetsB();
        System.out.println("Gas found on maximum planets: " + gasWithMaximumPlanetsB);
    }
}

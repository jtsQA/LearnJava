package org.tasks.planetarydata;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SolarSystem {

    private List<Planet> planetsA;
    private Planet[] planetsB;

    public SolarSystem() {
        // Planets details added using List
        planetsA = new ArrayList<>();

        // Add planets to the solar system
        planetsA.add(new Planet("Mercury", new ArrayList<>(), 0, false));
        planetsA.add(new Planet("Venus", List.of("Carbon Dioxide", "Nitrogen"), 0, false));
        planetsA.add(new Planet("Earth", List.of("Nitrogen", "Oxygen"), 1, false));
        planetsA.add(new Planet("Jupiter", List.of("Hydrogen", "Helium"), 79, true));
        planetsA.add(new Planet("Saturn", List.of("Hydrogen", "Helium"), 83, true));
        planetsA.add(new Planet("Uranus", List.of("Hydrogen", "Helium", "Methane"), 27, true));


        // Planets details added in an Array
        planetsB = new Planet[6];

        // Add planets to the solar system
        planetsB[0] = new Planet("Mercury", new ArrayList<>(), 0, false);
        planetsB[1] = new Planet("Venus", List.of("Carbon Dioxide", "Nitrogen"), 0, false);
        planetsB[2] = new Planet("Earth", List.of("Nitrogen", "Oxygen"), 1, false);
        planetsB[3] = new Planet("Jupiter", List.of("Hydrogen", "Helium"), 79, true);
        planetsB[4] = new Planet("Saturn", List.of("Hydrogen", "Helium"), 83, true);
        planetsB[5] = new Planet("Uranus", List.of("Hydrogen", "Helium", "Methane"), 27, true);
    }

    public int getCountOfMoonsWithRingsA() {
        return planetsA.stream()
                .filter(Planet::hasRings)
                .mapToInt(Planet::numberOfMoons)
                .sum();
    }

    public int getCountOfMoonsWithRingsB() {
        int count = 0;
        for (Planet planet : planetsB) {
            if (planet.hasRings()) {
                count += planet.numberOfMoons();
            }
        }
        return count;
    }

    public List<String> getGasWithMaximumPlanetsA() {
        Map<String, Long> gasCountMap = planetsA.stream()
                .flatMap(planet -> planet.atmosphericGasses().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long maxCount = gasCountMap.values().stream()
                .max(Long::compare)
                .orElse(0L);

        return gasCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    
    public Set<String> getGasWithMaximumPlanetsB() {
        Map<String, Integer> gasCountMap = new HashMap<>();
        for (Planet planet : planetsB) {
            List<String> atmosphericGasses = planet.atmosphericGasses();
            for (String gas : atmosphericGasses) {
                gasCountMap.put(gas, gasCountMap.getOrDefault(gas, 0) + 1);
            }
        }

        Set<String> gasesWithMaxPlanets = new HashSet<>();
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : gasCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                gasesWithMaxPlanets.clear();
                gasesWithMaxPlanets.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                gasesWithMaxPlanets.add(entry.getKey());
            }
        }

        return gasesWithMaxPlanets;
    }


}

package org.tasks.planetarydata;

import java.util.List;

record Planet(String name, List<String> atmosphericGasses, int numberOfMoons, boolean hasRings) {

    public Planet(String name, List<String> atmosphericGasses, int numberOfMoons, boolean hasRings) {
        this.name = name;
        this.atmosphericGasses = atmosphericGasses;
        this.numberOfMoons = numberOfMoons;
        this.hasRings = hasRings;
    }
}

package org.tasks;

public class MinimumPlatformsRequired {

    public static void main(String[] args) {
        int[] arrivalTimes = {1300, 1400, 1530, 1700, 1740, 2250};
        int[] departureTimes = {1330, 1410, 1800, 1830, 1805, 2315};
        int minPlatforms = findMinPlatforms(arrivalTimes, departureTimes);
        System.out.println("Minimum no: of platforms required: " + minPlatforms);
    }

    public static int findMinPlatforms(int[] arrivalTimes, int[] departureTimes) {
        int platformsRequired = 1; // to calculate the required platform
        int minPlatform = 1; // atleast 1 platform is required
        int i = 1; // for arrival
        int j = 0; // for departure
        while (i < arrivalTimes.length && j < departureTimes.length) {
            if (arrivalTimes[i] <= departureTimes[j]) {
                platformsRequired++; // incremented as train arrived before a departure
                i++;
            } else {
                platformsRequired--; // decremented as train departed before next arrival
                j++;
            }
            minPlatform = Math.max(minPlatform, platformsRequired);
        }
        return minPlatform;
    }

}

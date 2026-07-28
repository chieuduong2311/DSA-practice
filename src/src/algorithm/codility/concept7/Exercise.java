package algorithm.codility.concept7;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    public static class ResourceState {
        public int[] availabilityTime;
        public int[] remainingCapacity;

        public ResourceState(int numResources, int[] initialCapacity) {
            this.availabilityTime = new int[numResources];
            this.remainingCapacity = initialCapacity.clone();
        }
    }
    public static ResourceState initializeResourceState(int numResources, int[] capacitites) {
        return null;
    }

    public static List<Integer> getAvailableResources(ResourceState state, int currentTime) {
        return new ArrayList<>();
    }

    public static int findFirstValidResource(List<Integer> available, ResourceState state, int required) {
        return  -1;
    }

    public static boolean detectDeadlock(List<Integer> available, ResourceState state, int required) {
        return false;
    }

    public static int getNextAvailability(ResourceState state, int currentTime) {
        return 0;
    }

    public static void updateResourceState(ResourceState state, int resIdx, int endTime, int used) {

    }

    public static int calculateWaitTime(int startTime, int queueTime) {
        return 0;
    }

    public static int trackQueuePosotion(int currentTime, int duration) {
        return 0;
    }

    public static int processSingleRequest(ResourceState state, int queueTime, int duration, int required, int currentTime) {
        return 0;
    }

    public static int[] completeResourceAllocation(int[][] requests, int numResources, int[] capacities) {
        return new int[0];
    }
}

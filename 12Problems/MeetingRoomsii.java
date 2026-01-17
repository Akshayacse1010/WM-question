class Solution {

    // Idea:
    // Sort meetings by start time.
    // Use a min-heap to track the meeting that ends the earliest.
    // If the current meeting starts after the earliest ending one,
    // we can reuse that room; otherwise, allocate a new room.
    public int minMeetingRooms(int[][] intervals) {

        // Sort intervals by start time
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

        // Min-heap ordered by meeting end time
        // Each element represents a meeting currently occupying a room
        Queue<int[]> minHeap =
                new PriorityQueue<>((interval1, interval2) -> interval1[1] - interval2[1]);

        // Process meetings in increasing start time order
        for (int index = 0; index < intervals.length; index++) {

            int[] currentInterval = intervals[index];

            // If the room with the earliest ending meeting is free,
            // reuse that room (remove it from the heap)
            if (!minHeap.isEmpty() && currentInterval[0] >= minHeap.peek()[1]) {
                minHeap.poll();
            }

            // Allocate a room for the current meeting
            minHeap.add(currentInterval);
        }

        // Number of rooms required equals the maximum size of the heap
        return minHeap.size();
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(n) for the heap

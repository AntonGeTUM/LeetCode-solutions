import java.util.TreeMap;

public class MyCalendarI {

    /**
     * Create a class called MyCalendar with a 'book' method which allows you to book events given a start and end time.
     * If there are collisions with existing bookings, the method should return false.
     * Start and end are in the range of [0, 10e9].
     * Example: book(10, 20), book(15, 25), and book(20, 30) => true, false, and true;
     * Explanation: The start time of the second event lies between the first interval, i.e. there is a collision.
     *              The third event can be added as it doesn't collide with any existing bookings.
     * Solution: We would like to avoid going through the entire calendar to check whether a new event can be added
     *           or whether there are booking collisions. Using a TreeMap with <start, end> as <key, value> pairs
     *           allows us to keep the events sorted and thus, quickly check for collisions. We find the nearest
     *           two events with the help of 'floorKey(start)' and 'ceilingKey(start)'. If they don't exist or if
     *           the value of 'floorKey(start)' is less/equal to 'start' and 'ceilingKey(start)' greater/equal
     *           to 'end' a new event can be inserted.
     * **/

    static class MyCalendar {

        private final TreeMap<Integer, Integer> calendar;

        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer p = calendar.floorKey(start);
            Integer n = calendar.ceilingKey(start);
            if ((p == null || calendar.get(p) <= start) && (n == null || n >= end)) {
                calendar.put(start, end);
                return true;
            }
            return false;
        }
    }
}

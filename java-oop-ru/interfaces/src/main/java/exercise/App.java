package exercise;

import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        return apartments.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(count)
                .map(Home::toString)
                .toList();
    }
}
// END

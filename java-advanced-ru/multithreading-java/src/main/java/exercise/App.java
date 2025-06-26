package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);

        minThread.start();
        maxThread.start();

        int min = minThread.getMin();
        int max = maxThread.getMax();

        Map<String, Integer> result = Map.of("min", min, "max", max);
        return result;
    }
    // END
}

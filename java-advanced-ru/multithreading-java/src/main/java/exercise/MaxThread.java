package exercise;

// BEGIN
import java.util.Arrays;

public class MaxThread extends Thread {
    private int[] numbers;
    private int max;

    @Override
    public void run() {
        max = Arrays.stream(numbers).max().getAsInt();
    }

    MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMax() {
        return max;
    }
}
// END

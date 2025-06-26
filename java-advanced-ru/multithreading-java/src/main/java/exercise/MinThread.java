package exercise;

// BEGIN
import java.util.Arrays;

public class MinThread extends Thread {
    private int[] numbers;
    private int min;

    @Override
    public void run() {
        min = Arrays.stream(numbers).min().getAsInt();
    }

    MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMin() {
        return min;
    }
}
// END

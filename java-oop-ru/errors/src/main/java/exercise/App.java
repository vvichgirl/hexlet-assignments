package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) {
        try {
            var square = circle.getSquare();
            System.out.println(Math.round(square));
        } catch (NegativeRadiusException exception) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END

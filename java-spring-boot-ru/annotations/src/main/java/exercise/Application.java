package exercise;

import exercise.annotation.Inspect;
import exercise.model.Address;

import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Class returnParam = method.getReturnType();
                String result = String.format("Method %s returns a value of type %s", method.getName(), returnParam.getSimpleName());

                System.out.println(result);
            }
        }
        // END
    }
}

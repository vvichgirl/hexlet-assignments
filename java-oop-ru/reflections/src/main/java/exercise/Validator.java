package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Validator {
    public static List<String> validate(Object obj) {
        List<String> result = new ArrayList<>();

        try {
            Class<?> aClass = obj.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();

            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && Objects.isNull(field.get(obj))) {
                    result.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> result = new HashMap<>();

        try {
            Class<?> aClass = obj.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();

            for (Field field : declaredFields) {
                field.setAccessible(true);
                var listError = result.getOrDefault(field.getName(), new ArrayList<>());
                if (field.isAnnotationPresent(NotNull.class) && Objects.isNull(field.get(obj))) {
                    listError.add("can not be null");
                    result.put(field.getName(), listError);
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength minLengthInfo = field.getAnnotation(MinLength.class);
                    if (Objects.isNull(field.get(obj))
                            || field.get(obj).toString().length() < minLengthInfo.minLength()
                    ) {
                        listError.add("length less than " + minLengthInfo.minLength());
                        result.put(field.getName(), listError);
                    }

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }
}
// END

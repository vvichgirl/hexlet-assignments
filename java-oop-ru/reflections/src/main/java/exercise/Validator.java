package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Validator {
    public static List<String> validate(Object obj) {
        Class<?> aClass = obj.getClass();

        return List.of(aClass.getDeclaredFields()).stream()
                .filter((field) -> {
                    var isNull = false;
                    try {
                        field.setAccessible(true);
                        isNull = field.isAnnotationPresent(NotNull.class) && Objects.isNull(field.get(obj));
                        field.setAccessible(false);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return isNull;
                })
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> result = new HashMap<>();

        Class<?> aClass = obj.getClass();

        List.of(aClass.getDeclaredFields()).stream()
                .filter((field) -> field.isAnnotationPresent(NotNull.class)
                        || field.isAnnotationPresent(MinLength.class))
                .forEach(field -> {
                    var fieldName = field.getName();
                    var listErrors = getFieldErrors(field, obj);
                    if (!listErrors.isEmpty()) {
                        result.put(fieldName, listErrors);
                    }
                });

        return result;
    }

    public static List<String> getFieldErrors(Field field, Object obj) {
        List<String> listErrors = new ArrayList<>();
        String value = null;
        try {
            field.setAccessible(true);
            value = (String) field.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (field.isAnnotationPresent(NotNull.class) && Objects.isNull(value)) {
            listErrors.add("can not be null");
        }
        if (field.isAnnotationPresent(MinLength.class)) {
            MinLength minLengthInfo = field.getAnnotation(MinLength.class);
            if (Objects.isNull(value) || value.length() < minLengthInfo.minLength()
            ) {
                listErrors.add("length less than " + minLengthInfo.minLength());
            }
        }
        return listErrors;
    }
}
// END

package com.github.m0wn1ka;

import java.lang.reflect.Field;

/**
 * Utility class for safely accessing nested object properties using reflection.
 *
 * Example usage:
 *     Country country = new Country();
 *     Object result = Radha.getNullSafeValue(country, "state?.district?.mandal");
 * If any intermediate property (like `state` or `district`) is null,
 * this method returns null instead of throwing a NullPointerException.
 */
public class Radha {

    /**
     * Safely accesses a nested property path from a given root object.
     *
     * @param root The root object (e.g., a Country instance).
     * @param path The path string using `?.` as delimiter (e.g., "state?.district?.mandal").
     * @return The value of the nested property, or null if any part is null
     */
    public static Object getNullSafeValue(Object root, String path) {
        if (root == null || path == null || path.isEmpty()) {
            return null;
        }

        Object result = null;
        String[] props = path.split("\\?\\.");

        for (String prop : props) {
            Field field;
            try {
                field = root.getClass().getField(prop);
                field.setAccessible(true);
                result = field.get(root);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                return null;
            }

            if (result == null) {
                return null; // return so that in next iteration we dont access on null
            }

            root = result;
        }

        return result;
    }
}

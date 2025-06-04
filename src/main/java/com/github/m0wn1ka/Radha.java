package com.github.m0wn1ka;
import java.lang.reflect.Field;

public class Radha {
    public static Object getNullSafeValue(Object root, String path)  {
        Object ans = null;
        //expecdted form of input is a.b.c
        String[] props = path.split("\\.");
        for (String prop : props) {
            Field field = null;
            try {
                field = root.getClass().getField(prop);
            } catch (NoSuchFieldException e) {
                //if field does not exist return null
                return null;
            }
            Object fieldValue = null;
            try {
                fieldValue = field.get(root);
            } catch (IllegalAccessException e) {
               return null;
            }
            if (fieldValue == null) {
                //if field value is null return null
                return null;
            }
            root = fieldValue;
            ans = fieldValue;
        }
        return ans;
    }

}

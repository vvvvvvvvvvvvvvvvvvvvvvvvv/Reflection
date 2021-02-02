package test;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        //Class<?> aClass = User.class;
         Class<?>[] methods = User.class.getInterfaces();//aClass.getDeclaredMethods();
        for (Class method : methods) {
            System.out.println(method);
        }
    }
}

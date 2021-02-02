package service.core;

import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import service.annotation.AutoWired;
import service.annotation.Service;
import service.annotation.StartUp;
import service.exeptions.ClassCannotCreateException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Context {
    public static <T> T getObjectByClass(Class<T> aClass)  {
        StartUp annotation = aClass.getAnnotation(StartUp.class);

        Set<Class<?>> services =  getTypeByAnnotationWithPackage(annotation.packageScan(), Service.class);
        Map<String, Object> objectMap = getConfigMap(services);
        T object = createObject(aClass);
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declareField : declaredFields){
            if(declareField.isAnnotationPresent(AutoWired.class)){
                Class<?> fieldType = declareField.getType();
                String nameType = fieldType.getName();
                Object dependency = objectMap.get(nameType);
                declareField.setAccessible(true);
                setFieldValue(object, declareField, dependency);
            }
        }
        return object;
    }

    private static <T> void setFieldValue(T object, Field declareField, Object dependency) {
        try {
            declareField.set(object, dependency);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Object> getConfigMap(Set<Class<?>> services) {
        Map<String, Object> configObject = new HashMap<>();
        for (Class<?> service : services) {
            Object serviceObj = createObject(service);
            Class<?>[] interfaces = service.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                configObject.put(anInterface.getName(), serviceObj);
            }
        }
        return configObject;
    }

    private static <T> T createObject(Class<T> service)  {
        try {
            return service.getConstructor().newInstance();
        } catch (Exception e) {
            throw new ClassCannotCreateException("Can not create object of class: " + service.getName());
        }
    }

    private static Set<Class<?>> getTypeByAnnotationWithPackage(String scanPackage, Class<? extends Annotation> scanAnnotation){
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(scanPackage)));

        return reflections.getTypesAnnotatedWith(scanAnnotation);
    }

}

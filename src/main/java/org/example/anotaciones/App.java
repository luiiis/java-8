package org.example.anotaciones;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class App {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Lenguajes{
        Lenguaje[] value() default{};
    }
    @Repeatable(value = Lenguajes.class)
    public @interface Lenguaje{
        String value();
    }
//1.7
   /* @Lenguajes({
            @Lenguaje("Java"),
            @Lenguaje("Pyton")
    })*/
    //1.8
    @Lenguaje("java")
    @Lenguaje("Pyton")
    public interface LenguajeProgramacion{

    }
    public static void main(String[] args) {
Lenguaje[] lenguajesArray =LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
System.out.println("Se tiene "+lenguajesArray.length+" anotaciones en Lenguajes");
Lenguajes len =  LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
for(Lenguaje elemento: len.value()){
    System.out.println(elemento);
}
    }
}

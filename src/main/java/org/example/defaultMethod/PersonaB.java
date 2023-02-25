package org.example.defaultMethod;

public interface PersonaB {

    default public void hablar(){
        System.out.println("Saludos desde persona B");
    }
}

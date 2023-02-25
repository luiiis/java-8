package org.example.defaultMethod;

public class DefaultMethod implements PersonaA,PersonaB{

    @Override
    public void caminar() {
    System.out.println("Hola a todos");
    }

    @Override
    public void hablar() {
        //PersonaA.super.hablar();
        System.out.println("Suscribirse");
    }

    public static void main(String[] args) {
        DefaultMethod app =new DefaultMethod();
        app.caminar();
        app.hablar();
    }


}

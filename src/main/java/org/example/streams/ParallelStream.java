package org.example.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    private List<Integer> numeros;
    public void llenar(){
        numeros = new ArrayList<>();
        for(int i=0;i<10;i++){
            numeros.add(i);
        }
    }
    public void probarStream(){
     numeros.stream().forEach(System.out::println);//secuencial
    }
    public void probarParalelo(){
        numeros.parallelStream().forEach(System.out::println);//con hilos--aleatorio
    }
    public static void main(String[] args) {

        ParallelStream app = new ParallelStream();
        //app.llenar();
        app.probarParalelo();
    }
}

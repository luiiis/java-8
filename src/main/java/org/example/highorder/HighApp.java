package org.example.highorder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {

    private Function<String ,String> convertirMayusculas = x->x.toUpperCase();
    private Function<String ,String> convertirMinusculas = x->x.toLowerCase();

    public void imprimir(Function<String,String>function,String valor){
        System.out.println(function.apply(valor));
    }

    public Function<String, String> mostrar (String mensaje){
        return(String x)->mensaje+x;
    }

    public void filtrar(List<String> lista, Consumer<String> consumidor, int longuitud){
lista.stream().filter(this.establecerLogicaFiltro(longuitud)).forEach(consumidor);
    }
public Predicate<String> establecerLogicaFiltro(int longuitud){
        return texto->texto.length()<longuitud;
}
    public static void main(String[] args) {

        HighApp app = new HighApp();
        app.imprimir(app.convertirMayusculas,"mitocode");
        app.imprimir(app.convertirMinusculas,"MITOCODE");
        String respuesta=app.mostrar("hola").apply("MitoCode");
        System.out.println(respuesta);

        List<String>lista = new ArrayList<>();
        lista.add("Mito");
        lista.add("Code");
        lista.add("MitoCode");
        app.filtrar(lista,System.out::println,5);
    }
}

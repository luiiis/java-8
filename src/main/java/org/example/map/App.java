package org.example.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    private Map<Integer,String> map;

    public void probar(){
        map = new HashMap<>();
        map.put(1,"Mito");
        map.put(2,"Code");
        map.put(3,"Suscribete");
    }
    public void imprimir_v7(){
        for(Map.Entry<Integer,String> e:map.entrySet()){
            System.out.println("llave: "+e.getKey()+" Valor: "+e.getValue());
        }
    }

    public void imprimir_v8(){
        map.forEach((k,v)->System.out.println("llave: "+k+ "Value"+v));
        map.entrySet().stream().forEach(System.out::println);
    }
    public void recolectar(){
Map<Integer,String> mapaRecoelctado = map.entrySet().stream()
        .filter(e->e.getValue().contains("Sus"))
        .collect(Collectors.toMap(p->p.getKey(),p->p.getValue()));
mapaRecoelctado.forEach((k,v)->System.out.println("Llave: "+k+" Valor: "+v));
    }
    public void insertarSiAusente(){
map.putIfAbsent(4,"Jaime");
    }
    public void operarSiPresente(){
map.computeIfPresent(3,(k,v)->k+v);
System.out.println(map.get(3));
    }
    public void obtenerOrPredeterminado(){
String valor = map.getOrDefault(5,"valor por defecto");
System.out.println(valor);
    }
    public static void main(String[] args) {

        App app=new App();
        app.probar();
        //app.insertarSiAusente();
        //app.operarSiPresente();
        //app.obtenerOrPredeterminado();
        app.recolectar();
app.imprimir_v8();
        //app.imprimir_v7();
    }
}

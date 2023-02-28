package org.example.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

public class NasApp {
    private ScriptEngineManager m;
    private ScriptEngine e;

    private Invocable invocador;
    public NasApp(){
        m = new ScriptEngineManager();
        e=m.getEngineByName("nashorn");
        invocador=(Invocable) e;
    }
    public void llamarFunciones()throws Exception{
        //e.eval("print('Js desde java')");
        e.eval(new FileReader("src/main/java/org/example/nashorn/archivo.js"));
       String rpta=(String) invocador.invokeFunction("calcular","2","3");
       System.out.println(rpta);
        double rpta2=(double) invocador.invokeFunction("calcular",2,3);
        System.out.println(rpta2);
    }
    public void implementarInterfaz()throws Exception{
        e.eval(new FileReader("src/main/java/org/example/nashorn/archivo.js"));
        Object implementacion=e.get("hiloImpl");
        Runnable r = invocador.getInterface(implementacion,Runnable.class);
        Thread th1 = new Thread(r);
        th1.start();
    }

    public static void main(String[] args) throws Exception{

        NasApp app =new NasApp();
        //app.llamarFunciones();
        app.implementarInterfaz();
    }
}

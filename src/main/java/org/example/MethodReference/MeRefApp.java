package org.example.MethodReference;

import java.util.Arrays;
import java.util.Comparator;

public class MeRefApp {
    public static void referenciarMetodoStatic(){
        System.out.println("Metodo Referido static");
    }

    public void referenciaMetodoInstanciaObjetoArbitrario(){
        String[] nombres ={"Mito","Code","Jaime"};
       /* Arrays.sort(nombres, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });*/

        //Arrays.sort(nombres,(s1,s2)->s1.compareToIgnoreCase(s2));
        //System.out.println(Arrays.toString(nombres));

        Arrays.sort(nombres,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(nombres));
    }
    public void referenciaMetodoInstanciaObjetoParticular(){
        System.out.println("Metodo Referido Instancia de Clase de un objeto en particular");
    }

    public void referenciarConstructor(){
       /* IPersona iper = new IPersona(){
            @Override
            public Persona crear(int id,String nombre){
                return new Persona(id,nombre);
            }
        };
        Persona per = iper.crear(1,"MitoCode");*/

        /*IPersona iper2 =(x,y)->(new Persona(x,y));
        Persona per = iper2.crear(1,"MitoCode");*/

        IPersona Iper = Persona::new;
        Persona per = Iper.crear(1,"MitoCode");

        System.out.println(per.getId()+" -"+per.getNombre());
    }

    public void operar(){
       /* Operacion op = () -> MeRefApp.referenciarMetodoStatic();
        op.saludar();*/

        Operacion op2 = MeRefApp::referenciarMetodoStatic;
        op2.saludar();
    }
    public static void main(String[] args) {
        MeRefApp app = new MeRefApp();
        //app.operar();
        //app.referenciaMetodoInstanciaObjetoArbitrario();

        /*Operacion op = app::referenciaMetodoInstanciaObjetoParticular;
        op.saludar();*/
        app.referenciarConstructor();

    }
}

package Vistas;

import Modelos.Proyecto;
import Modelos.RecompensasDeProyecto;

import java.io.Serializable;
import java.util.ArrayList;

public class VistaProyecto implements Serializable {
    public void nombre(){System.out.println("Escribe el nombre del proyecto");}

    public void mensajeProyectoNoEncontrado(){System.out.println("El proyecto que estas buscando no existe");}

    public void mensajeRecompensaAgregada(){
        System.out.println("La recompensa fue agregada al proyecto");
    }

    public void verRecompensaDeProyecto(ArrayList<RecompensasDeProyecto> recompensasDeProyectos){
        for (int i = 0; i <recompensasDeProyectos.size() ; i++) {
            System.out.println(recompensasDeProyectos.get(i));
        }
    }
    public void verUnProyecto(Proyecto proyecto){
        System.out.println(proyecto);
    }


    public void mensajeDeOrdenacionPorFinanciacion(){
        System.out.println("El array fue ordenado por orden de el que tenga la finacicion mas alta");
    }
    public void verProyectos(ArrayList<Proyecto> todosLosProyectos){
        if(todosLosProyectos.isEmpty()){
            System.out.println("No se ha creado ningún proyecto");
        }
        for (int i = 0; i <todosLosProyectos.size() ; i++) {
            System.out.println(todosLosProyectos.get(i));
        }
    }
}

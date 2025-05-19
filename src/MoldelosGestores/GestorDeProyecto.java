package MoldelosGestores;

import Inversión.Inversion;
import Modelos.Proyecto;
import Vistas.VistaProyecto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class GestorDeProyecto implements Serializable {
    ArrayList<Proyecto>gestorProyecto;

    public GestorDeProyecto (){
        gestorProyecto = new ArrayList<Proyecto>();
    }

    public boolean añadirProyecto(Proyecto proyecto){
        gestorProyecto.add(proyecto);
        return true;
    }

    public void setGestorProyecto(ArrayList<Proyecto> gestorProyecto) {
        this.gestorProyecto = gestorProyecto;
    }

    public boolean eliminarProyecto(String id){
        for (int i = 0; i <gestorProyecto.size() ; i++) {
            if(gestorProyecto.get(i).getId().equals(id)){
                gestorProyecto.remove(i);
                return true;
            }
        }
        return false;
    }

    public Proyecto buscarProyecto(String id){
        for (int i = 0; i <gestorProyecto.size() ; i++) {
            if (gestorProyecto.get(i).getId().equals(id)){
                return gestorProyecto.get(i);
            }
        }
        return null;
    }

    public int contarGraficoBarras(Proyecto proyecto) {

        int graficoBarras = (int) ((proyecto.getCantidadFinanciada() * 100) / proyecto.getCantidadNecesaria());
        return graficoBarras;

    }

    public void ordenarPorImporteFinanciado(ArrayList<Proyecto> proyecrtos){
            proyecrtos.sort((a , b) -> (b.getCantidadFinanciada()-a.getCantidadFinanciada()));
    }

    public ArrayList<Inversion> ordenarInversionesPorNombre(ArrayList<Inversion> inversiones){
        inversiones.sort(Comparator.comparing(persona -> persona.getInversor().getNombre()));
        return inversiones;
    }

    public ArrayList<Inversion> ordenarInversionesPorImporte(ArrayList<Inversion> inversiones){
        inversiones.sort((persona1,persona2) -> (int) (persona2.getCantidadInvertida()-persona1.getCantidadInvertida()));
        return inversiones;
    }

    public ArrayList<Proyecto> verArrayDeProyectos(){
        return gestorProyecto;
    }

    public void ordenarArrayPorFecha(ArrayList<Proyecto> proyectos){
        proyectos.sort((a,b)->a.getFechaDeApertura().compareTo(b.getFechaDeApertura()));
    }

    public boolean aterarProyecto(Proyecto proyecto,String id){
        for (int i = 0; i <gestorProyecto.size() ; i++) {
            if (gestorProyecto.get(i).getId().equals(id)){
                gestorProyecto.add(i,proyecto);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Proyecto> verTodosLosProyectos(){
        return gestorProyecto;
    }

}

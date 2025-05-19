package Controladores;

import Modelos.Proyecto;
import Modelos.RecompensasDeProyecto;
import MoldelosGestores.GestorDeProyecto;
import Vistas.VistaProyecto;

import java.io.Serializable;
import java.util.ArrayList;

public class ControladorDeProyecto implements Serializable {
    private GestorDeProyecto gestorDeProyecto;
    private VistaProyecto vistaProyecto;

    public ControladorDeProyecto(GestorDeProyecto gestorDeProyecto, VistaProyecto vistaProyecto) {
        this.gestorDeProyecto = gestorDeProyecto;
        this.vistaProyecto = vistaProyecto;
    }

    public void verTodosLosProyectos(){
        vistaProyecto.verProyectos(gestorDeProyecto.verTodosLosProyectos());
    }

    public void añadirRecompensaAProyecto(String idDeProyecto,String descripcionDeProyecto,int cantidadDeProyecto,String idProyecto){
        RecompensasDeProyecto recompensasDeProyecto = new RecompensasDeProyecto(descripcionDeProyecto,cantidadDeProyecto,descripcionDeProyecto);
        gestorDeProyecto.buscarProyecto(idProyecto).añadirRecompensa(recompensasDeProyecto);
        vistaProyecto.mensajeRecompensaAgregada();
    }

    public void verUnProyecto(Proyecto proyecto){
        vistaProyecto.verUnProyecto(proyecto);
    }

    public  void verRecompensasDeProyecto(String idDeProyecto){
        if(gestorDeProyecto.buscarProyecto(idDeProyecto).getId().equals(idDeProyecto)){
            vistaProyecto.verRecompensaDeProyecto(gestorDeProyecto.buscarProyecto(idDeProyecto).verArrayDeProyecto());
        }
        vistaProyecto.mensajeProyectoNoEncontrado();
    }

    public void ordenarProyectoPorImporteRealizado(){
        gestorDeProyecto.ordenarPorImporteFinanciado(gestorDeProyecto.verArrayDeProyectos());
        vistaProyecto.mensajeDeOrdenacionPorFinanciacion();
    }


}

package Vistas;

import Inversión.Inversion;
import Modelos.Proyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaGestor {
    Scanner S = new Scanner(System.in);


    public void idNoValido(){System.out.println("El id proporcionado no es válido");}

    public String inicioDeSecionCodigo(){
        System.out.println("Ingrese el código de verificación");
        String codigo = S.nextLine();
        return codigo;
    }


    public void saludarUsuario(){
        System.out.println("Bienvenido al modo gestor");
    }

    public void mensajeMostrarProyectos(String nombreDeGestor){
        System.out.println(" Estos son los proyectos creados por el gestor " + nombreDeGestor );
    }


    public void mostrarProyectoDeGestor(ArrayList<Proyecto> proyecto){
        if(proyecto.isEmpty()){
            System.out.println("No hay proyectos creados");
        }
        for (int i = 0; i <proyecto.size() ; i++) {
            System.out.println(proyecto.get(i));
        }
    }
    public void mensajeDeOrdenacionPorFinanciacion(){
        System.out.println("El array fue ordenado por orden de el que tenga la finacicion mas alta");
    }

    public void mensajeProyectosOrdenadosPorFecha(){
        System.out.println("Los proyectos fueron ordenados por fecha");
    }

    public void mensajeCambioDeCambioDeCategoria(){
        System.out.println("La categoria fue cambiada");
    }

    public void mensajeDeCambioDeNombre(){
        System.out.println("El nombre del proyecto fué cambiado");
    }

    public void mensajeDeCambioDeDescripcion(){
        System.out.println("La descripción del proyecto fué cambiado");
    }

    public void mensajeCantidadFinanciada() {
        System.out.println("La cantidad financiada fué cambiada");
    }

    public void mensajeFechaDeApertura() {
        System.out.println("La fecha de apertura fué cambiada");
    }

    public void mensajeProyectoCreado(){System.out.println("El proyecto fué creado");}

    public void usuarioBloqueado(){
        System.out.println("El usuario ha sido bloqueado");
    }

    public void mensajeProyectoEliminado(){
        System.out.println("El proyecto fué eliminado");
    }

    public void mostrarInversiones(ArrayList<Inversion> Inversiones){
        for (Inversion inv: Inversiones) System.out.println(inv.getInversor().getNombre()+": "+ inv.getCantidadInvertida());
    }

    public void mostrarGraficoBarras(int graficoBarras){

        System.out.print("[");
        for (int x = 0; x < graficoBarras; x++) {
            System.out.print("▓");
        }
        for (int y = 0; y < (100 - graficoBarras); y++) {
            System.out.print("░");
        }
        System.out.print("]" + graficoBarras + "%");
        System.out.println();
    }
}

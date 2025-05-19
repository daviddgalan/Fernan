package Vistas;

import Inversión.Inversion;
import Modelos.Proyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaGestor implements Credenciales , Serializable {
    Scanner S = new Scanner(System.in);


    public void idNoValido(){System.out.println("El id proporcionado no es válido");}

    public String inicioDeSecionCodigo(){
        System.out.println("Ingrese el código de verificación");
        String codigo = S.nextLine();
        return codigo;
    }

    public void pedirUsuario(){
        System.out.println("Por favor introduzca el nombre de usuario/alias");
    }

    public void PedirContraseña(){
        System.out.println("Por favor introduzca su contraseña");
    }

    public void saludarUsuario(){
        System.out.println("Bienvenido al modo gestor");
    }

    public void mensajeMostrarProyectos(String nombreDeGestor){
        System.out.println(" Estos son los proyectos creados por el gestor " + nombreDeGestor );
    }

    public void mensajeDeProyectoBuscado(){
        System.out.println(" EL proyecto buscado és ");
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

    public void mensajeDeCambioDeCambioCategoria(){
        System.out.println("La categoría fué cambiada");
    }

    public void mensajeCantidadNecesaria() {
        System.out.println("La cantidad necesaria fué cambiada");
    }

    public void mensajeCantidadFinanciada() {
        System.out.println("La cantidad financiada fué cambiada");
    }

    public void mensajeFechaDeApertura() {
        System.out.println("La fecha de apertura fué cambiada");
    }

    public void mensajeRecompensas() {
        System.out.println("Las recompensas fueron cambiadas");
    }

    public void mensajeFechaDeFin() {
        System.out.println("La fecha de fin fué cambiada");
    }

    public void mensajeProyectoCreado(){System.out.println("El proyecto fué creado");}



    public void usuarioBloqueado(){
        System.out.println("El usuario ha sido bloqueado");
    }

    public void mensajeProyectoNoEncontrado(){System.out.println("El proyecto no fué encontrado");}

    public void mensajeProyectoEliminado(){
        System.out.println("El proyecto fué eliminado");
    }

    public void opcinesDelGestor(){
        System.out.println("1: Ver todos mis proyectos");
        System.out.println("2: Cambio de credenciales");
        System.out.println("3: Cerrar sesión");
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

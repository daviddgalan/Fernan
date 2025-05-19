package Vistas;

import Inversión.Inversion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaAdministrador implements Credenciales, Serializable {
    Scanner S = new Scanner(System.in);


    public String inicioDeSecionCodigo(){
        System.out.println("Ingrese el código de verificación");
        String codigo = S.next();
        return codigo;
    }

    @Override
    public void PedirContraseña() {
        System.out.println("Por favor introduzca su contraseña");
    }

    @Override
    public void pedirUsuario() {
        System.out.println("Por favor introduzca el nombre de usuario/alias");
    }

    public void credencialesNoValidos(){
        System.out.println("Credenciales no validas");
    }
    public void mensajeProyectosOrdenadosPorFecha(){
        System.out.println("Los proyectos fueron ordenados por fecha");
    }
    @Override
    public void saludarUsuario() {
        System.out.println("Bienvenido al modo administrador");
    }

    public void cambioDeContraseña(){
        System.out.println("La contraseña ha sido cambiada");
    }

    public void cambioDeUsuario(){
        System.out.println("El usuario ha sido cambiado");
    }

    public void usuarioDesbloqueado(){
        System.out.println("El usuario ha sido desbloqueado");
    }

    public void usuarioBloqueado(){
        System.out.println("El usuario ha sido bloqueado");
    }

    public void mensajeDeCambioDeNombre(){
        System.out.println("El nombre del proyecto fué cambiado");
    }

    public void mensajeDeCambioDeDescripcion(){
        System.out.println("La descripción del proyecto fué cambiada");
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

    public void mostrarInversiones(ArrayList<Inversion> Inversiones){
        for (Inversion inv: Inversiones) System.out.println(inv.getInversor().getNombre()+": "+ inv.getCantidadInvertida());
    }


}

package Vistas;

import Inversión.Inversion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaAdministrador {
    Scanner S = new Scanner(System.in);


    public String inicioDeSecionCodigo(){
        System.out.println("Ingrese el código de verificación");
        String codigo = S.next();
        return codigo;
    }

    public void credencialesNoValidos(){
        System.out.println("Credenciales no validas");
    }

    public void mensajeProyectosOrdenadosPorFecha(){
        System.out.println("Los proyectos fueron ordenados por fecha");
    }

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

    public void mensajeCantidadFinanciada() {
        System.out.println("La cantidad financiada fué cambiada");
    }

    public void mostrarInversiones(ArrayList<Inversion> Inversiones){
        for (Inversion inv: Inversiones) System.out.println(inv.getInversor().getNombre()+": "+ inv.getCantidadInvertida());
    }

}

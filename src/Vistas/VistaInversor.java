package Vistas;

import Inversión.Inversion;
import Modelos.Amigo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaInversor  {
    Scanner S = new Scanner(System.in);

    public void saludarUsuario() {
        System.out.println("Bienvenido al modo Inversor");
    }


    public void textoParaMostrarInversiones(String nombreDeInversor) {
        System.out.println("Las inversiones realizadas por el Inversor " + nombreDeInversor + " son ");
    }

    public void mostrarInverciones(ArrayList<Inversion> inversiones) {
        if(inversiones.isEmpty()){
            System.out.println("No se ha realizado ninguna inversión");
        }
        for (int i = 0; i < inversiones.size(); i++) {
            System.out.println(inversiones.get(i));
        }
    }

    public void textoParaCartera(String nombre) {
        System.out.println("El dinero que tiene " + nombre + "en la cartera és ");
    }

    public void verCarteraDeInversor(float cartera) {
        System.out.println(cartera);
    }

    public void mensajeCreditoAñadido(float cantidadAñadida) {
        System.out.println(" Se añadió a la cartera " + cantidadAñadida + " créditos ");
    }
    public void mensajeCreditoRestado(float cantidadAñadida) {
        System.out.println(" Se ha restado a la cartera " + cantidadAñadida + " créditos ");
    }


    public void mensajeAmigos(String nombre) {
        System.out.println(" Los amigos del inversor " + nombre);
    }

    public void mensajeAmigoAñadido() {
        System.out.println("El nuevo amigo fué agregado");
    }

    public void verAmigosDeGestor(ArrayList<Amigo> amigos) {
        for (int i = 0; i < amigos.size(); i++) {
            System.out.println(amigos.get(i));
        }
    }


    public void idNoValido() {
        System.out.println("El id proporcionado no es válido");
    }

    public String inicioDeSesionCodigo() {
        System.out.println("Ingrese el código de verificación");
        String codigo = S.nextLine();
        return codigo;
    }

    public void mensajeCantidadInsuficiente(){System.out.println("Cantidad insufiente en la cartera para invertir en este proyecto");}

    public void mensajeUsuarioNoEncontrado() {
        System.out.println("El usuario no ha sido encontrado");
    }

}
package Vistas;

import Inversión.Inversion;
import Modelos.Amigo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaInversor implements Credenciales , Serializable {
    Scanner S = new Scanner(System.in);

    @Override
    public void PedirContraseña() {
        System.out.println("Por favor introduzca su contraseña");
    }

    @Override
    public void pedirUsuario() {
        System.out.println("Por favor introduzca el nombre de usuario");
    }

    @Override
    public void saludarUsuario() {
        System.out.println("Bienvenido al modo Inversor");
    }

    public void textoParaMostrarProyectos(String nombreInversor) {
        System.out.println(" Los proyectos creados por el Inversor " + nombreInversor + " son ");
    }

    public void mostrarProyectos(ArrayList<Inversion> proyectosInvertidos) {
        for (int i = 0; i < proyectosInvertidos.size(); i++) {
            System.out.println(proyectosInvertidos.get(i));
        }
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

    public void mensajeCreditoAñadido(int cantidadAñadida) {
        System.out.println(" Se añadió a la cartera " + cantidadAñadida + " créditos ");
    }
    public void mensajeCreditoRestado(int cantidadAñadida) {
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

    public void mensajeCambioDeUsusaio() {
        System.out.println("El nombre del inversor fué modificado");
    }

    public void mensajeDeCabioDeContraseña() {
        System.out.println("La contraseña del inversor fué modificada");
    }

    public void idNoValido() {
        System.out.println("El id proporcionado no es válido");
    }

    public String inicioDeSesionCodigo() {
        System.out.println("Ingrese el código de verificación");
        String codigo = S.nextLine();
        return codigo;
    }

    public void mensajeUsuarioNoEncontrado() {
        System.out.println("El usuario no ha sido encontrado");
    }

    public void usuarioBloqueado() {
        System.out.println("El usuario ha sido bloqueado");


    }
}
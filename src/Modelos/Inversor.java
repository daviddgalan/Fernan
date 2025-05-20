package Modelos;

import Inversión.Inversion;


import java.io.Serializable;
import java.util.ArrayList;

public class Inversor extends Usuario  implements Serializable {
    private ArrayList<Inversion>inversionesRealizadas;
    private int cartera ;
    private ArrayList<Amigo> amigos;
    private boolean usuarioBloqueado;

    public Inversor(String nombre, String correo, String contraseña) {
        super(nombre, correo, contraseña);
        this.cartera = 0;
        usuarioBloqueado = false;
        inversionesRealizadas = new ArrayList<>();
    }



    public void añadirSaldoACartera(int saldo) {
        this.cartera += saldo;
    }

    public void restarSaldoACartera(int saldo) {
        this.cartera -= saldo;
    }

    public int verCatera() {
        return cartera;
    }

    public boolean cambioDeUsusario(String nuevoUsuario ){
        super.cambioDeNombreDeUsusario(nuevoUsuario);
        return true;
    }

    public boolean cambioDeContraseña(String nuevaContraseña ){
        super.cambioDeContraseña(nuevaContraseña);
        return true;
    }

    public boolean añadirAmigo(Amigo amigo){amigos.add(amigo);return true;}

    public ArrayList<Amigo> verListaDeAmigos(){
        return amigos;
    }

    public ArrayList<Inversion> mostrarListaDeInversiones(){
        return inversionesRealizadas;
    }

    public void invertir(Inversion inversion){
        inversionesRealizadas.add(inversion);
        inversion.getProyecto1().añadirInvercion(inversion);
    }
    public Inversion verUltimaInversion(){
        return inversionesRealizadas.get(inversionesRealizadas.size()-1);
    }


}


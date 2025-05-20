package Modelos;


import java.io.Serializable;

import static FuncionesDeCadenas.Cadenas.FortalezaContraseña;


public abstract class Usuario implements  Serializable {
    private String nombre;
    private String contraseña;
    private String correo;
    private boolean bloqueado;

    public Usuario(String nombre, String correo,String contraseña) {
        this.contraseña = contraseña;
        this.correo = correo;
        this.bloqueado = false;
        this.nombre = nombre;
    }

    public boolean cambioDeContraseña(String contraseña) {
        if(FortalezaContraseña(contraseña)){
            this.contraseña = contraseña;
            return true;
        }else{
            return false;
        }
    }

    public void cambioDeNombreDeUsusario(String nombre) {
        this.nombre = nombre;
    }


    public String getContraseña() {
        return contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



    public boolean isBloqueado() {
        return bloqueado;
    }



    @Override
    public String toString() {
        return "El nombre del usuario es " + nombre +
                ", su correo registrado es " + correo +
                " y actualmente su cuenta está " + (bloqueado ? "bloqueada." : "activa.");
    }
}

package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Gestor extends Usuario implements Serializable {

    private boolean usuarioBloqueado;


    public Gestor(String nombre, String correo, String contraseña) {
        super(nombre, correo,contraseña);
        this.usuarioBloqueado = false;
        setTipoUsuario(2);
    }

    public Gestor(String nombre, String correo, String contraseña, boolean usuarioBloqueado) {
        super(nombre, correo,contraseña);
        this.usuarioBloqueado = usuarioBloqueado;
        setTipoUsuario(2);
    }

    public boolean cambioDeContraseña(String nuevaContraseña ){
        super.cambioDeContraseña(nuevaContraseña);
        return true;
    }

}

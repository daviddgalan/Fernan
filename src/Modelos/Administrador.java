package Modelos;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {

    public Administrador(String nombre , String correo, String contraseña) {
        super(nombre, correo,contraseña);
        setTipoUsuario(1);
    }

    public boolean cambioDeContraseña(String nuevaContraseña ){
        super.cambioDeContraseña(nuevaContraseña);
        return true;
    }
}

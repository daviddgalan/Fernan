package Modelos;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {

    public Administrador(String nombre , String correo, String contraseña) {
        super(nombre, correo,contraseña);
    }

    public boolean cambioDeContraseña(String nuevaContraseña ){
        super.cambioDeContraseña(nuevaContraseña);
        return true;
    }

    public boolean cambioDeUsusario(String nuevoUsuario ){
        super.cambioDeNombreDeUsusario(nuevoUsuario);
        return true;
    }

    @Override
    public void cerrarSecion() {
       super.setBloqueado(false);
    }

    public boolean bloquearUsuario(Usuario usuario){
        return false;
    }

    public boolean desbloquearUsuario(Usuario usuario){
        return true;
    }


}

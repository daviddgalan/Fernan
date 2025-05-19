package Vistas;

import java.io.Serializable;

public class VistaPreferencias implements Serializable {

    public void mensajeErrorArchivoCargado(){
        System.out.println("No se encuentra el archivo .properties");
    }
    public void mensajeErrorArchivoGuardado(){
        System.out.println("No se ha guardado el archivo .properties");
    }
    public void mensajeBienArchivoGuardado(){
        System.out.println("Se ha guardado el archivo .properties");
    }
}

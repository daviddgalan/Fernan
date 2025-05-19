package Modelos;

import Vistas.VistaPreferencias;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Preferencias implements Serializable {
    private final String archivo = "RegistrosDeApp/.properties";
    private Properties props = new Properties();
    VistaPreferencias vistaPreferencias =new VistaPreferencias();

    public Preferencias(){
        try{
            FileReader f = new FileReader(archivo);
            props.load(f);
            f.close();
        }catch (IOException e){
            vistaPreferencias.mensajeErrorArchivoCargado();
        }
    }

    public String getUltimoInicioSesion(String nombreUsuario){
        String fecha = props.getProperty(nombreUsuario);
        return nombreUsuario+" inició sesión por ultima vez: "+fecha;
    }
    public void setUltimoInicioSesion(String nombreUsuario){
        props.setProperty(nombreUsuario,LocalDateTime.now()+"");
    }
    public Boolean getSinLoguear(){
        String invitado = "invitado";
        if (props.getProperty(invitado).equals("si")) return true;
        else return false;
    }
    public void setSinLoguear(String activarONo){
        String invitado = "invitado";
        if (activarONo.equals("si")) props.setProperty(invitado,"si");
        else props.setProperty(invitado,"no");
    }


    public void guardar() {
        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            props.store(fos, "Preferencias del usuario");
            vistaPreferencias.mensajeBienArchivoGuardado();
        } catch (IOException e) {
            vistaPreferencias.mensajeErrorArchivoGuardado();
        }
    }
    public void getUltimoInicioSesionTodos(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!(linea.contains("#") || linea.contains("invitado"))) System.out.println(linea);
            }
            br.close();
        }catch (IOException e){
            vistaPreferencias.mensajeErrorArchivoCargado();
        }
    }
}

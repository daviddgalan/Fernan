package Modelos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Logs implements Serializable {
    public void registroDeCambioDeNombre(String nombreDeUsuarioGestor,String idProyectoCambioDeNombre,String nuevoNombre){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("RegistrosDeApp/logs.txt",true));
            bf.write("\n"+" cambio de nombre realizado por " + nombreDeUsuarioGestor+"\n");
            bf.write("\n"+" el id del proyecto que fue modificado es " + idProyectoCambioDeNombre + " el nombre por el cual fue cambiado es " + nuevoNombre+"\n");
            bf.write("\n"+" la fecha de la modificacion es "+ LocalDateTime.now());
            bf.close();
        }catch (IOException e){
            System.out.println("Fichero no encontrado");
        }
    }
    public void registroDeCambioDeDescripcion(String nombreDeUsuarioGestor,String idProyectoCambioDeNombre,String nuevaDescripcion ) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("RegistrosDeApp/logs.txt", true));
            bf.write("\n"+" cambio de descripcion fue realizado por " + nombreDeUsuarioGestor + "\n");
            bf.write("\n"+" el id del proyecto que fue modificado es " + idProyectoCambioDeNombre + " la descripcion por el cual fue cambiado es " + nuevaDescripcion + "\n");
            bf.write("\n"+" la fecha de la modificacion es " + LocalDateTime.now());
            bf.close();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }

    public void RegistroCambioDeCategoria(String nombreDeUsuarioGestor, String idProyectoCambioDeNombre, String nuevaCategoria ){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("RegistrosDeApp/logs.txt", true));
            bf.write("\n"+" cambio de Categoria fue realizado por " + nombreDeUsuarioGestor + "\n");
            bf.write("\n"+" el id del proyecto que fue modificado es " + idProyectoCambioDeNombre + " la Categora por el cual fue cambiado es " + nuevaCategoria + "\n");
            bf.write("\n"+" la fecha de la modificacion es " + LocalDateTime.now());
            bf.close();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }

    public void RegistroCambiarFecha(String nombreDeUsuarioGestor, String idProyectoCambioDeNombre, String nuevaFecha){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("RegistrosDeApp/logs.txt", true));
            bf.write("\n"+" El cambio de Fecha fue realizado por " + nombreDeUsuarioGestor + "\n");
            bf.write("\n"+" el id del proyecto que fue modificado es " + idProyectoCambioDeNombre + " la fecha por la cual fue cambiado es " + nuevaFecha + "\n");
            bf.write("\n"+" la fecha de la modificacion es " + LocalDateTime.now());
            bf.close();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }
    public void RegistroDeInicioDeSesion(String nombreDeUsuario , String tipoDeUsuario ){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("RegistrosDeApp/logs.txt", true));
            bf.write("\n"+" inicio de sesion realizado por "+ nombreDeUsuario  + " el cuel es " + tipoDeUsuario + "\n");
            bf.write("\n"+" la fecha inicio de sesion fue " + LocalDateTime.now());
            bf.close();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }
    public void RegistroDeCierreDeSesion(){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("RegistrosDeApp/logs.txt", true));
            bf.write("\n"+" Se produjo un sierre de secion "+ "\n");
            bf.write("\n"+" la fecha en la que se serro la sesion fue " + LocalDateTime.now());
            bf.close();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }
    public void RegistroDeCreacionDeProyecto(String usuario,String proyecto){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("RegistrosDeApp/logs.txt", true));
            bf.write("\n"+" Se ha creado un proyecto el cual es "+ proyecto+ " el cual fue creador por " + usuario + "\n");
            bf.write("\n"+" la fecha en la que se creo el proyecto fue " + LocalDateTime.now());
            bf.close();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }
    public void RegistroDeElimicacionDeProyecto(String idDeProyectoEliminado,String usuario){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("RegistrosDeApp/logs.txt", true));
            bf.write("\n"+" Se ha eliminadao un proyecto donde su id era "+ idDeProyectoEliminado + " Este proyecto lo elimino el usuario " + usuario + "\n");
            bf.write("\n"+" la fecha en la que se elimino el proyecto fue " + LocalDateTime.now());
            bf.close();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }

    public void RegistroDeInversion(String invercion,String usuario){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("RegistrosDeApp/logs.txt", true));
            bf.write("\n"+" Se ha producido una nueva invercin la cual es "+ invercion + " la cual fue realizada por el usuario " + usuario + "\n");
            bf.write("\n"+" la fecha en la que se elimino el proyecto fue " + LocalDateTime.now());
            bf.close();
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        }
    }

}

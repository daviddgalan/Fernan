package Modelos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Persistencia implements Serializable {

    public void guardarObjetos(HashMap<String, Usuario> gestorDeUsuarios){
        try {
            ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("RegistrosDeApp/AlmacenDeObjetos.txt"));
            oss.writeObject(gestorDeUsuarios);
            oss.close();
        }catch (IOException e){
            System.out.println("archivo no encontrado");
        }
    }

    public HashMap<String, Usuario> imprimirObjeto(){
        HashMap<String, Usuario> objetoLeido = new HashMap<>();
        try {
            ObjectInputStream oss = new ObjectInputStream(new FileInputStream("RegistrosDeApp/AlmacenDeObjetos.txt"));
            objetoLeido = (HashMap<String, Usuario>) oss.readObject();
            oss.close();
        }catch (IOException e){
            System.out.println("Fichero no encontarado");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objetoLeido;
    }

    public void guardarProyectos(ArrayList<Proyecto> Proyecto){
        try {
            ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("RegistrosDeApp/AlmacenDeProyectos.txt"));
            oss.writeObject(Proyecto);
            oss.close();
        }catch (IOException e){
            System.out.println("archivo no encontrado");
        }
    }

    public ArrayList<Proyecto> imprimirProyectos(){
        ArrayList<Proyecto> objetoLeido = new ArrayList<>();
        try {
            ObjectInputStream oss = new ObjectInputStream(new FileInputStream("RegistrosDeApp/AlmacenDeProyectos.txt"));
            objetoLeido = (ArrayList<Proyecto>) oss.readObject();
            oss.close();
        }catch (IOException e){
            System.out.println("Fichero no encontarado");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return objetoLeido;
    }

}

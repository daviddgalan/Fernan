package FuncionesDeCadenas;

import java.io.Serializable;
import java.util.Scanner;

public class Cadenas implements Serializable {
    public static boolean ConfirmaContra (String contraseña1 ,String contraseña2){
            if (contraseña1.equals(contraseña2)){
                return true;
            }
            else {
              return false;
            }
    }

    //--------------------------------------------------------------------------
    /**
     * @author SERGIO
     * @return Esta función comprueba si la cadena tiene números, símbolos, mayúsculas y minúsculas y por último una longitud minima a 8 caractéres (Hace referencia a la función ConfirmaContra).
     */
    //--------------------------------------------------------------------------


    private static char extraerLetra(String palabra,int pocicion){
        return palabra.charAt(pocicion);
    }

    public static boolean FortalezaContraseña (String contraseña) {
        int contador = 0;
        String[] caracteres ={"abcdefghijklmnñopqrstuvwxz", "ABCDEFGHIJKLMNÑOPQRSTUVWXZ", "0123456789", "-_@.*#" };
        for (String caractere : caracteres) {
            for (int j = 0; j < contraseña.length(); j++) {
                for (int k = 0; k < caractere.length(); k++) {
                    if (extraerLetra(caractere, k) == extraerLetra(contraseña, j)) {
                        contador++;
                        j = contraseña.length();
                        break;
                    }
                }
            }
        }
       return fortaleza(contador);
    }

    private static boolean fortaleza(int valoracionDeFortaleza){
        if ( valoracionDeFortaleza == 4){
            return true;
        }else {
            return false;
        }
    }


    public static boolean minimoTituloProyecto(String titulo){
        if(titulo.length()<2||titulo.length()>6){
            return false;
        }else{
            return true;
        }
    }

    public static boolean minimoDescripcionProyecto(String descripcion){
        if(descripcion.length()<5||descripcion.length()>20){
            return false;
        }else{
            return true;
        }
    }
    public static boolean comprobarCorreo(String coreo ){
        if(coreo.contains("@")&&coreo.contains(".com")){
            return true;
        }else{
            return false;
        }
    }

}

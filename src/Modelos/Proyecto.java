package Modelos;

import Inversión.Inversion;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Proyecto implements Serializable {
    private String id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private float cantidadNecesaria;
    private int cantidadFinanciada;
    private LocalDate fechaDeApertura;
    private LocalDate fechaDeFin;
    private ArrayList <RecompensasDeProyecto> recompensas;
    private ArrayList<Inversion> invercionesRealizadas;

    public Proyecto(String nombre, String descripcion, Categoria categoria, int cantidadNecesaria, int cantidadFinanciada, LocalDate fechaDeApertura, LocalDate fechaDeFin,String id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.cantidadNecesaria = cantidadNecesaria;
        this.cantidadFinanciada = cantidadFinanciada;
        this.fechaDeApertura = fechaDeApertura;
        this.fechaDeFin = fechaDeFin;
        this.id = id;
        recompensas = new ArrayList<>();
        invercionesRealizadas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadNecesaria(float cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCantidadFinanciada(int cantidadFinanciada) {
        this.cantidadFinanciada = cantidadFinanciada;
    }

    public int getCantidadNecesaria(){
        return (int) cantidadNecesaria;
    }


    public void setFechaDeApertura(LocalDate fechaDeApertura) {
        this.fechaDeApertura = fechaDeApertura;
    }

    public void setFechaDeFin(LocalDate fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }

    public void añadirRecompensa(RecompensasDeProyecto recompensasDeProyecto){
        recompensas.add(recompensasDeProyecto);
    }

    public ArrayList<RecompensasDeProyecto> verArrayDeProyecto(){
        return recompensas;
    }

    public void modificarRecompensa(RecompensasDeProyecto nuevaRecompensa, String idRecompensa){
        for (int i = 0; i <recompensas.size() ; i++) {
            if(recompensas.get(i).getIdDeRecompensa().equals(idRecompensa)){
                recompensas.add(i,nuevaRecompensa);
            }
        }
    }

    public void añadirInvercion(Inversion inversion){
        invercionesRealizadas.add(inversion);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Inversion> getInvercionesRealizadas() {
        return invercionesRealizadas;
    }

    public int getCantidadFinanciada() {
        return cantidadFinanciada;
    }

    public LocalDate getFechaDeApertura() {
        return fechaDeApertura;
    }

    @Override
    public String toString() {
        return "El nombre del proyecto es " + nombre +
                "\n su descripción es " + descripcion +
                "\n Pertenece a la categoría " + categoria +
                "\n Se necesita una cantidad de " + cantidadNecesaria +
                "\n hasta ahora se ha financiado " + cantidadFinanciada +
                "\n La fecha de apertura fue " + fechaDeApertura +
                "\n la fecha de finalización es " + fechaDeFin +
                "\n Las recompensas ofrecidas son de " + recompensas;
    }
}

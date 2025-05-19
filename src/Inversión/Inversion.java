package Inversión;

import Modelos.Inversor;
import Modelos.Proyecto;

import java.io.Serializable;
import java.time.LocalDate;

public class Inversion implements Serializable {
    private Proyecto proyecto1;
    private float cantidadInvertida;
    private LocalDate fechaDeInversion;
    private Inversor inversor;

    public Inversion(Proyecto proyecto, float cantidadInvertida, LocalDate fechaDeInvercion,Inversor inversor) {
        this.proyecto1 = proyecto;
        this.cantidadInvertida = cantidadInvertida;
        this.fechaDeInversion = fechaDeInvercion;
        this.inversor = inversor;
    }

    public float getCantidadInvertida() {
        return cantidadInvertida;
    }

    public Proyecto getProyecto1() {
        return proyecto1;
    }

    public Inversor getInversor() {
        return inversor;
    }

    @Override
    public String toString() {
        return "Inversion{" +
                "proyecto=" + proyecto1 +
                ", cantidadInvertida=" + cantidadInvertida +
                ", fechaDeInversion=" + fechaDeInversion +
                ", inversor=" + inversor +
                '}';
    }
}

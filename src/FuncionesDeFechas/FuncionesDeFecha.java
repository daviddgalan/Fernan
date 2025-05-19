package FuncionesDeFechas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FuncionesDeFecha implements Serializable {

    public LocalDate comventriFecha(String fecha){
        return LocalDate.parse(fecha,darFormato());
    }

    private DateTimeFormatter darFormato(){
          DateTimeFormatter fomato = DateTimeFormatter.ofPattern("dd/MM/aaaa");
          return fomato;
    }

    public boolean fechaAnterior(LocalDate fecha1,LocalDate fecha2){
        if (fecha1.isBefore(fecha2)) {
           return true;
        } else {
           return false;
        }
    }

    public String tiempoRestanteEntreFechas(LocalDate fecha1 , LocalDate fecha2){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd hh:mm:ss:SSSSSS");
        long dias = ChronoUnit.DAYS.between(fecha1, fecha2);
        long horas = ChronoUnit.HOURS.between(fecha1, fecha2);
        long minutos = ChronoUnit.MINUTES.between(fecha1, fecha2);
        long segundos = ChronoUnit.SECONDS.between(fecha1, fecha2);
        return String.format(String.valueOf(formato),dias,horas,minutos,segundos);
    }

}

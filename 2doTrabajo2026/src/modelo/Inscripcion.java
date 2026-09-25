package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import actividades.*;

public class Inscripcion implements Serializable {
    private LocalDate fecha;
    private String estado;
    public Actividad k;
    public Estudiante j;

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Inscripcion(LocalDate fecha, String estado, Actividad k, Estudiante j) {
        this.fecha = fecha;
        this.estado = estado;
        this.k = k;
        this.j = j;
    }


}

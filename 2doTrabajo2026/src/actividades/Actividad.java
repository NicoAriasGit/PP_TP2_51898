package actividades;

import hilos.EnvioTicketsThread;
import modelo.Estudiante;
import modelo.Inscripcion;

import modelo.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.*;
import org.w3c.dom.ls.LSOutput;

public abstract class Actividad implements Serializable {
    public int id;
    public String titulo;
    public int cupomax;
    private final int cupomin=1;
    public List<Estudiante> estudianteList;

    public Actividad(){};

    public Actividad(int id, String titulo, int cupomax) {
        this.id = id;
        this.titulo = titulo;
        this.cupomax = cupomax;
        this.estudianteList = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCupomax() {
        return cupomax;
    }

    public void setCupomax(int cupomax) {
        this.cupomax = cupomax;
    }


    public Inscripcion inscribir (Estudiante estudiante) throws CupoExcedidoException{
        if((estudianteList.size())<cupomax){
            Inscripcion inscripcion = new Inscripcion(LocalDate.now(), "Inscripto", this , estudiante);
        estudianteList.add(estudiante);
            return inscripcion;
        }else{
            throw new CupoExcedidoException("No se pueden inscribir más de "+ cupomax + " estudiantes.");
        }

    };

    public void mostrarInscripciones() {
        if(!estudianteList.isEmpty()) {
            for (Estudiante estudiante : estudianteList)
                System.out.println("Inscriptos:" + estudiante.getNombre());
        }
        else{
            System.out.println("No hay estudiantyes inscriptos.");
        }};

    public abstract double calcularCostoMateriales();

    public final void mostrarIdentificacion(){;};

    public String getTipo(){
        return ""+this.getClass()+""; };

    public void reiniciarLista(){
        this.estudianteList= null;
        this.estudianteList= new ArrayList<>();
    };

}


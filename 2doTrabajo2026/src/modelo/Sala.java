package modelo;

import java.io.Serializable;

public class Sala implements Serializable {
    private int Id;
    private String Nombre;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Sala(int id, String nombre) {
        Id = id;
        Nombre = nombre;
    }
}

package actividades;

import modelo.*;

public class Charla extends Actividad {
    public String disertante;

    public double calcularCostoMateriales(){
        return 0;
    }

    public String getTipo(){
        return "Charla";
    }

    public String getDisertante() {
        return disertante;
    }

    public void setDisertante(String disertante) {
        this.disertante = disertante;
    }

    public Charla(int id, String titulo, int cupomax, String disertante) {
        super(id, titulo, cupomax);
        this.disertante = disertante;
    }


    public void clonar(Charla k){
        id= k.id;
        titulo = k.titulo;
        cupomax = k.cupomax;
        }
}

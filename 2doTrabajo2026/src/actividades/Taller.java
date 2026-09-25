package actividades;
import modelo.Certificacion.Certificable;
import modelo.*;
public class Taller extends Actividad implements Certificable {
    public boolean requiereNotebook;

    @Override public double calcularCostoMateriales(){
        if(requiereNotebook){return 5000;}
        else{return 2000;}
    }


    public String getTipo(){
        return "Taller";
    }

    public boolean isRequiereNotebook() {
        return requiereNotebook;
    }

    public void setRequiereNotebook(boolean requiereNotebook) {
        this.requiereNotebook = requiereNotebook;
    }

    public Taller(int id, String titulo, int cupomax, boolean requiereNotebook) {
        super(id, titulo, cupomax);
        this.requiereNotebook = requiereNotebook;
    }

    @Override
    public String generarCertificadoEstudiante(Estudiante estudiante) {
        return "El estudiante "+estudiante.getNombre()+" está certificado.";
    }

    public void clonar(Taller k){
        id= k.id;
        titulo = k.titulo;
        cupomax = k.cupomax;
        }
}

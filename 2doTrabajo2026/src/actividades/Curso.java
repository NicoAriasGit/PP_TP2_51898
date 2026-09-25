package actividades;
import modelo.*;
import modelo.Certificacion.*;

public class Curso extends Actividad implements Certificable{
    public int nivel;

    @Override
    public double calcularCostoMateriales() {
        return 3500;
    }


    public Curso(int id, String titulo, int cupomax, int nivel) {
        super(id, titulo, cupomax);
        this.nivel = nivel;
    }

    @Override
    public String generarCertificadoEstudiante(Estudiante estudiante) {
        return "El estudiante "+estudiante.getNombre()+" está certificado.";
    };

    public void clonar(Actividad k){
        id= k.id;
        titulo = k.titulo;
        cupomax = k.cupomax;
        }
    }

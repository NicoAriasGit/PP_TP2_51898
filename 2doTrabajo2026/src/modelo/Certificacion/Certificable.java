package modelo.Certificacion;
import modelo.*;

import java.util.List;

public interface Certificable{
    public String ENTIDAD_EMISORA= null;

    public String generarCertificadoEstudiante(Estudiante estudiante);
    ;
}

import actividades.*;
import modelo.*;
import excepciones.*;

///
/// Para dar un ejemplo más visible del error de cupo excedido, se redujo el cupo mínimo a 1 persona y el máximo a 2 en Presentacion_historia
///
/// Los resultados del filtrado se guardan en evento_21.filtro
///
/// Se vuelve a usar código del TP1 para demostrar diferencias
///
///
class AppMain {
    public static void main(String[] args) {
        Estudiante Roberto_A = new Estudiante("Roberto_A","32445");
        Estudiante Luciana_H = new Estudiante("Luciana_H","63441");
        Estudiante Francisco_G = new Estudiante("Francisco_G ", "92558");
        Estudiante Manuel_R = new Estudiante("Manuel_R", "70322");


        Sala Salón_21 = new Sala(23, "Salón_12");
        Sala Computación = new Sala(12, "Computación");

        Actividad CharlaHistoria = new Charla(123,"Presentación Histórica",2, "Manuel Benavídez");
        Actividad CharlaArte = new Charla(1, "Discernimiento de influencias en el arte", 4, "Nahuel Díaz");
        Actividad TallerProgamación = new Taller(441, "Python", 30, true);
        Actividad CursoProgramación = new Curso(32,"Presentación de programación funcional", 25, 12);


        EventoUniversitario evento_21 = new EventoUniversitario("Efecto histórico de la cultura general en la política",1250,false);
        EventoUniversitario evento_22 = new EventoUniversitario("Principios de la programación en python",500,false);

        try {
            CharlaHistoria.inscribir(Luciana_H);
            CharlaHistoria.inscribir(Roberto_A);
            CharlaHistoria.inscribir(Francisco_G);
        }catch(CupoExcedidoException e){
            System.out.println("No se pueden inscribir más de "+ CharlaHistoria.cupomax+" estudiantes.");
        }

        CharlaHistoria.reiniciarLista();
        ///Esto asegura que no sucedan errores

        try{
            CharlaHistoria.inscribir(Luciana_H);
            CharlaHistoria.inscribir(Roberto_A);

            evento_21.crearActividad(CharlaHistoria);

            evento_21.asignarSala(Salón_21);

            evento_21.persistirEvento();

            EventoUniversitario.recuperarEvento(evento_21.getTitulo());

            CharlaHistoria.mostrarInscripciones();

            evento_21.mostrarDatos();
        }
        catch (CupoExcedidoException e){
            System.out.println("No se pueden inscribir más de "+ CharlaHistoria.cupomax+" estudiantes.");
        }

        try{
            TallerProgamación.inscribir(Manuel_R);
            TallerProgamación.inscribir(Francisco_G);
            TallerProgamación.inscribir(Luciana_H);

            CursoProgramación.inscribir(Manuel_R);
            CursoProgramación.inscribir(Francisco_G);
            CursoProgramación.inscribir(Luciana_H);
            CursoProgramación.inscribir(Roberto_A);

            evento_22.crearActividad(CursoProgramación);
            evento_22.crearActividad(TallerProgamación);

            evento_22.asignarSala(Computación);

            evento_22.persistirEvento();
            EventoUniversitario.recuperarEvento(evento_22.getTitulo());
        }
        catch(RuntimeException e){
        }


        evento_21.crearActividad(CharlaArte);
        evento_21.crearActividad(TallerProgamación);

        evento_21.filtrarActividadesPorTipo(Taller.class);
        evento_21.calcularCostoMateriales(evento_21.filtro);


    };



}

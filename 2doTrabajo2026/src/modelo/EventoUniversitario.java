package modelo;

import actividades.*;
import modelo.Certificacion.Certificable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario implements Serializable {
    private final int Id= (CantidadEventos+1) ;
    private String Titulo;
    private double CostoBase=0;
    public boolean Gratuito= false;
    public static int CantidadEventos = 0;
    public Sala sala;
    public List<Actividad> actividades;

    ///El filtro se deja como público por si se quiere usarlo para calcular los precios de la lista en este.
    public List<Actividad> filtro= new ArrayList();


    public EventoUniversitario(){
        CantidadEventos++;
        this.actividades= new ArrayList<>();

    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo != null && !titulo.isBlank()) {this.Titulo = titulo;}
    }

    public int getId() {
        return Id;
    }


    public double getCostoBase() {
        return CostoBase;
    }

    public void setCostoBase(double costoBase) {
        this.CostoBase = costoBase;
    }

    public boolean isGratuito() {
        return Gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.Gratuito = gratuito;
    }

    public int getCantidadEventos() {
        return CantidadEventos;
    }

    public EventoUniversitario(EventoUniversitario k){
        Titulo= k.Titulo;
        CostoBase = k.CostoBase;
        Gratuito = k.Gratuito;
        sala= k.sala;
        CantidadEventos ++;
    }

    public EventoUniversitario(String titulo, double costoBase, boolean gratuito) {
        this.Titulo = titulo;
        this.Gratuito = gratuito;
        this.CostoBase= gratuito ? 0 : costoBase;
        this.actividades= new ArrayList<>();
        CantidadEventos ++;
    }

    public void mostrarDatos(){
        System.out.println("Nombre: " + this.Titulo);
        System.out.println("Costo base: " + this.CostoBase);
        System.out.println("Id Evento: " + this.Id);
        System.out.println("Sala: " + sala.getNombre());
        System.out.println("Hay " + actividades.size() +" actividades: ");
        for(Actividad actividades: actividades){
            System.out.println("- "+ actividades.getTitulo() + ", ID: " + actividades.getId()+".");
        }
        System.out.println("Costo estimado: " + calcularCostoEstimado());
    };

    public void asignarSala (Sala Sala){
        this.sala = Sala;
        };

   public void crearActividad(Actividad k){
           actividades.add(k);
   ;}

    public double calcularCostoEstimado(){
        if(isGratuito()){
            return 0;}
        else{
            double k= 0;
            for(Actividad actividad:actividades)
            {k= k + actividad.calcularCostoMateriales();
            }
            return (k+ getCostoBase())*1.21;}

    }


    public <T extends Actividad> List<T> filtrarActividadesPorTipo (Class<T> tipo){
       for (Actividad cadaActividad: actividades){
           if(tipo.isInstance(cadaActividad)){
                filtro.add(cadaActividad);
           }
       }
        if(filtro.isEmpty()){
            System.out.println("No hay resultados para su búsqueda.");
        }else{
            System.out.println("Hay "+filtro.size()+" resultados para su búsqueda:");
            for(Actividad medio: filtro){
                System.out.println("- Nombre: "+medio.titulo+", Id: "+ medio.id+" .");

            }
        }
       return null;
    }


   public double calcularCostoMateriales(List<? extends Actividad> actividades){
        double j;
        if(actividades.isEmpty()){
            System.out.println("No hay elementos en la lista dada.");
        return 0;}
        else {
        EventoUniversitario reciclado = new EventoUniversitario();
        for(Actividad leer: actividades ){
          reciclado.crearActividad(leer);
        }
        j= reciclado.calcularCostoEstimado();
        reciclado= null;
       System.out.println("Se han usado los elementos de la lista para calcular un costo de " + j+" .");
        return j;}
    }

    public Boolean persistirEvento(){
        try{
            FileOutputStream fos = new FileOutputStream(Titulo+".dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        } catch(FileNotFoundException exception){
            System.out.println("Archivo no encontrado.");
            return false;
        } catch(IOException exception){
            System.out.println("Error de E/s.");
            return false;
        };
        return true;}

    public static EventoUniversitario recuperarEvento(String nuevoNombre){
       EventoUniversitario eventoUniversitario= null;
       try{

        FileInputStream fis = new FileInputStream(nuevoNombre+".dat");
        ObjectInputStream ois = new ObjectInputStream (fis);
        eventoUniversitario= (EventoUniversitario) ois.readObject();
        ois.close();}
       catch(FileNotFoundException exception){
           System.out.println("Archivo no encontrado.");
           return null;
       }
       catch(IOException exception){
           System.out.println("Error de E/s.");
           return null;
       }
       catch(ClassNotFoundException exception){
           System.out.println("No se ha encontrado la clase.");
           return null;
       }

        return eventoUniversitario;
    }








}

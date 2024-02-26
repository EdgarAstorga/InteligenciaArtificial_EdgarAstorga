package Puzzle;
import java.util.Collection;

public class AppPuzzle {

    public static final String ESTADO_INICIAL = "12578 346";
public static final String ESTADO_FINAL = "12345678 ";

    
    public static void main(String[] args) {
    	
        //Instanciar el arbol
        BusquedaArbol a = new BusquedaArbol(new Nodo(ESTADO_INICIAL), ESTADO_FINAL);
        //Ejecuta la busqueda
        
        //Anchura
        long inicioAnchura = System.nanoTime();
        System.out.println("Busqueda por Anchura");
        a.busquedaPorAnchura();
        long finAnchura = System.nanoTime();
        long tiempoAnchura = finAnchura - inicioAnchura;
        System.out.println("Segundos: " + (float) tiempoAnchura / 1000000000);
 
        
        //Profundidad
        long inicioProfundidad = System.nanoTime();
        System.out.println("Profundidad");
        a.busquedaPorProfundidad();
        long finProfundidad = System.nanoTime();
        long tiempoProfundidad = finProfundidad - inicioProfundidad;
        System.out.println("Segundos: "+(float)tiempoProfundidad/1000000000);
       
        //Imprime movimientos
        
        System.out.println("Busqueda por Anchura");
        System.out.println("Segundos: "+(float)tiempoAnchura/1000000000);
        System.out.println("Busqueda por Profundidad");
        System.out.println("Segundos: "+(float)tiempoProfundidad/1000000000);
       
    } 
}
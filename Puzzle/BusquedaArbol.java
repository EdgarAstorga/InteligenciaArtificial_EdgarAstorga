package Puzzle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class BusquedaArbol {
    
    Nodo raiz;
    String objetivo;
    
    public BusquedaArbol(Nodo raiz, String objetivo)
    {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }
    
    
    
    
    public int costo(String estado ) {
    	int counter=0;
    	for (int i =0 ; i<estado.length();i++) {
    		 if (estado.charAt(i)!= raiz.getEstado().charAt(i)){
    			 counter++;
    		 }
    	}  return counter;
    	
    }    
    
    
    public void busquedaPorAnchura()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<Nodo> estadosPorVisitar = new LinkedList();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println("NODO OBJETIVO ENCONTRADO");
        System.out.println(imprimir(nodoActual));
        System.out.println(nodoActual);
    }
    
    
    
    
    public void busquedaPorProfundidad()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Stack<Nodo> estadosPorVisitar = new Stack();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.pop();
        }
        System.out.println("SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(imprimir(nodoActual));
        System.out.println(nodoActual);
    }
    public String imprimir(Nodo nodoActual) {
    	
    	Nodo nodoImprimir = nodoActual;
    	String nodoString = "";
    	
    	do {
    		 nodoImprimir= nodoImprimir.getPadre();
    		 nodoString= nodoImprimir+"\n"+nodoString;
    		
    	} while(nodoImprimir != raiz);
    	
    	return nodoString;
    }
    
    
    
}
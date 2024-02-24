package ArbolB;

public class AppArbol {
    
    public static void main(String[] args) {
        
        Arbol arbol = new Arbol();

        System.out.println(arbol.isEmpty()? "Arbol vacio" : "Arbol no vacio" );
        
        arbol.insert("a");
        arbol.insert("b");
        arbol.insert("c");
        arbol.insert("d");
        System.out.println("Se insertaron los datos");
        
        // Buscar Nodo
        System.out.print("Se encontro el ");

        System.out.println(arbol.searchNodo("a"));
        
        // Imprimir
        System.out.println("Arbol:");
       
        arbol.printArbol();
        
    }
    
}
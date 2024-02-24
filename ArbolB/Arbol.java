package ArbolB;

public class Arbol {
    
    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    
    public Nodo searchNodo(String nombre) {
        return searchNodo(raiz, nombre);
    }

    private Nodo searchNodo(Nodo nodo, String nombre) {
        if (nodo == null || nodo.getNombre().equals(nombre)) {
            return nodo;
        }
        if (nombre.length() <= nodo.getNombre().length()) {
            return searchNodo(nodo.getIzquierdo(), nombre);
        }
        return searchNodo(nodo.getDerecho(), nombre);
    }

    public void insert(String nombre) {
        raiz = insertNodo(raiz, nombre);
    }

    private Nodo insertNodo(Nodo nodo, String nombre) {
        if (nodo == null) {
            return new Nodo(nombre);
        }
        if (nombre.length() <= nodo.getNombre().length()) {
            nodo.setIzquierdo(insertNodo(nodo.getIzquierdo(), nombre));
        } else {
            nodo.setDerecho(insertNodo(nodo.getDerecho(), nombre));
        }
        return nodo;
    }

    public void printArbol() {
        printArbol(raiz);
    }

    private void printArbol(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getNombre());
            printArbol(nodo.getIzquierdo());
            printArbol(nodo.getDerecho());
        }
    }
}
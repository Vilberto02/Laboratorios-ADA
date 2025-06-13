package clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
class NodoBST {
    Cliente cliente;
    NodoBST izquierdo;
    NodoBST derecho;

    public NodoBST(Cliente cliente) {
        this.cliente = cliente;
        this.izquierdo = null;
        this.derecho = null;
    }
}

class ArbolBinarioBusqueda {
    NodoBST raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public void insertar(Cliente cliente) {
        raiz = insertarRec(raiz, cliente);
    }

    private NodoBST insertarRec(NodoBST actual, Cliente cliente) {
        if (actual == null) {
            return new NodoBST(cliente);
        }

        
        if (cliente.getClavePrincipal().compareTo(actual.cliente.getClavePrincipal()) < 0) {
            actual.izquierdo = insertarRec(actual.izquierdo, cliente);
        } else if (cliente.getClavePrincipal().compareTo(actual.cliente.getClavePrincipal()) > 0) {
            actual.derecho = insertarRec(actual.derecho, cliente);
        } 
        return actual;
    }

    public Cliente buscar(String nombres, String apellidos) {
        String claveBusqueda = (nombres + " " + apellidos).toLowerCase();
        return buscarRec(raiz, claveBusqueda);
    }

    private Cliente buscarRec(NodoBST actual, String claveBusqueda) {
        if (actual == null) {
            return null;
        }
        if (claveBusqueda.equals(actual.cliente.getClavePrincipal())) {
            return actual.cliente;
        }
        if (claveBusqueda.compareTo(actual.cliente.getClavePrincipal()) < 0) {
            return buscarRec(actual.izquierdo, claveBusqueda);
        } else {
            return buscarRec(actual.derecho, claveBusqueda);
        }
    }
    
    public int getProfundidad() {
        return getProfundidadRec(raiz);
    }

    private int getProfundidadRec(NodoBST nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(getProfundidadRec(nodo.izquierdo), getProfundidadRec(nodo.derecho));
    }
}
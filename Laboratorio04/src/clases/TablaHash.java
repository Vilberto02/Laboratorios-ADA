/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class TablaHash {
    private Cliente[] tabla;
    private int tamano;
    private int elementos;
    private static final Cliente BORRADO = new Cliente("-1", "BORRADO", "BORRADO", "", "", "", ""); // Marcador especial

    public TablaHash(int tamano) {
        this.tamano = tamano;
        this.tabla = new Cliente[tamano];
        this.elementos = 0;
    }

    private int funcionHash(String clave) {
        return Math.abs(clave.hashCode()) % tamano;
    }

    public String insertar(Cliente cliente) {
        if ((double) elementos / tamano >= 0.7) { // Factor de carga
            return "Tabla demasiado llena, inserción fallida.";
        }

        String clave = cliente.getClavePrincipal();
        int indice = funcionHash(clave);
        int indiceOriginal = indice;
        int intentos = 0;

        while (tabla[indice] != null && tabla[indice] != BORRADO && !tabla[indice].getClavePrincipal().equals(clave) && intentos < tamano) {
            indice = (indice + 1) % tamano; 
            intentos++;
            if (indice == indiceOriginal) { 
                 return "Tabla llena o bucle infinito";
            }
        }
        
        if (intentos == tamano && tabla[indice] != null && tabla[indice] != BORRADO) {
             return "No se pudo encontrar espacio.";
        }


        if (tabla[indice] == null || tabla[indice] == BORRADO) {
            tabla[indice] = cliente;
            elementos++;
            return "Insertado en índice " + indice + " (intentos: " + (intentos+1) + ")";
        } else if (tabla[indice].getClavePrincipal().equals(clave)) {
            return "Ya existe un cliente con la misma clave principal" + indice;
        }
        return "Error al insertar";
    }

    public ResultadoBusqueda buscar(String nombres, String apellidos) {
        String clave = (nombres + " " + apellidos).toLowerCase();
        int indice = funcionHash(clave);
        int indiceOriginal = indice;
        int intentos = 0;
        long tiempoInicio = System.nanoTime();

        while (tabla[indice] != null && intentos < tamano) {
            if (tabla[indice] != BORRADO && tabla[indice].getClavePrincipal().equals(clave)) {
                long tiempoFin = System.nanoTime();
                return new ResultadoBusqueda(tabla[indice], (tiempoFin - tiempoInicio), intentos + 1);
            }
            indice = (indice + 1) % tamano;
            intentos++;
            if (indice == indiceOriginal && tabla[indice] == null) {
                 break;
            }
             if (indice == indiceOriginal && tabla[indice] != null && !tabla[indice].getClavePrincipal().equals(clave) ){
                 break;
             }
        }
        long tiempoFin = System.nanoTime();
        return new ResultadoBusqueda(null, (tiempoFin - tiempoInicio), intentos + 1);
    }
}
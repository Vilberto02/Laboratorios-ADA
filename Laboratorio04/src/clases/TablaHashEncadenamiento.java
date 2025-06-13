/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class TablaHashEncadenamiento {
    private ArbolBinarioBusqueda[] tabla;
    private int tamano;
    private int elementos;

    public TablaHashEncadenamiento(int tamano) {
        this.tamano = tamano;
        this.tabla = new ArbolBinarioBusqueda[tamano];
        for (int i = 0; i < tamano; i++) {
            tabla[i] = new ArbolBinarioBusqueda(); 
        }
        this.elementos = 0;
    }

    private int funcionHash(String clave) {
        return Math.abs(clave.hashCode()) % tamano;
    }

    public String insertar(Cliente cliente) {
        String clave = cliente.getClavePrincipal();
        int indice = funcionHash(clave);
        
        if (tabla[indice].buscar(cliente.getNombres(), cliente.getApellidos()) != null) {
            return "Ya existe un cliente con misma clave principal en el BST del índice " + indice;
        }

        tabla[indice].insertar(cliente);
        elementos++;
        return "Insertado en BST del índice " + indice + ". Profundidad del BST: " + tabla[indice].getProfundidad();
    }

    public ResultadoBusqueda buscar(String nombres, String apellidos) {
        String clave = (nombres + " " + apellidos).toLowerCase();
        int indice = funcionHash(clave);
        long tiempoInicio = System.nanoTime();
        
        Cliente encontrado = tabla[indice].buscar(nombres, apellidos);
        
        long tiempoFin = System.nanoTime();
        int intentos = (encontrado != null) ? tabla[indice].getProfundidad() : 1;
        
        return new ResultadoBusqueda(encontrado, (tiempoFin - tiempoInicio), intentos);
    }
}
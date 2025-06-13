/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
// ResultadoBusqueda.java
public class ResultadoBusqueda {
    Cliente cliente;
    long tiempoNs;
    int intentos;

    public ResultadoBusqueda(Cliente cliente, long tiempoNs, int intentos) {
        this.cliente = cliente;
        this.tiempoNs = tiempoNs;
        this.intentos = intentos;
    }

    public Cliente getCliente() { return cliente; }
    public long getTiempoNs() { return tiempoNs; }
    public int getIntentos() { return intentos; }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class Principal {
    public static void main(String[] args){
        
        // Valores de m y n.
        int m = 1,n = 2;
        
        
        AckermannR ack = new AckermannR();
        System.out.println("Algoritmo recursivo Ackermann-Peter");
        long tInicial = System.currentTimeMillis();
        System.out.println("Resultado para los valores de "+m+" y "+n+": "+ ack.ackermannPrimitivo(m, n));
        long tFinal = System.currentTimeMillis();
        double tTranscurrido = (tFinal - tInicial)/1000.0;
        System.out.println("Tiempo transcurrido: "+ tTranscurrido);
        
        
        AckermannIterativo ackIte = new AckermannIterativo();
        System.out.println("\n\n\nAlgoritmo iterativo de Ackermann-Peter");
        long t2Inicial = System.currentTimeMillis();
        System.out.println("Resultado para los valores de "+m+" y "+n+": "+ ackIte.ackermannIterativo(m, n));
        long t2Final = System.currentTimeMillis();
        double t2Transcurrido = (t2Final - t2Inicial)/1000.0;
        System.out.println("Tiempo transcurrido: "+ t2Transcurrido);
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PatricioJulca
 */
public class Principal {
    // Arreglo de números
    public static void main(String[] args){
        int secuencia[] = {-2, 11, -4, 13, -5, 9, -3, 2, -8, 4};
        System.out.println("--- Suma Maxima Consecutiva ---");
        System.out.println("Secuencia de numeros con un tamanio de "+ secuencia.length);
        System.out.print("Valores: ");
        for (int i = 0; i < secuencia.length ; i++) {
            System.out.print(secuencia[i] + " ");    
        }
        System.out.println();
        
        Subsecuencia subsecuencia = new Subsecuencia();
        System.out.println("\n-> Suma maxima: "+subsecuencia.getSumaMax(secuencia));
    }
}

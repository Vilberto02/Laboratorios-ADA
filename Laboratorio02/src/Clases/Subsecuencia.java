/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PatricioJulca
 */
public class Subsecuencia {
    private int sumaMax = 0;
    private int sumaParcial = 0;

    public int getSumaMax(int[] vector) {
        // Recorrido del vector o arreglo de números.
        for(int item: vector){
            sumaParcial += item;
            if(sumaParcial < 0){
                sumaParcial = 0;
            }
            
            // Usamos el método de la clase Math para obtener el máximo valor.
            sumaMax = Math.max(sumaMax, sumaParcial);
        }
        
        return sumaMax;
    }
    
    
}

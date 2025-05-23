/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class AckermannIterativo {
    
    // Usamos pilas para simular al algoritmo recursivo y obtener un algoritmo iterativo.
    public int ackermannIterativo(int m, int n) {
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("m y n deben ser no negativos.");
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(m);
        
        // Valor actual de n. Cuando la pila este vacia, n será el resultado final.
        int nActual = n;

        while (!stack.isEmpty()) {
            int mActual = stack.pop();

            if (mActual == 0) {
                // Caso base: A(0, N) = N + 1
                nActual = nActual + 1;
                
            } else if (nActual == 0) {
                // Caso A(m, 0) = A(m-1, 1)
                stack.push(mActual - 1);
                nActual = 1;
            } else {
                // Caso A(m, n) = A(m-1, A(m, n-1)) donde m > 0, n > 0
                stack.push(mActual - 1);
                stack.push(mActual);
                nActual = nActual - 1;
            }
        }
        
        return nActual;
    }
}

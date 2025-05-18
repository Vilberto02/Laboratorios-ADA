/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class AckermannPrimitivo {
    private int _value;
    
    public int ackermannPrimitivo(int m, int n){
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("m y n deben ser no negativos.");
        }
        
        if (m == 0){
            _value = n + 1;
        }else {
            if(n == 0){
                _value = ackermannPrimitivo(m - 1, 1);
            } else if (n > 0){
               // Operación interna
                int res = ackermannPrimitivo(m, n - 1);
                
                _value = ackermannPrimitivo(m - 1, res);
            }
        }
        
        return _value;
    }
}

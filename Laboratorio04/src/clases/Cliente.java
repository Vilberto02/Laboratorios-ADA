/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Cliente {
    String codigo;
    String nombres;
    String apellidos;
    String telefono;
    String correo;
    String direccion;
    String codigoPostal;

    public Cliente(String codigo, String nombres, String apellidos, String telefono, String correo, String direccion, String codigoPostal) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public String getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
    public String getCodigoPostal() { return codigoPostal; }

    public String getClavePrincipal() {
        return (nombres + " " + apellidos).toLowerCase();
    }

    @Override
    public String toString() {
        return "Cliente{" +
               "codigo='" + codigo + '\'' +
               ", nombres='" + nombres + '\'' +
               ", apellidos='" + apellidos + '\'' +
               ", telefono='" + telefono + '\'' +
               ", correo='" + correo + '\'' +
               ", direccion='" + direccion + '\'' +
               ", codigoPostal='" + codigoPostal + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return getClavePrincipal().equals(cliente.getClavePrincipal());
    }

    @Override
    public int hashCode() {
        return getClavePrincipal().hashCode();
    }
}



package banco;

import java.time.LocalDate;

public class Cliente extends Persona {
    // Atributos
    private String titular;
    private float sueldo;
    private int password; // contraseña de 10 digitos numericos
    private String productos; // los tipos de productos que ofrece el banco

    // Metodos
    // Metodos contructor
    public Cliente(String nombre, LocalDate fechaNacimiento, String rut, String titular, float sueldo,
            int password, String productos) {
        this.titular = titular;
        this.sueldo = sueldo;
        this.password = password;
        this.productos = productos;
    }

    // Getters y Setters
    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

}
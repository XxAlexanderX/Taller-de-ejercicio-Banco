
//package banco;
import java.time.LocalDate;
import java.util.Scanner;

public class Cuenta extends Cliente {
    // Atributos

    private String titular;
    private float sueldo;
    private float movimiento;

    // Metodo Contructo
    public Cuenta(String nombre, LocalDate fechaNacimiento, String rut, String titular, float sueldo, int password,
            String productos, String titular2, float sueldo2, float movimiento) {
        super(nombre, fechaNacimiento, rut, titular, sueldo, password, productos);
        titular = titular2;
        sueldo = sueldo2;
        this.movimiento = movimiento;
    }

    // Metodo de movimiento
    public void hacermov() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Menu de opciones");
            System.out.println("Opcion 1 Abonar");
            System.out.println("Opcion 2 Retirar");
            int opciones = sc.nextInt();
            if (opciones == 1) {
                System.out.println("Cuanto decea Abonar");
            } else {
                System.out.println("Cuanto decea Retirar");
            }
            sc.close();
        }
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

    public float getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(float movimiento) {
        this.movimiento = movimiento;
    }

}

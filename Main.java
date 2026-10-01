package banco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Integrantes: Matias Riquelme, Brayan Martinez
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Ejecutivo> ejecutivos = new ArrayList<>();
    static ArrayList<Cuenta> cuentas = new ArrayList<>();

    public static void main(String[] args) {
        int op = -1;
        while (op != 3) {
            System.out.println("\n--- ULagosBank ---\n1. Ingresar como Ejecutivo\n2. Ingresar como Cliente\n3. Salir");
            op = leerInt("Opcion: ");
            if (op == 1) menuEjecutivo();
            else if (op == 2) menuCliente();
        }
        System.out.println("Gracias por usar ULagosBank.");
    }

    static void menuEjecutivo() {
        int op = -1;
        while (op != 5) {
            System.out.println("\n1. Crear cliente\n2. Crear ejecutivo\n3. Crear cuenta\n4. Crear cuenta joven\n5. Volver");
            op = leerInt("Opcion: ");
            if (op == 1) {
                clientes.add(crearCliente());
                System.out.println("Cliente creado.");
            } else if (op == 2) {
                ejecutivos.add(crearEjecutivo());
                System.out.println("Ejecutivo creado.");
            } else if (op == 3) {
                Cliente titular = elegirCliente();
                if (titular != null) {
                    cuentas.add(new Cuenta(titular));
                    System.out.println("Cuenta creada.");
                }
            } else if (op == 4) {
                Cliente titular = elegirCliente();
                if (titular != null) {
                    double bonificacion = leerDouble("Bonificacion (%): ");
                    cuentas.add(new CuentaJoven(titular, bonificacion));
                    System.out.println("Cuenta joven creada.");
                }
            }
        }
    }

    static void menuCliente() {
        Cliente cliente = elegirCliente();
        if (cliente == null) return;

        int op = -1;
        while (op != 4) {
            System.out.println("\n--- Cliente: " + cliente.getNombre() + " ---\n1. Seleccionar producto\n2. Depositar\n3. Retirar\n4. Volver");
            op = leerInt("Opcion: ");
            if (op == 1) {
                System.out.print("Producto: ");
                cliente.getProductos().add(sc.nextLine());
            } else if (op == 2 || op == 3) {
                Cuenta cuenta = elegirCuenta(cliente);
                if (cuenta != null) {
                    double monto = leerDouble("Monto: ");
                    if (op == 2) cuenta.deposito(monto);
                    else cuenta.retiro(monto);
                }
            }
        }
    }

    static Cliente crearCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Fecha nacimiento (AAAA-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());
        System.out.print("RUT (12345678-9): ");
        String rut = sc.nextLine();
        System.out.print("Password (10 car.): ");
        return new Cliente(nombre, fecha, rut, sc.nextLine());
    }

    static Ejecutivo crearEjecutivo() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Fecha nacimiento (AAAA-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());
        System.out.print("RUT (12345678-9): ");
        String rut = sc.nextLine();
        System.out.print("Usuario (10 car.): ");
        String usuario = sc.nextLine();
        System.out.print("Password (10 car.): ");
        return new Ejecutivo(nombre, fecha, rut, usuario, sc.nextLine());
    }

    static Cliente elegirCliente() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return null;
        }
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + ". " + clientes.get(i).getNombre());
        }
        return clientes.get(leerInt("Elija un cliente: "));
    }

    static Cuenta elegirCuenta(Cliente cliente) {
        ArrayList<Cuenta> propias = new ArrayList<>();
        for (Cuenta c : cuentas) {
            if (c.getTitular() == cliente) propias.add(c);
        }
        if (propias.isEmpty()) {
            System.out.println("Este cliente no tiene cuentas.");
            return null;
        }
        for (int i = 0; i < propias.size(); i++) {
            System.out.println(i + ". " + propias.get(i));
        }
        return propias.get(leerInt("Elija una cuenta: "));
    }

    static int leerInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }

    static double leerDouble(String msg) {
        System.out.print(msg);
        return Double.parseDouble(sc.nextLine());
    }
}

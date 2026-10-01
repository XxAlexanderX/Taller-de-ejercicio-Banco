//package banco;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String rut; // formato 12345678-9

    // Constructor vacio, como pide el enunciado
    public Persona() {
        this.nombre = "";
        this.fechaNacimiento = null;
        this.rut = "";
    }

    public Persona(String nombre, LocalDate fechaNacimiento, String rut) {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setRut(rut);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: el nombre no puede estar vacio.");
        }
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento != null && !fechaNacimiento.isAfter(LocalDate.now())) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            System.out.println("Error: la fecha de nacimiento no es valida.");
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (validarRut(rut)) {
            this.rut = rut;
        } else {
            System.out.println("Error: el RUT ingresado no es valido.");
        }
    }

    // Valida el formato (numero-dv) y el digito verificador con el algoritmo del
    // rut
    private boolean validarRut(String rut) {
        if (rut == null || !rut.matches("[0-9]+-[0-9kK]")) {
            return false;
        }

        String[] partes = rut.split("-");
        String numero = partes[0];
        char dvIngresado = Character.toUpperCase(partes[1].charAt(0));

        int suma = 0;
        int multiplicador = 2;

        for (int i = numero.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(numero.charAt(i)) * multiplicador;
            multiplicador++;
            if (multiplicador > 7) {
                multiplicador = 2;
            }
        }

        int resto = 11 - (suma % 11);
        char dvCalculado;

        if (resto == 11) {
            dvCalculado = '0';
        } else if (resto == 10) {
            dvCalculado = 'K';
        } else {
            dvCalculado = (char) (resto + '0');
        }

        return dvCalculado == dvIngresado;
    }

    public boolean esMayorDeEdad() {
        if (fechaNacimiento == null) {
            return false;
        }
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", RUT: " + rut + ", Fecha de nacimiento: " + fechaNacimiento;
    }
}

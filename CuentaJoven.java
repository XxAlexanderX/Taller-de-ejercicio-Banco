//package banco;

public class CuentaJoven {
    private double bonificacion; // porcentaje de ganancia al ahorrar

    public CuentaJoven(int password, String productos, String titular, float sueldo, float movimiento,
            double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        if (bonificacion >= 0) {
            this.bonificacion = bonificacion;
        } else {
            System.out.println("Error: la bonificacion no puede ser negativa.");
        }
    }

    // Valida que el titular tenga entre 18 y 25 anos
    public boolean esTitularValido() {
        if (titular == null) {
            return false;
        }
        int edad = calcularEdadTitular();
        return edad >= 18 && edad <= 25;
    }

    private int calcularEdadTitular() {
        java.time.LocalDate nacimiento = java.time.LocalDate.parse(titular.getFechaNacimiento());
        return java.time.Period.between(nacimiento, java.time.LocalDate.now()).getYears();
    }

    // Sobrescribe deposito() de Cuenta para agregar la bonificacion (polimorfismo)
    @Override
    public void deposito(double monto) {
        super.deposito(monto);
        bonificar(monto);
    }

    public void bonificar(double montoDepositado) {
        double ganancia = montoDepositado * (bonificacion / 100);
        saldo += ganancia;
        registrarMovimiento(ganancia);
    }

    @Override
    public String toString() {
        return super.toString() + ", Bonificacion: " + bonificacion + "%";
    }
}

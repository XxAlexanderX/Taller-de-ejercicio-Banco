package banco;

import java.time.LocalDate;

public class Ejecutivo extends Persona {
    private String usuario; // texto de 10 caracteres
    private String password; // texto de 10 caracteres

    public Ejecutivo(String nombre, LocalDate fechaNacimiento, String rut, String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario != null && usuario.length() == 10) {
            this.usuario = usuario;
        } else {
            System.out.println("Error: el usuario debe tener exactamente 10 caracteres.");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() == 10) {
            this.password = password;
        } else {
            System.out.println("Error: la contrasena debe tener exactamente 10 caracteres.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Usuario: " + usuario;
    }
}

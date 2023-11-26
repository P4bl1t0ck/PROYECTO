public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private String tipo;

    public Usuario(String nombreUsuario, String contraseña, String tipo) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTipo() {
        return tipo;
    }
}
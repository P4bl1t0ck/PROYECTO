import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Farmacia farmacia = new Farmacia();

        // Crear usuarios de ejemplo
        Usuario admin = new Usuario("admin", "adminpass", "admin");
        Usuario cliente = new Usuario("cliente", "clientepass", "cliente");

        // Agregar usuarios a la farmacia
        farmacia.agregarUsuario(admin);
        farmacia.agregarUsuario(cliente);

        // Medicinas predefinidas
        Medicina[] medicinasPredefinidas = {
                new Medicina("Naztizol", 1, 10.5, 50),
                new Medicina("Ibuprofeno", 2, 5.8, 30),
                new Medicina("Jarabe para la tos", 3, 8.75, 40)
        };

        // Agregar medicinas predefinidas al inventario
        for (Medicina medicina : medicinasPredefinidas) {
            farmacia.agregarMedicina(medicina);
        }

        // Ejemplo de inicio de sesión
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario usuarioActual = iniciarSesion(farmacia, nombreUsuario, contraseña);

        if (usuarioActual != null) {
            System.out.println("Inicio de sesión exitoso como " + usuarioActual.getTipo());

            // Menú para el usuario administrador
            if (usuarioActual.getTipo().equals("admin")) {
                menuAdministrador(farmacia, scanner);
            }
            // Otros menús para diferentes tipos de usuarios podrían ir aquí

        } else {
            System.out.println("Inicio de sesión fallido. Usuario no encontrado o contraseña incorrecta.");
        }
    }

    // Método para iniciar sesión
    private static Usuario iniciarSesion(Farmacia farmacia, String nombreUsuario, String contraseña) {
        for (Usuario usuario : farmacia.getUsuarios()) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

    // Menú para el usuario administrador
    private static void menuAdministrador(Farmacia farmacia, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Administrador ---");
            System.out.println("1. Cambiar Precio");
            System.out.println("2. Cambiar Stock");
            System.out.println("3. Compra de Productos");
            System.out.println("4. Ver Inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    OperacionesAdministrador.cambiarPrecio(farmacia, scanner);
                    break;
                case 2:
                    OperacionesAdministrador.cambiarStock(farmacia, scanner);
                    break;
                case 3:
                    OperacionesAdministrador.compraDeProductos(farmacia, scanner);
                    break;
                case 4:
                    verInventario(farmacia);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }


    // Métodos para cambiarPrecio, cambiarStock, compraDeProductos, y verInventario aquí...

    // Método para ver el inventario completo
    private static void verInventario(Farmacia farmacia) {
        System.out.println("\n--- Inventario ---");
        for (Medicina medicina : farmacia.getInventario()) {
            System.out.println(medicina.getInfo());
        }
    }

    // Otros métodos aquí...
}
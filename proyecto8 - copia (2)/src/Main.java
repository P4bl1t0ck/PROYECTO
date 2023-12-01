import java.sql.SQLOutput;
import java.util.Scanner;
/*Ya veremos como actualizarle a ventanas xdxdxdxd*/
public class Main{
    public static void main(String[] args) {
        // Crear usuarios de ejemplo

        Usuario admin = new Usuario("admin", "adminpass", "admin");
        Usuario cliente = new Usuario("cliente", "clientepass", "cliente");// contraseñas
        // Agregar usuarios a la farmacia

        Farmacia farmacia = new Farmacia();
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


        // Momento de Incio de Sesion
        Scanner scanner = new Scanner(System.in);

        try {
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
                } else {
                    menuCliente(farmacia, scanner);
                }
                // Otros menús para diferentes tipos de usuarios podrían ir aquí

            } else {
                System.out.println("Inicio de sesión fallido. Usuario no encontrado o contraseña incorrecta.");
                main(args);// it´ll repeat eveytime the password gets wrong
            }
        }catch (Exception e){
            System.out.println("Error");
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
    private static void menuCliente(Farmacia farmacia ,Scanner scanner){
        int op;
        try {
            do {
                System.out.println("\n--- Menú de compras ---");
                System.out.println("1. Comprar ");
                System.out.println("2. Ver Tienda");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                op = scanner.nextInt();
                switch (op) {
                    case 1:
                        verInvClientes(farmacia);
                        System.out.println("---------------Productos---------------");
                        OperacionesClientes.comprasCliente(farmacia, scanner);
                        break;
                    case 2:
                        verInvClientes(farmacia);
                        ofertas(farmacia);
                        break;
                    case 0:
                        break;
                }

            } while (op != 0);
        }catch(Exception e) {
            System.out.println("Error: opcion no valida" + e.getMessage());
        }

    }

    // Menú para el usuario administrador
    private static void menuAdministrador(Farmacia farmacia, Scanner scanner) {
        int opcion;

        try{
        do {
            System.out.println("\n--- Menú de Administrador ---");
            System.out.println("1. Cambiar Precio");
            System.out.println("2. Cambiar Stock");
            System.out.println("3. Agregar Producto");
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
                    menuAdministrador(farmacia,scanner);
            }
        } while (opcion != 0);
        }catch (Exception e) {
            System.out.println("Error: opcion no valida" + e.getMessage());
        }
    }


    // Métodos para cambiarPrecio, cambiarStock, compraDeProductos, y verInventario aquí...

    // Método para ver el inventario completo
    private static void verInventario(Farmacia farmacia) {
        System.out.println("\n--- Inventario ---\n");
        for (Medicina medicina : farmacia.getInventario()) {
            System.out.println(medicina.getInfo());
        }
    }
    //// ver que hay en la tienda
    private static void verInvClientes(Farmacia farmacia){
        System.out.println("\n--- Tienda ---\n");
        System.out.println("----Bienvenido a la tienda donde esta todo nuestro scuanch----");
        System.out.println("Nota: [Algunas ofertas podrian perderse al momento de carga]");
        for (Medicina medicina : farmacia.getInventario()){
            System.out.println(medicina.getInformacionClientes());
        }
    }

    private static void ofertas(Farmacia farmacia){
        System.out.println("\n-----¡¡OFERTAS!!----\n");
        for (Medicina medicina : farmacia.getInventario()){
            System.out.println("Hay ofertas del !-%50-¡ en ["+ (medicina.getId())+"] - ["+((medicina.getPrecio())/2)+"]");
        }
        System.out.println("Hay ofertas solo en dias especiales todo lo que puedas");
    }



}


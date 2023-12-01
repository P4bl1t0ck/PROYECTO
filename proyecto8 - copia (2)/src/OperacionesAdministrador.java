import java.util.Scanner;

public class OperacionesAdministrador {
    public static void cambiarPrecio(Farmacia farmacia, Scanner scanner) {
        try {
            System.out.print("Ingrese el ID del producto: ");
            int id = scanner.nextInt();
            System.out.print("Ingrese el nuevo precio: ");
            double nuevoPrecio = scanner.nextDouble();

            farmacia.cambiarPrecio(id, nuevoPrecio);

            if (farmacia.buscarMedicinaPorID(id) != null) {
                System.out.println("Precio actualizado correctamente.");
            } else {
                System.out.println("\n");
            }
        } catch (Exception e) {
            System.out.println("Error: ID no existente");
        }

    }

    public static void cambiarStock(Farmacia farmacia, Scanner scanner) {
        try {
            System.out.print("Ingrese el ID del producto: ");
            int id = scanner.nextInt();
            System.out.print("Ingrese la nueva cantidad de stock: ");
            int nuevoStock = scanner.nextInt();

            farmacia.cambiarStock(id, nuevoStock);
            if (farmacia.buscarMedicinaPorID(id) != null) {
                System.out.println("Stock actualizado correctamente.");
            } else {
                System.out.println("\n");
            }
        } catch (Exception e) {
            System.out.println("Error: Stock insuficiente");
        }

    }

    public static void compraDeProductos(Farmacia farmacia, Scanner scanner) {
        System.out.println("\n--- Compra de Productos ---");
        System.out.print("Nombre del Producto: ");
        String nombre = scanner.next();
        System.out.print("ID del Producto: ");
        int id = scanner.nextInt();
        System.out.print("Precio del Producto (con un decimal): ");
        double precio = scanner.nextDouble();
        System.out.print("Stock del Producto: ");
        int stock = scanner.nextInt();

        Medicina nuevaMedicina = new Medicina(nombre, id, precio, stock);
        farmacia.agregarMedicina(nuevaMedicina);
        System.out.println("Producto agregado correctamente.");
    }
}
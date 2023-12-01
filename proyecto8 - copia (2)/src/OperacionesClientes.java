import java.util.Scanner;
public class OperacionesClientes {
    public static void comprasCliente(Farmacia farmacia, Scanner scanner) {
        try {
            System.out.println("Ingrese el ID del producto: ");
            int id = scanner.nextInt();
            System.out.println("Ingrese la cantidad que quiere: ");
            int cant = scanner.nextInt();

            farmacia.compra(id, cant);
            System.out.println("¡Gracias por su compra!");
        } catch (Exception e) {
            System.out.println("Error: stock insuficiente" + e.getMessage());
        }
    }
}
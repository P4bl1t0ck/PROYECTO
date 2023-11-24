import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class VentaFarmacia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario los detalles del producto a vender
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el precio unitario del producto: ");
        double precioUnitario = scanner.nextDouble();

        // Calcular el total de la venta
        double total = cantidad * precioUnitario;

        // Guardar los datos en la base de datos
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia", "usuario", "contraseña");

            // Preparar la sentencia SQL para insertar los datos
            String sql = "INSERT INTO ventas (nombre_producto, cantidad, precio_unitario, total) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombreProducto);
            statement.setInt(2, cantidad);
            statement.setDouble(3, precioUnitario);
            statement.setDouble(4, total);

            // Ejecutar la sentencia SQL
            statement.executeUpdate();

            // Cerrar la conexión con la base de datos
            connection.close();

            System.out.println("La venta se ha registrado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos en la base de datos: " + e.getMessage());
        }

        // Mostrar el resumen de la venta
        System.out.println("Resumen de la venta:");
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: " + precioUnitario);
        System.out.println("Total: " + total);

        // Realizar el cobro
        System.out.print("Ingrese el monto a cobrar: ");
        double montoCobro = scanner.nextDouble();

        // Calcular el cambio
        double cambio = montoCobro - total;

        // Mostrar el cambio
        System.out.println("Cambio: " + cambio);

        // Cerrar el scanner
        scanner.close();
    }
}
Este código te permite ingresar el nombre del producto, la cantidad a vender y el precio unitario del producto. Luego, calcula el total de la venta multiplicando la cantidad por el precio unitario. A continuación, se establece una conexión con una base de datos MySQL y se insertan los datos de la venta en una tabla llamada "ventas". Finalmente, se muestra un resumen de la venta, se realiza el cobro y se calcula el cambio.

Recuerda que para que este código funcione correctamente, debes reemplazar "usuario" y "contraseña" con las credenciales adecuadas para acceder a tu base de datos MySQL.

Espero que esto te sea útil. Si tienes alguna otra pregunta, ¡no dudes en preguntar!
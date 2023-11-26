import java.util.ArrayList;
import java.util.List;

public class Farmacia {
    private List<Medicina> inventario = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Medicina> getInventario() {
        return inventario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarMedicina(Medicina medicina) {
        inventario.add(medicina);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para cambiar el precio de un producto por ID
    public void cambiarPrecio(int id, double nuevoPrecio) {
        Medicina medicina = buscarMedicinaPorID(id);
        if (medicina != null) {
            medicina.setPrecio(nuevoPrecio);
        } else {
            System.out.println("Producto no encontrado con ID " + id);
        }
    }

    // Método para cambiar el stock de un producto por ID
    public void cambiarStock(int id, int nuevoStock) {
        Medicina medicina = buscarMedicinaPorID(id);
        if (medicina != null) {
            medicina.setStock(nuevoStock);
        } else {
            System.out.println("Producto no encontrado con ID " + id);
        }
    }

    // Método para buscar una medicina por su ID
    private Medicina buscarMedicinaPorID(int id) {
        for (Medicina medicina : inventario) {
            if (medicina.getId() == id) {
                return medicina;
            }
        }
        return null;
    }
}
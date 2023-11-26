public class Medicina {
    private String nombre;
    private int id;
    private double precio;
    private int stock;

    public Medicina(String nombre, int id, double precio, int stock) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método para obtener una representación en cadena de la medicina
    public String getInfo() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio + ", Stock: " + stock;
    }
}
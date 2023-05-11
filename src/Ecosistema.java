import java.util.Vector;

public class Ecosistema {
    private String nombre;

    private Vector<BiotopoBoundary> biotopoBoundaries = new Vector<BiotopoBoundary>();

    public Ecosistema(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void addBiotopoBoundary(BiotopoBoundary biotopoBoundary) {
        biotopoBoundaries.add(biotopoBoundary);
    }

    public Vector<BiotopoBoundary> getBiotopoBoundaries() {
        return biotopoBoundaries;
    }

    @Override
    public String toString() {
        return "Ecosistema{" +
                "nombre='" + nombre + '\'' +
                ", biotopoBoundaries=" + biotopoBoundaries +
                '}';
    }
}

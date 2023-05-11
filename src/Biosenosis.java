import java.io.Serializable;

public class Biosenosis implements Serializable {
    private String nombre;

    public Biosenosis(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Biosenosis{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

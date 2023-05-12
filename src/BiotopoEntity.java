import java.io.Serializable;
import java.util.Vector;

public class BiotopoEntity implements Serializable {
    private String nombre;

    private Vector<Biosenosis> biosenosis = new Vector<Biosenosis>();

    public BiotopoEntity(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void getBiosenosis(Biosenosis biosenosis) {
        this.biosenosis.add(biosenosis);
    }

    @Override
    public String toString() {
        return "BiotopoEntity{" +
                "nombre='" + nombre + '\'' +
                ", biosenosis=" + biosenosis +
                '}';
    }
}

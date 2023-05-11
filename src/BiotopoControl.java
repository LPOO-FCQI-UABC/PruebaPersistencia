public class BiotopoControl {
    private String nombre;

    public BiotopoControl(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "BiotopoControl{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

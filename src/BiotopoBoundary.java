public class BiotopoBoundary {
    private String nombre;
    private BiotopoControl biotopoControl;

    private  BiotopoEntity biotopoEntity;

    public BiotopoBoundary(String nombre, BiotopoControl biotopoControl, BiotopoEntity biotopoEntity) {
        this.nombre = nombre;
        this.biotopoControl = biotopoControl;
        this.biotopoEntity = biotopoEntity;
    }

    public String getNombre() {
        return nombre;
    }

    public BiotopoControl getBiotopoControl() {
        return biotopoControl;
    }

    public BiotopoEntity getBiotopoEntity() {
        return biotopoEntity;
    }



    @Override
    public String toString() {
        return "BiotopoBoundary{" +
                "nombre='" + nombre + '\'' +
                ", biotopoControl=" + biotopoControl +
                ", biotopoEntity=" + biotopoEntity +
                '}';
    }
}

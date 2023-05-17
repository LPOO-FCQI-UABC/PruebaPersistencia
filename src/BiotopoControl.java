import java.io.Serializable;
import java.util.Random;

public class BiotopoControl extends Thread {
    private String nombre;
    private Random random = new Random();

    public BiotopoControl(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        int tiempo = random.nextInt(1000);
        int i = 0;
            while (i < 10) {
                try {
                    Thread.sleep(tiempo);
                    i++;
                    System.out.println("BiotopoControl{" +
                            "nombre='" + nombre + '\'' +
                            '}' + " " + i + " " + tiempo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

    @Override
    public String toString() {
        return "BiotopoControl{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}

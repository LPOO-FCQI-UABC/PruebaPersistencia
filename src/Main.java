import java.io.*;

public class Main {
    public static void main(String[] args) {

        BiotopoEntity biotopoEntity = new BiotopoEntity("BiotopoEntity 1");
        Biosenosis biosenosis = new Biosenosis("Biosenosis 1");
        biotopoEntity.getBiosenosis(biosenosis);
        Biosenosis biosenosis2 = new Biosenosis("Biosenosis 2");
        biotopoEntity.getBiosenosis(biosenosis2);

        System.out.println(biotopoEntity);

        File file = new File("biotopoEntity.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(biotopoEntity);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        BiotopoEntity biotopoEntity2 = null;

        File file2 = new File("biotopoEntity.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file2);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            biotopoEntity2 = (BiotopoEntity) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(biotopoEntity2);

    }
}
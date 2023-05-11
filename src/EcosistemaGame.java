import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class EcosistemaGame extends JDialog {
    BiotopoEntity biotopoEntity = null;
    Biosenosis biosenosis = null;
    Biosenosis biosenosis2 = null;

    BiotopoEntity biotopoEntity2 = null;
    File file = new File("biotopoEntity.txt");
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton buttonCrear;
    private JButton buttonSave;
    private JButton buttonOpen;

    public EcosistemaGame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                biotopoEntity = new BiotopoEntity("BiotopoEntity 1");
                biosenosis = new Biosenosis("Biosenosis 1");
                biotopoEntity.getBiosenosis(biosenosis);
                biosenosis2 = new Biosenosis("Biosenosis 2");
                biotopoEntity.getBiosenosis(biosenosis2);

                System.out.println(biotopoEntity);
            }
        });
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(biotopoEntity);
                    objectOutputStream.close();
                    fileOutputStream.close();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    biotopoEntity2 = (BiotopoEntity) objectInputStream.readObject();
                    objectInputStream.close();
                    fileInputStream.close();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                System.out.println(biotopoEntity2);

            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        EcosistemaGame dialog = new EcosistemaGame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

public class EcosistemaGame extends JDialog {
    BiotopoEntity biotopoEntity = new BiotopoEntity("BiotopoEntity");
    File file = new File("biotopoEntity.txt");

    Random random = new Random();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton buttonCrear;
    private JButton buttonSave;
    private JButton buttonOpen;
    private JTextPane textPane;

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
                Biosenosis biosenosis = new Biosenosis("Biosenosis " + random.nextInt(100));
                biotopoEntity.getBiosenosis(biosenosis);

                //System.out.println(biotopoEntity);
                textPane.setText(biotopoEntity.toString());

            }
        });


        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
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

            }
        });
        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                        biotopoEntity = (BiotopoEntity) objectInputStream.readObject();
                        objectInputStream.close();
                        fileInputStream.close();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                textPane.setText(biotopoEntity.toString());
                JOptionPane.showMessageDialog(null, biotopoEntity.toString());

            }
        });

        recuperarStatus();
    }

    private void recuperarStatus() {
        file = new File("biotopoEntity.txt");
        if(file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                biotopoEntity = (BiotopoEntity) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            textPane.setText(biotopoEntity.toString());
        }
    }

    private void grabarStatus(){

        file = new File("biotopoEntity.txt");
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

    private void onOK() {
        // add your code here
        dispose();
        grabarStatus();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
        grabarStatus();
    }

    public static void main(String[] args) {
        EcosistemaGame dialog = new EcosistemaGame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

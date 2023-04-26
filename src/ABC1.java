import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ABC1 extends JDialog  {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private  JTextField TextField;
    private JTextField textField2;


    public ABC1() {
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
    }

    private void onOK() {
        // add your code here
        String a=TextField.getText();
        String b=textField2.getText();
        System.out.println("First Name will be:"+" "+a+" ");
        System.out.print("Last Name will be:"+" "+b+" \n");
        TextField.setText(b);
        textField2.setText(a);
        System.out.println("After Swaping!!!");
        System.out.println("Now Fist Name will be:"+" "+b+" ");
        System.out.print("Last Name will be:"+" "+a+"\n ");
        System.out.println("task2");
        File FILE1 = new File("first_name.txt");
        try {
            FILE1.createNewFile();
            System.out.println("file created sucsessfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File FILE2 = new File("last_name.txt");
        try {
            FILE2.createNewFile();
            System.out.println("file created successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter fileWriter1 = null;
        try {
            fileWriter1 = new FileWriter(FILE1, true);
            fileWriter1.write(TextField.getText());
            fileWriter1.write("\n");
            System.out.println("Successfully added");
            fileWriter1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter fileWriter2 = null;
        try {
            fileWriter2 = new FileWriter(FILE2, true);
            fileWriter2.write(textField2.getText());
            fileWriter2.write("\n");
            System.out.println("Successfully added");
            fileWriter2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ABC1 a = new ABC1();
        a.pack();
        a.setVisible(true);
        System.exit(0);
        System.out.println();
    }
}

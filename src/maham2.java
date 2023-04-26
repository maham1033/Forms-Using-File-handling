import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class
maham2 extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;

    public maham2() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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

    private void onOK() throws IOException {
        // add your code here
        String a=textField1.getText();
        String b=textField2.getText();
        textField1.setText(b);
        textField2.setText(a);
        System.out.println("After Swaping!!!");
        System.out.println("Now Fist Name will be:"+" "+b+" ");
        System.out.print("Last Name will be:"+" "+a+"\n ");
        textField2.setText(textField1.getText());
        String c=textField2.getText();
        textField2.setText(textField1.getText());
        textField1.setText(c);
        File file = new File("src/userinfo.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(textField1.getText());
        FileWriter fileWriter1=new FileWriter(file,true);
        fileWriter1.write(textField2.getText());
        fileWriter.write(";");
        fileWriter1.write(";");
        fileWriter.flush();
        fileWriter1.flush();

        fileWriter.close();
        fileWriter1.close();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        maham2 dialog = new maham2();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

//import static sun.java2d.cmm.ColorTransform.In;

public class BankManagement extends JDialog {
    public static Bank bank = new Bank("bank");
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton accountsButton;
    private JButton clientsButton;

    public BankManagement() throws IOException, ClassNotFoundException {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(accountsButton);

        accountsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //onOK();
                ManageAccounts i = new ManageAccounts();
                i.pack();
                i.setVisible(true);
//                i.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//                BankManagement.this.setVisible(false);



            }
        });

        clientsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // onOK();
                ManageClients i = new ManageClients();
                i.pack();
                i.setVisible(true);
//                BankManagement.this.setVisible(false);


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
//        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BankManagement dialog = new BankManagement();
        Driver.loadBank();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

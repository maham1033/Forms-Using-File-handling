import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class DeleteClient extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public DeleteClient() {
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
        String cnic = textField1.getText();
        String name = textField2.getText();
        String phone = textField3.getText();

        for (int i = 0; i < BankManagement.bank.getClients().size(); i++) {
            if (BankManagement.bank.getClients().get(i).getDetails().getCNIC().equals(cnic)) {
                for (Account a : BankManagement.bank.getClients().get(i).getAccounts()) {
                    Bank.accounts.remove(a);
                    System.out.println("Account removed");
                }
                System.out.println(BankManagement.bank.getClients());
                BankManagement.bank.getClients().remove(BankManagement.bank.getClients().get(i));
                System.out.println("Client removed");
                System.out.println(BankManagement.bank.getClients());

            }
        }
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DeleteClient dialog = new DeleteClient();
        Driver.loadBank();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

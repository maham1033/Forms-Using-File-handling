import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class DeleteAccount extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public DeleteAccount() {
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
        String cnic,name,account;
        cnic = textField1.getText();
        name = textField2.getText();
        account = textField3.getText();
        for (int i = 0; i< BankManagement.bank.accounts.size(); i++){
            if (BankManagement.bank.accounts.get(i).getAccNumber().equals(account)){
                BankManagement.bank.accounts.remove(BankManagement.bank.getAccounts().get(i));
                System.out.println("Account removed");
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
        DeleteAccount dialog = new DeleteAccount();
        Driver.loadBank();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

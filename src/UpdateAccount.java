import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class UpdateAccount extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK; //deposit
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton withdrawButton;
    public UpdateAccount() {
//        amount = Integer.parseInt(amountString);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onWithdraw();
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

    private void onWithdraw() {
        String accountNum = textField2.getText();
        String cnic = textField1.getText();
        int amount = Integer.parseInt(textField3.getText());
        for (Client c : BankManagement.bank.getClients()) {
            if (cnic.equals(c.getDetails().getCNIC())) {
//                System.out.println("Enter account number: ");
//                String accountNumber = sc.next();
                for (Account a : BankManagement.bank.getAccounts()) {
                    if (accountNum.equals(a.getAccNumber())) {
//                        System.out.println("Enter amount to withdraw: ");
//                        float amountWith = sc.nextFloat();
                        a.withdraw(amount);

                        break;
                    }

                }
                break;

            }

        }
        dispose();
    }


    private void onOK() {
        String accountNum = textField2.getText();
        String cnic = textField1.getText();
        int amount = Integer.parseInt(textField3.getText());

        for (Client c : BankManagement.bank.getClients()) {
            if (cnic.equals(c.getDetails().getCNIC())) {
//                System.out.println("Enter account number: ");
//                String accountNumber = sc.next();
                for (Account a : BankManagement.bank.getAccounts()) {
                    if (accountNum.equals(a.getAccNumber())) {
//                        System.out.println("Enter amount to deposit: ");
//                        float amountDep = sc.nextFloat();
                        a.deposit(amount);
//                        System.out.println("Amount deposited successfully");
//                        System.out.println("New balance is: " + a.getAmount());
                        break;
                    }
                }
                break;
            }

        }
        dispose();
    }



    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UpdateAccount dialog = new UpdateAccount();
        Driver.loadBank();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

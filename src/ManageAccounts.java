import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class ManageAccounts extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton addAccountButton;
    private JButton deleteAccountButton;
    private JButton updateAccountButton;
    private JButton viewAccountDetailsButton;

    public ManageAccounts() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);

//        buttonOK.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onOK();
//            }
//        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAccount i=new AddAccount();
                i.pack();
                i.setVisible(true);
                //dispose();

            }
        });


        deleteAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteAccount i = new DeleteAccount();
                i.pack();
                i.setVisible(true);
            }
        });
        updateAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateAccount i=new UpdateAccount();
                i.pack();
                i.setVisible(true);
            }
        });
//        viewAccountDetailsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ViewAccountInfo i=new ViewAccountInfo();
//                i.pack();
//                i.setVisible(true);
//
//            }
//        });


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
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ManageAccounts dialog = new ManageAccounts();
        Driver.loadBank();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JDialog {
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton signUpButton;
    private JButton cancelButton;
    private JPanel loginPanel;
    private final String allowedUsername = "admin";
    private final String allowedPassword = "secret";
    public Interface(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(650,500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String password = new String(pfPassword.getPassword());

                if (username.equals(allowedUsername) && password.equals(allowedPassword)) {
                    JOptionPane.showMessageDialog(Interface.this, "Logare cu succes", "Succes", JOptionPane.INFORMATION_MESSAGE);

                    //Deschidem cea de-a doua fereastra cu dispozitivele
                    Interface2 interface2 = new Interface2(Interface.this);
                    interface2.setVisible(true);

                    dispose(); // Fereastra se inchide daca apasam cancel
                } else {
                    JOptionPane.showMessageDialog(Interface.this, "Username sau parola invalida", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Inchizi fereastra daca apesi cancel
            }
        });
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new Interface(null));
    }
}

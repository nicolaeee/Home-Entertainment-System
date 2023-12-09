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
                    JOptionPane.showMessageDialog(Interface.this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Deschideți a doua fereastră (Interface2)
                    Interface2 interface2 = new Interface2(Interface.this);
                    interface2.setVisible(true);

                    dispose(); // Închideți fereastra actuală după autentificare reușită
                } else {
                    JOptionPane.showMessageDialog(Interface.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
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

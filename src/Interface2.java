import javax.swing.*;

public class Interface2 extends JDialog {
    public Interface2(Interface parent) {openInterface2Button = new JButton("Deschide Interface2");
        loginPanel.add(openInterface2Button);

        openInterface2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interface2 interface2 = new Interface2(Interface.this); // Deschide Interface2 cu Interface ca parinte
                interface2.setVisible(true);
            }
        });

        // ... alte inițializări
    }

    // ... alte metode

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface(null));
    }
}
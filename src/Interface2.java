import javax.swing.*;
import java.awt.*;
import BogdanClasses.SoundBarBox;
public class Interface2 extends JDialog {
    private JButton DVDPlayerButton;
    private JButton TvWithSpeakersButton;
    private JButton SoundBarBoxButton;
    private JTextField conditionFieldVolume;
    private JTextField conditionFieldBass;
    private JTextField conditionFieldBalance;
    private JTextArea resultArea;
    private JButton filterButton;

    public Interface2(Interface parent) {
        setTitle("Interface2");
        setMinimumSize(new Dimension(400, 200));
        setModal(true);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel();
        conditionFieldVolume = new JTextField(15);
        conditionFieldBass = new JTextField(15);
        conditionFieldBalance = new JTextField(15);
        filterButton = new JButton("Filter Instances");
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        // Adăugare componente adiționale la panou
        panel.add(new JLabel("Filter Conditions:"));
        panel.add(new JLabel("Volume:"));
        panel.add(conditionFieldVolume);
        panel.add(new JLabel("Bass:"));
        panel.add(conditionFieldBass);
        panel.add(new JLabel("Balance:"));
        panel.add(conditionFieldBalance);
        panel.add(filterButton);
        panel.add(new JScrollPane(resultArea));

    }

    private void filterAndDisplayInstances() {
        try {
            // citire conditii
            int conditionVolume = Integer.parseInt(conditionFieldVolume.getText());
            int conditionBass = Integer.parseInt(conditionFieldBass.getText());
            int conditionBalance = Integer.parseInt(conditionFieldBalance.getText());

            // filtrare instante
            SoundBarBox[] soundBarBoxes = SoundBarBox.SoundBarBoxInstances();

            // Sterge rezultatele anterioare
            resultArea.setText("");

            // afisare care satisface conditiile
            for (SoundBarBox instance : soundBarBoxes) {
                if (instance.getVolume() > conditionVolume
                        && instance.getBass() < conditionBass
                        && instance.getBalance() == conditionBalance) {
                    resultArea.append(instance.toString() + "\n");
                }
            }
        } catch (NumberFormatException ex) {
            // input-ul nu este un nr valid
            JOptionPane.showMessageDialog(this, "Invalid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface2(null));
    }
}
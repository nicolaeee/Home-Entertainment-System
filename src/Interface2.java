import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BogdanClasses.SoundBarBox;
import BogdanClasses.TvWithSpeakers;
import BogdanClasses.DVDPlayer;
import HomeEntertainmentSystem.HomeEntertainmentSystem;
public class Interface2 extends JDialog {
    private JButton DVDPlayerButton;
    private JButton TvWithSpeakersButton;
    private JButton SoundBarBoxButton;
    private JTextField conditionFieldVolume;
    private JTextField conditionFieldBass;
    private JTextField conditionFieldBalance;
    private JTextArea resultArea;
    private JButton filterButton;
    private JButton filterAllButton;
    private JPanel MainPanel;

    public Interface2(Interface parent) {
        setTitle("Devices");
        setContentPane(MainPanel);
        setMinimumSize(new Dimension(650,500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        DVDPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateFields();
            }
        });

        TvWithSpeakersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateFields();
            }
        });

        SoundBarBoxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateFields();
            }
        });

        // Adaugare ascultator pentru butonul de filtrare
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterInstances();
            }
        });

        // Adaugare buton pentru filtrarea tuturor instanțelor
        filterAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterAllInstances();
            }
        });
    }

    // Metoda care actualizeaza campurile in functie de clasa selectata
    private void updateFields() {
        conditionFieldVolume.setText("");
        conditionFieldBass.setText("");
        conditionFieldBalance.setText("");
    }


    private void filterInstances() {
        // Implementare logica de filtrare specifica clasei selectate
    }

    private void filterAllInstances() {
        // Implementare logica de filtrare pentru toate clasele
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface2(null).setVisible(true));
    }
}
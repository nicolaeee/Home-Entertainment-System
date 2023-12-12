import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BogdanClasses.TvWithSpeakers;
import BogdanClasses.SoundBarBox;
import BogdanClasses.DVDPlayer;
import NicuClasses.SmartClimateControl;
import NicuClasses.SmartIluminatingSystem;
import NicuClasses.SmartSecuritySystem;
import javax.swing.SwingUtilities;

public class Interface2 extends JDialog {
    private JButton dvdPlayerButton;
    private JButton soundBarBoxButton;
    private JButton tvWithSpeakersButton;
    private JTextField conditionField1;
    private JTextField conditionField2;
    private JButton filterButton;
    private JPanel log;
    private JButton ft2;
    private JButton smartClimateControlButton;
    private JButton smartClimateControlButton1;
    private JButton smartIluminatingSystemButton;
    private JTextArea afisareRezultatTextArea;

    public Interface2(Interface parent) {
        setTitle("Devices Interface");
        setContentPane(log);
        setMinimumSize(new Dimension(800, 650));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        dvdPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DVDPlayer dvdPlayer = new DVDPlayer();
                dvdPlayer.ControlSpecifiedDevice();
            }
        });

        soundBarBoxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SoundBarBox soundBarBox = new SoundBarBox();
                soundBarBox.ControlSpecifiedDevice();
            }
        });

        tvWithSpeakersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TvWithSpeakers tvWithSpeakers = new TvWithSpeakers();
                tvWithSpeakers.ControlSpecifiedDevice();
            }
        });

        smartClimateControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SmartClimateControl smartClimateControl = new SmartClimateControl();
                smartClimateControl.ControlSpecifiedDevice();
            }
        });

        smartIluminatingSystemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SmartIluminatingSystem smartIluminatingSystem = new SmartIluminatingSystem();
                smartIluminatingSystem.ControlSpecifiedDevice();
            }
        });

        smartClimateControlButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SmartSecuritySystem smartSecuritySystem = new SmartSecuritySystem();
                smartSecuritySystem.ControlSpecifiedDevice();
            }
        });
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String condition1 = conditionField1.getText();
                String condition2 = conditionField2.getText();
                filterAndDisplayResults(condition1, condition2);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void filterAndDisplayResults(String condition1, String condition2) {
        boolean boolCondition1 = !condition1.isBlank();
        int intCondition2 = condition2.isBlank() ? 0 : Integer.parseInt(condition2);

        afisareRezultatTextArea.setText("Filtrare dupa conditii:\n");

        // Filter and display results for DVDPlayer
        for (DVDPlayer dvdPlayer : DVDPlayer.DVDPlayerInstances()) {
            // Filtrare pentru DVDPlayer
            if (dvdPlayer.isPoweredOn() == boolCondition1 && (dvdPlayer.isDiscInserted() ? 1 : 0) == intCondition2) {
                afisareRezultatTextArea.append(dvdPlayer.toString() + "\n");
            }
        }
    }


    private void filterAndDisplayResults() {
        afisareRezultatTextArea.append("Debug: Filtering DVDPlayer results\n");

        // Clear previous results
        afisareRezultatTextArea.setText("");

        for (DVDPlayer dvdPlayer : DVDPlayer.DVDPlayerInstances()) {
            // Apply filtering conditions for DVDPlayer
            if (dvdPlayer.isPoweredOn() && dvdPlayer.isDiscInserted()) {
                afisareRezultatTextArea.append(dvdPlayer.toString() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface2(null));
    }
}

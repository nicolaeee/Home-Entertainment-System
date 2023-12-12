import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
    private JPanel log;
    private JButton smartClimateControlButton;
    private JButton smartClimateControlButton1;
    private JButton smartIluminatingSystemButton;
    private JTextArea afisareRezultatTextArea;
    private JButton showAllButton;

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
                // conditii
                String condition1 = conditionField1.getText().toLowerCase();
                String condition2 = conditionField2.getText().toLowerCase();

                // afisez rezultatele
                displayDVDPlayerInstances(condition1, condition2);
            }
        });

        soundBarBoxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // conditii
                String condition1 = conditionField1.getText().toLowerCase();
                String condition2 = conditionField2.getText().toLowerCase();

                // afisez rezultatele
                displaySoundBarBoxInstances(condition1, condition2);
            }
        });

        tvWithSpeakersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // conditii
                String condition1 = conditionField1.getText().toLowerCase();
                String condition2 = conditionField2.getText().toLowerCase();

                // afisez rezultatele
                displayTvWithSpeakersInstances(condition1, condition2);
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
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllDevicesInstances();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayDVDPlayerInstances(String condition1, String condition2) {
        afisareRezultatTextArea.setText("");

        // filtrare si afisare
        for (DVDPlayer dvdPlayer : DVDPlayer.DVDPlayerInstances()) {
            // conditii
            boolean guiCondition1 = !dvdPlayer.isPoweredOn() == condition1.equals("oprit");

            // valoare aleatoare
            boolean randomCondition = new Random().nextBoolean();

            // afisez rezultatele
            if (guiCondition1 || randomCondition) {
                afisareRezultatTextArea.append(dvdPlayer.toString() + "\n");
            }
        }
    }

    private void displaySoundBarBoxInstances(String condition1, String condition2) {
        afisareRezultatTextArea.setText("");

        // filtrare si afisare
        for (SoundBarBox soundBarBox : SoundBarBox.SoundBarBoxInstances()) {
            // filtrare
            if ((soundBarBox.isPoweredOn() == condition1.equals("pornit")) && (soundBarBox.getVolume() > Integer.parseInt(condition2))) {
                afisareRezultatTextArea.append(soundBarBox.toString() + "\n");
            }
        }
    }

    private void displayTvWithSpeakersInstances(String condition1, String condition2) {
        afisareRezultatTextArea.setText(""); // Curăță TextArea

        // filtrare si afisare
        for (TvWithSpeakers tvWithSpeakers : TvWithSpeakers.TvWithSpeakersInstances()) {
            // conditii
            if ((tvWithSpeakers.isPoweredOn() == condition1.equals("pornit")) && (tvWithSpeakers.getVolume() > Integer.parseInt(condition2))) {
                afisareRezultatTextArea.append(tvWithSpeakers.toString() + "\n");
            }
        }
    }

    private void displayAllDevicesInstances() {
        afisareRezultatTextArea.setText("");

        // Afiseaza toate instantele de DVDPlayer
        afisareRezultatTextArea.append("DVDPlayer:\n");
        for (DVDPlayer dvdPlayer : DVDPlayer.DVDPlayerInstances()) {
            afisareRezultatTextArea.append(dvdPlayer.toString() + "\n");
        }

        // Afiseaza toate instantele de SoundBarBox
        afisareRezultatTextArea.append("\nSoundBarBox:\n");
        for (SoundBarBox soundBarBox : SoundBarBox.SoundBarBoxInstances()) {
            afisareRezultatTextArea.append(soundBarBox.toString() + "\n");
        }

        // Afiseaza toate instantele de TvWithSpeakers
        afisareRezultatTextArea.append("\nTvWithSpeakers:\n");
        for (TvWithSpeakers tvWithSpeakers : TvWithSpeakers.TvWithSpeakersInstances()) {
            afisareRezultatTextArea.append(tvWithSpeakers.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface2(null));
    }
}
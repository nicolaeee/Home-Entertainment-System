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
import MarianClasses.Consola;
import MarianClasses.SmartFridge;

import javax.swing.SwingUtilities;

public class Interface2 extends JDialog {
    private JButton dvdPlayerButton;
    private JButton soundBarBoxButton;
    private JButton tvWithSpeakersButton;
    private JTextField conditionField1;
    private JTextField conditionField2;
    private JPanel log;
    private JButton smartClimateControlButton;
    private JButton smartIluminatingSystemButton;
    private JTextArea afisareRezultatTextArea;
    private JButton showAllButton;
    private JScrollBar scrollBar1;
    private JButton SmartSecuritySystemButton;
    private JButton consolaButton;
    private JButton smartFridgeButton;

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
                // conditii
                String condition1 = conditionField1.getText().toLowerCase();
                String condition2 = conditionField2.getText().toLowerCase();

                // afisez rezultatele
                displaySmartClimateControlInstances(condition1, condition2);
            }
        });

        smartIluminatingSystemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String condition1 = conditionField1.getText().toLowerCase();
                String condition2 = conditionField2.getText().toLowerCase();
                displaySmartIluminatingSystemInstances(condition1, condition2);
            }
        });

        smartFridgeButton= new JButton("SmartFridge");
        smartFridgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String condition1=conditionField1.getText().toLowerCase();
                String condition2=conditionField2.getText().toLowerCase();

                displaySmartFridgeInstances(condition1, condition2);
            }
        });

        SmartSecuritySystemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String condition1 = conditionField1.getText().toLowerCase();
                String condition2 = conditionField2.getText().toLowerCase();
                displaySmartIluminatingSystemInstances(condition1, condition2);
            }
        });

        SmartSecuritySystemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String condition1 = conditionField1.getText().toLowerCase();
                String condition2 = conditionField2.getText().toLowerCase();
                displaySmartSecuritySystemInstances(condition1, condition2);
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTextAreaAndScrollBar();
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        consolaButton = new JButton("Consola");
        consolaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String condition1=conditionField1.getText().toLowerCase();
                String condition2=conditionField2.getText().toLowerCase();

                displayConsolaInstances(condition1, condition2);
            }
        });
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

    private void displayConsolaInstances(String condition1, String condition2) {
        afisareRezultatTextArea.setText("");

        // filtrare si afisare
        for (Consola consola : Consola.ConsolaInstances()) {
            // filtrare
            if ((consola.isPoweredOn() == condition1.equals("pornit")) && (consola.getIsConsoleConnected())) {
                afisareRezultatTextArea.append(consola.toString() + "\n");
            }
        }
    }

    private void displaySmartFridgeInstances(String condition1, String condition2) {
        afisareRezultatTextArea.setText("");

        // filtrare si afisare
        for (SmartFridge smartFridge : SmartFridge.SmartFridgeInstances()) {
            // filtrare
            if ((smartFridge.isPoweredOn() == condition1.equals("pornit")) && (smartFridge.getFoodQuantity() > Integer.parseInt(condition2))) {
                afisareRezultatTextArea.append(smartFridge.toString() + "\n");
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
        afisareRezultatTextArea.setText("");

        // filtrare si afisare
        for (TvWithSpeakers tvWithSpeakers : TvWithSpeakers.TvWithSpeakersInstances()) {
            // conditii
            if ((tvWithSpeakers.isPoweredOn() == condition1.equals("pornit")) && (tvWithSpeakers.getVolume() > Integer.parseInt(condition2))) {
                afisareRezultatTextArea.append(tvWithSpeakers.toString() + "\n");
            }
        }
    }

    private void displaySmartClimateControlInstances(String condition1, String condition2) {
        afisareRezultatTextArea.setText("");

        // Filtrare si afisare
        for (SmartClimateControl smartClimateControl : SmartClimateControl.SmartClimateControlInstances()) {
            //conditii
            if ((smartClimateControl.isHeatingOn() == condition1.equals("pornit")) && (smartClimateControl.getTemperature() > Integer.parseInt(condition2))) {
                afisareRezultatTextArea.append(smartClimateControl.toString() + "\n");
            }
        }
    }

    private void displaySmartIluminatingSystemInstances(String condition1, String condition2) {
        afisareRezultatTextArea.setText("");
        for (SmartIluminatingSystem iluminatingSystem : SmartIluminatingSystem.SmartIluminatingSystemInstances()) {
            if ((iluminatingSystem.isTurnedOn() == condition1.equals("oprit") && (iluminatingSystem.getIntensity() > Integer.parseInt(condition2)))) {
                afisareRezultatTextArea.append(iluminatingSystem.toString() + "\n");
            }
        }
    }

    private void displaySmartSecuritySystemInstances(String condition1, String condition2) {
        afisareRezultatTextArea.setText("");
        int condition2Value = Integer.parseInt(condition2);
        // Filtrare și afișare
        for (SmartSecuritySystem smartSecuritySystem : SmartSecuritySystem.SmartSecuritySystemInstances()) {
            if (!smartSecuritySystem.isAlarmActivated() == condition1.equals("dezactivat") && smartSecuritySystem.isSurveillanceOn()) {
                // Comparare cu o valoare întreagă
                if (condition2Value > 0) {
                    afisareRezultatTextArea.append(smartSecuritySystem.toString() + "\n");
                }
            }
        }
    }

    private void updateTextAreaAndScrollBar() {
        SwingUtilities.invokeLater(() -> {
            int maxValue = scrollBar1.getMaximum();
            afisareRezultatTextArea.setText("");
            // Adauga text în JTextArea pentru DVDPlayer
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

            // Afiseaza toate instantele de SmartClimateControl
            afisareRezultatTextArea.append("\nSmartClimateControl:\n");
            for (SmartClimateControl smartClimateControl : SmartClimateControl.SmartClimateControlInstances()) {
                afisareRezultatTextArea.append(smartClimateControl.toString() + "\n");
            }

            // Afiseaza toate instantele de SmartIluminatingSystem
            afisareRezultatTextArea.append("\nSmartIluminatingSystem:\n");
            for (SmartIluminatingSystem iluminatingSystem : SmartIluminatingSystem.SmartIluminatingSystemInstances()) {
                afisareRezultatTextArea.append(iluminatingSystem.toString() + "\n");
            }

            // Afiseaza toate instantele de SmartSecuritySystem
            afisareRezultatTextArea.append("\nSmartSecuritySystem:\n");
            for (SmartSecuritySystem smartSecuritySystem : SmartSecuritySystem.SmartSecuritySystemInstances()) {
                afisareRezultatTextArea.append(smartSecuritySystem.toString() + "\n");
            }

            afisareRezultatTextArea.append("\nSmartFridge:\n");
            for (SmartFridge smartFridge : SmartFridge.SmartFridgeInstances()) {
                afisareRezultatTextArea.append(smartFridge.toString() + "\n");
            }

            // Afiseaza toate instantele de Consola
            afisareRezultatTextArea.append("\nConsola:\n");
            for (Consola consola : Consola.ConsolaInstances()) {
                afisareRezultatTextArea.append(consola.toString() + "\n");
            }

            // seteaza scrollbar-ul in functie de inaltimea textului
            scrollBar1.setMaximum(afisareRezultatTextArea.getHeight());
            scrollBar1.setValue(maxValue);
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface2(null));
    }
}
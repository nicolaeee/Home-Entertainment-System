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

    public Interface2(Interface parent) {
        setTitle("Devices Interface");
        setContentPane(log);
        setMinimumSize(new Dimension(800,650));
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
                filterInstances(condition1, condition2);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void filterInstances(String condition1, String condition2) {

        boolean boolCondition1 = !condition1.isBlank();
        int intCondition2 = condition2.isBlank() ? 0 : Integer.parseInt(condition2);
        System.out.println("Filtrare dupa conditii:");

        for (DVDPlayer dvdPlayer : DVDPlayer.DVDPlayerInstances()) {
            // Filtrare pentru DVDPlayer
            if (dvdPlayer.isPoweredOn() == boolCondition1 && (dvdPlayer.isDiscInserted() ? 1 : 0) == intCondition2) {
                System.out.println(dvdPlayer.toString());
            }
        }

        for (SoundBarBox soundBarBox : SoundBarBox.SoundBarBoxInstances()) {

        }

        for (TvWithSpeakers tvWithSpeakers : TvWithSpeakers.TvWithSpeakersInstances()) {

        }

        for (SmartClimateControl smartClimateControl : SmartClimateControl.SmartClimateControlInstances()) {
            // Filtrare pentru SmartClimateControl
            if (smartClimateControl.isPoweredOn() == boolCondition1 && (smartClimateControl.isCoolingOn() ? 1 : 0) == intCondition2) {
                System.out.println(smartClimateControl.toString());
            }
        }

        for (SmartIluminatingSystem smartIluminatingSystem : SmartIluminatingSystem.SmartIluminatingSystemInstances()) {
            // Filtrare pentru SmartIluminatingSystem
            if (smartIluminatingSystem.isPoweredOn() == boolCondition1 && (smartIluminatingSystem.isTurnedOn() ? 1 : 0) == intCondition2) {
                System.out.println(smartIluminatingSystem.toString());
            }
        }

        for (SmartSecuritySystem smartSecuritySystem: SmartSecuritySystem.SmartSecuritySystemInstances()) {
            // Filtrare pentru SmartIluminatingSystem
            if (smartSecuritySystem.isPoweredOn() == boolCondition1 && (smartSecuritySystem.isSurveillanceOn() ? 1 : 0) == intCondition2) {
                System.out.println(smartSecuritySystem.toString());
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface2(null));
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton tvButton;
    private JButton soundSystemButton;
    private JButton lightsButton;

    public MainApp() {
        frame = new JFrame("Home Entertainment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        tvButton = new JButton("Control Televizor");
        soundSystemButton = new JButton("Control Sistem Audio");
        lightsButton = new JButton("Control Iluminare");

        tvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTVControlWindow();
            }
        });

        soundSystemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSoundSystemControlWindow();
            }
        });

        lightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLightsControlWindow();
            }
        });

        mainPanel.add(tvButton);
        mainPanel.add(soundSystemButton);
        mainPanel.add(lightsButton);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void openTVControlWindow() {
        JFrame tvFrame = new JFrame("Control Televizor");
        tvFrame.setSize(400, 300);
        tvFrame.setLayout(new GridLayout(3, 2));

        JLabel channelLabel = new JLabel("Canal:");
        JTextField channelField = new JTextField(10);
        JButton changeChannelButton = new JButton("Schimbă Canal");

        JLabel volumeLabel = new JLabel("Volum:");
        JTextField volumeField = new JTextField(10);
        JButton adjustVolumeButton = new JButton("Ajustează Volum");

        changeChannelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String channel = channelField.getText();
                JOptionPane.showMessageDialog(tvFrame, "Canalul a fost schimbat la: " + channel);
            }
        });

        adjustVolumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String volume = volumeField.getText();
                JOptionPane.showMessageDialog(tvFrame, "Volumul a fost ajustat la: " + volume);
            }
        });

        tvFrame.add(channelLabel);
        tvFrame.add(channelField);
        tvFrame.add(changeChannelButton);
        tvFrame.add(volumeLabel);
        tvFrame.add(volumeField);
        tvFrame.add(adjustVolumeButton);

        tvFrame.setVisible(true);
    }

    private void openSoundSystemControlWindow() {
        JFrame soundSystemFrame = new JFrame("Control Sistem Audio");
        soundSystemFrame.setSize(400, 300);
        soundSystemFrame.setLayout(new GridLayout(3, 2));

        JLabel volumeLabel = new JLabel("Volum:");
        JTextField volumeField = new JTextField(10);
        JButton adjustVolumeButton = new JButton("Ajustează Volum");

        adjustVolumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String volume = volumeField.getText();
            }
        });

        soundSystemFrame.add(volumeLabel);
        soundSystemFrame.add(volumeField);
        soundSystemFrame.add(adjustVolumeButton);

        soundSystemFrame.setVisible(true);
    }

    private void openLightsControlWindow() {
        JFrame lightsFrame = new JFrame("Control Iluminare");
        lightsFrame.setSize(400, 300);
        lightsFrame.setLayout(new GridLayout(2, 2));

        JLabel intensityLabel = new JLabel("Intensitate:");
        JTextField intensityField = new JTextField(10);
        JButton adjustIntensityButton = new JButton("Ajustează Intensitate");

        adjustIntensityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String intensity = intensityField.getText();
            }
        });

        lightsFrame.add(intensityLabel);
        lightsFrame.add(intensityField);
        lightsFrame.add(adjustIntensityButton);

        lightsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApp();
            }
        });
    }
}


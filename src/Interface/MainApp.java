package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    private JFrame frame;
    private JButton powerButton;
    private JButton volumeUpButton;
    private JButton volumeDownButton;
    private JButton bassButton;
    private JButton balanceButton;
    private JButton playButton;
    private JButton muteButton;
    private boolean isMuted = false;

    public MainApp() {
        frame = new JFrame("Control Sound Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(4, 2));

        powerButton = new JButton("Pornire/Oprit");
        volumeUpButton = new JButton("Creștere Volum");
        volumeDownButton = new JButton("Scădere Volum");
        bassButton = new JButton("Ajustare Bass");
        balanceButton = new JButton("Ajustare Balanță");
        playButton = new JButton("Redare Audio");
        muteButton = new JButton("Mute");

        final boolean[] isSoundBarOn = {false}; // Initializam off

        powerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSoundBarOn[0]) {
                    isSoundBarOn[0] = false;
                    powerButton.setText("Turn On");
                } else {
                    isSoundBarOn[0] = true;
                    powerButton.setText("Turn Off");
                }
            }
        });

        final int[] volumeLevel = {50}; // Nivelul initial al volumului

        volumeUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSoundBarOn[0]) {
                    volumeLevel[0] += 5; // Creste volumul cu 5
                }
            }
        });

        volumeDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSoundBarOn[0]) {
                    if (volumeLevel[0] >= 5) {
                        volumeLevel[0] -= 5;
                        // Aici puteți seta nivelul de volum pe Sound Bar sau alte acțiuni relevante
                        System.out.println("Volumul a fost redus la: " + volumeLevel[0]);
                    } else {
                        System.out.println("Volumul este deja la minim.");
                    }
                } else {
                    System.out.println("Soundbar-ul este oprit.");
                }
            }
        });

        bassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSoundBarOn[0]) {
                    // Implementați logica pentru ajustarea bass-ului
                    System.out.println("Bass-ul a fost ajustat.");
                } else {
                    System.out.println("Soundbar-ul este oprit.");
                }
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSoundBarOn[0]) {
                    // Implementați logica pentru ajustarea balanței
                    System.out.println("Balanta a fost ajustata.");
                } else {
                    System.out.println("Soundbar-ul este oprit.");
                }
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSoundBarOn[0]) {
                    System.out.println("Audio redat.");
                } else {
                    System.out.println("Soundbar-ul este oprit.");
                }
            }
        });

        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isMuted) {
                    muteButton.setText("Mute");
                } else {
                    muteButton.setText("Unmute");
                }
                isMuted = !isMuted;
            }
        });

        frame.add(powerButton);
        frame.add(volumeUpButton);
        frame.add(volumeDownButton);
        frame.add(bassButton);
        frame.add(balanceButton);
        frame.add(playButton);
        frame.add(muteButton);

        frame.setVisible(true);
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

package Console;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoadingPage extends JFrame {

    final JProgressBar progressBar;
    final JLabel lbl_text, lbl_message;

    public LoadingPage(){

        lbl_message = new JLabel();


        this.getContentPane().setLayout(null);
        this.setUndecorated(true);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.green);
        this.setVisible(true);


        lbl_text = new JLabel("Westminster Skin Consultation Manager");
        lbl_text.setFont(new Font("arial", Font.BOLD, 20));
        lbl_text.setBounds(100, 120, 600, 40);
        lbl_text.setForeground(Color.black);
        this.add(lbl_text);


        progressBar = new JProgressBar();
        progressBar.setBounds(100, 280, 400, 30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLACK);
        this.add(progressBar);

        runningPBar();
    }



    void runningPBar() {
        int i = 0;

        while (i <= 100) {
            try {
                Thread.sleep(15);
                progressBar.setValue(i);
                lbl_message.setText("LOADING " + Integer.toString(i) + "%");
                i++;
                if (i == 100)
                    this.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        new GUI();
    }

}

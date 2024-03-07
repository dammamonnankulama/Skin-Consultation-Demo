package Console;

import Console.Patient;
import Console.WestminsterSkinConsultationManager;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.Font;


public class AddPatient extends JFrame implements ActionListener {

    final JTextField txt_fname, txt_suraname, txt_dob, txt_mobile;
    final JButton btn_cancel, btn_save;

    Patient patient = new Patient();

    public AddPatient() {

        JDialog dialog = new JDialog(this, "", true);

        dialog.setTitle("Add Patient");
        dialog.setBounds(850,300,700,475);
        dialog.setLayout(null);



        JLabel main_heading = new JLabel("Add Patient");
        main_heading.setBounds(70, 25, 150, 30);
        main_heading.setFont(new Font("Calibri", Font.BOLD, 18));
        dialog.add(main_heading);


        JLabel lbl_id = new JLabel(patient.getPatientId(), JLabel.CENTER);
        lbl_id.setBounds(400, 25, 50, 30);
        lbl_id.setBackground(Color.GREEN);
        lbl_id.setOpaque(true);
        dialog.add(lbl_id);


        JPanel panel = new JPanel();
        panel.setBounds(40, 80, 500, 250);
        panel.setBackground(Color.white);


        JLabel lbl_fname = new JLabel("First Name *");
        lbl_fname.setBounds(100, 100, 120, 30);
        lbl_fname.setFont(new Font("Calibri", Font.PLAIN, 16));
        dialog.add(lbl_fname);

        txt_fname = new JTextField("");
        txt_fname.setBounds(270, 100, 200, 30);
        dialog.add(txt_fname);


        JLabel lbl_suraname = new JLabel("Surname *");
        lbl_suraname.setBounds(100, 150, 120, 30);
        lbl_suraname.setFont(new Font("Calibri", Font.PLAIN, 16));
        dialog.add(lbl_suraname);

        txt_suraname = new JTextField("");
        txt_suraname.setBounds(270, 150, 200, 30);
        dialog.add(txt_suraname);


        JLabel lbl_dob = new JLabel("DOB (YYYY-MM-DD) *");
        lbl_dob.setBounds(100, 200, 150, 30);
        lbl_dob.setFont(new Font("Calibri", Font.PLAIN, 16));
        dialog.add(lbl_dob);

        txt_dob = new JTextField("");
        txt_dob.setBounds(270, 200, 200, 30);
        dialog.add(txt_dob);


        JLabel lbl_mobile = new JLabel("Mobile No");
        lbl_mobile.setBounds(100, 250, 120, 30);
        lbl_mobile.setFont(new Font("Calibri", Font.PLAIN, 16));
        dialog.add(lbl_mobile);

        txt_mobile = new JTextField("");
        txt_mobile.setBounds(270, 250, 200, 30);
        dialog.add(txt_mobile);

        dialog.add(panel);


        btn_save = new JButton("Save");
        btn_save.setBounds(330, 350, 100, 30);
        btn_save.addActionListener(this);
        dialog.add(btn_save);


        btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(440, 350, 100, 30);
        btn_cancel.addActionListener(this);
        dialog.add(btn_cancel);

        dialog.setResizable(false);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == btn_save){


            if(Validation()==true){


                patient.setName(txt_fname.getText());
                patient.setSurname(txt_suraname.getText());
                patient.setDOB(txt_dob.getText());
                patient.setMobile(txt_mobile.getText());

                WestminsterSkinConsultationManager wm = new WestminsterSkinConsultationManager();


                if(wm.AddPatient(patient))
                    JOptionPane.showMessageDialog(null,
                            "Patient added sucessfully",
                            "Add Patient",
                            JOptionPane.INFORMATION_MESSAGE);

                this.dispose();
            }

        }


        if(e.getSource() == btn_cancel){
            this.dispose();
        }

    }


    Boolean Validation(){

        Boolean isError = true;

        if(txt_fname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "First Name cannot be empty", "Add Patient", JOptionPane.WARNING_MESSAGE);
            txt_fname.requestFocus();
            isError = false;

        }else if(txt_suraname.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Surname cannot be empty", "Add Patient", JOptionPane.WARNING_MESSAGE);
            txt_suraname.requestFocus();
            isError = false;

        }else if(txt_dob.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Date of Birth cannot be empty", "Add Patient", JOptionPane.WARNING_MESSAGE);
            txt_dob.requestFocus();
            isError = false;
        }

        return isError;
    }

}


package CW.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static CW.Console_Application.doctor_part;

public class GUI_Cover extends JFrame{
    JFrame frame=new JFrame();
    JPanel panel=new JPanel();
    //JLabel main_name=new JLabel("Westminster Skin Consultation Center");
    ImageIcon cover_image = new ImageIcon("Images/Cover.png");
    JLabel cover_image_lable = new JLabel(cover_image);
    ImageIcon logo = new ImageIcon("Images/west_logoOrg.png");
    JLabel logo_lable = new JLabel(logo);
    JButton doctor = new JButton("Consulter");
    JButton patient = new JButton("Patient");

    public GUI_Cover(){
        frame.setSize(1035,900);
        frame.setVisible(true);
        frame.setTitle("Westminster Skin Consultation Center");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setBackground(Color.red);

        panel.setVisible(true);
        panel.setSize(1035,900);
        panel.setLayout(null);
        panel.setBackground(new Color(237, 192, 158));

        cover_image_lable.setSize(1035,900);
        panel.add(cover_image_lable);


        logo_lable.setSize(310,150);
        logo_lable.setVisible(true);
        logo_lable.setLocation(650,230);
        cover_image_lable.add(logo_lable);

        doctor.setSize(140,70);
        doctor.setLocation(254,700);
        doctor.setFont(new Font("Times New Roman", Font.BOLD, 20));
        doctor.setBackground(new Color(212, 197, 180));
        doctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                try {
                    doctor_part();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.setVisible(false);
            }
        });
        cover_image_lable.add(doctor);

        patient.setSize(140,70);
        patient.setLocation(636,700);
        patient.setFont(new Font("Times New Roman", Font.BOLD, 20));
        patient.setBackground(new Color(212, 197, 180));
        patient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GUI_Table();
            }
        });
        cover_image_lable.add(patient);


        frame.add(panel);

    }
}

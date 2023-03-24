package CW.GUI;

import CW.Consultation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_success extends JFrame {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    ImageIcon success = new ImageIcon("Images/Success.png");
    JLabel success_lable = new JLabel(success);

    ImageIcon correct = new ImageIcon("Images/Correct.png");
    JLabel correct_Lable = new JLabel(correct);
    JLabel registered = new JLabel("Registered Successfully !");
    JLabel dr_name = new JLabel();
    JLabel app_date = new JLabel();
    JLabel app_time = new JLabel();
    JLabel cost = new JLabel( );
    JButton done = new JButton("Done");
    public GUI_success(Consultation consultation) {

        frame.setSize(1035, 900);
        frame.setVisible(true);
        frame.setTitle("Westminster Skin Consultation Center");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        panel.setVisible(true);
        panel.setSize(1035, 900);
        panel.setLayout(null);
        panel.setBackground(new Color(237, 192, 158));

        //labels
        success_lable.setSize(1035,900);
        correct_Lable.setSize(150,200);
        correct_Lable.setLocation(420,120);

        registered.setVisible(true);
        registered.setSize(500,90);
        registered.setLocation(300,50);
        registered.setFont(new Font("Times New Roman",Font.BOLD,40));
        registered.setForeground(new Color(0,0,0));

        dr_name.setLocation(150,315);
        dr_name.setFont(new Font("Times New Roman",Font.BOLD,24));
        dr_name.setForeground(new Color(0,0,0));
        dr_name.setSize(600,70);
        dr_name.setText("Doctor name : Dr."+consultation.getDoctor().getName()+" "+consultation.getDoctor().getSurname());
        dr_name.setBackground(new Color(212, 197, 180));

        app_date.setLocation(140,415);
        app_date.setFont(new Font("Times New Roman",Font.BOLD,24));
        app_date.setForeground(new Color(0,0,0));
        app_date.setSize(450,70);
        app_date.setText(" Appointment Date : " + consultation.getDate());
        app_date.setBackground(new Color(212, 197, 180));

        app_time.setLocation(140,515);
        app_time.setFont(new Font("Times New Roman",Font.BOLD,24));
        app_time.setForeground(new Color(0,0,0));
        app_time.setSize(450,70);
        app_time.setText(" Appointment Time : " + consultation.getTime());
        app_time.setBackground(new Color(212, 197, 180));

        cost.setLocation(140,615);
        cost.setFont(new Font("Times New Roman",Font.BOLD,24));
        cost.setForeground(new Color(0,0,0));
        cost.setSize(450,70);
        cost.setText(" Total Cost :  £." + consultation.getCost());
        cost.setBackground(new Color(212, 197, 180));

        done.setSize(230,70);
        done.setLocation(370,700);
        done.setFont(new Font("Times New Roman", Font.BOLD, 24));
        done.setBackground(new Color(212, 197, 180));
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GUI_Table();
            }
        });

        frame.add(panel);
        panel.add(success_lable);
        success_lable.add(registered);
        success_lable.add(correct_Lable);
        success_lable.add(dr_name);
        success_lable.add(app_date);
        success_lable.add(app_time);
        success_lable.add(cost);
        success_lable.add(done);
    }


}
